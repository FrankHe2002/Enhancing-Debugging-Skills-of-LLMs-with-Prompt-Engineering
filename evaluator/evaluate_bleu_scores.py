# Modified from calc_code_bleu.py

import argparse
import CodeBLEU.bleu as bleu
import CodeBLEU.weighted_ngram_match as weighted_ngram_match
import CodeBLEU.syntax_match as syntax_match
import CodeBLEU.dataflow_match as dataflow_match

import pandas as pd
import os, re
from tqdm import tqdm

def invert(a):
    # a is a list of lists. Invert it.
    return list(map(list, zip(*a)))

def remove_comments(code):
    # Remove single-line comments
    code = re.sub(r'//.*', '', code)
    # Remove multi-line comments
    code = re.sub(r'/\*.*?\*/', '', code, flags=re.DOTALL)
    return code


def score_codebleu(pred, actual, hyper=(0.25, 0.25, 0.25, 0.25), log=False): # alpha, beta, gamma, theta
    # pred/actual are lists of strings (lines)

    # First, make sure x and y have the same length by padding
    if len(pred) < len(actual):
        pred += [''] * (len(actual) - len(pred))
        print("[WARN] Padding prediction to match actual length.")
    elif len(pred) > len(actual):
        actual += [''] * (len(pred) - len(actual))
        print("[WARN] Padding actual to match prediction length.")

    # calculate ngram match (BLEU).
    # We're supposed to pass in a list of (list of (list of token)) as
    # reference and a list of (list of token) as hypothesis, where references[i] = list of references
    # for hypothesis[i], and references[i][j] is a list of tokens corresponding to the list of tokens hypothesis[i].

    # For us, each line is a hypothesis, and we only have one reference for each line.

    tokenized_hyps = [x.split() for x in pred]
    tokenized_refs = [[x.split()] for x in actual]

    ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)

    # calculate weighted ngram match
    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps)

    # calculate syntax match
    syntax_match_score = syntax_match.corpus_syntax_match(invert([actual]), pred, "java")

    # calculate dataflow match
    dataflow_match_score = dataflow_match.corpus_dataflow_match(invert([actual]), pred, "java")

    code_bleu_score = hyper[0] * ngram_match_score\
                    + hyper[1] * weighted_ngram_match_score\
                    + hyper[2] * syntax_match_score\
                    + hyper[3] * dataflow_match_score

    if log:
        print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                            format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))
        print('CodeBLEU score: ', code_bleu_score)

    return (ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score), code_bleu_score

def reconstruct_path(bug_path):
    # The file names of the buggy paths are of the form <problem name>_<bug type>.java but the
    # file names of the fixed paths are of the form <problem name>.java, so we need to reconstruct
    # the fixed path from the buggy path. Split the path by '_' and then join everything except
    # the last element.
    if "no_bug" in bug_path:
        bug_path = bug_path.replace("no_bug", "nobug")
    return '_'.join(bug_path.split('_')[:-1]) + '.java'


def evaluate_folders(folder_correct, folder_bug, folder_debugged):
    df = pd.DataFrame(columns=['problem_name', 'bug_path', 'correct_path', 'debugged_path', 'bug_type', 'ngram_match', 'weighted_ngram_match', 'syntax_match', 'dataflow_match', 'codebleu_bug', 'codebleu_debugged', 'difference'])
    rows = []

    for filename in tqdm(os.listdir(folder_debugged)):
        if filename.endswith('.java'):
            row = {}
            row['problem_name'] = [filename[:-5]]
            row['bug_path'] = [os.path.join(folder_bug, filename)]
            row['correct_path'] = [os.path.join(folder_correct, reconstruct_path(filename))]
            row['debugged_path'] = [os.path.join(folder_debugged, filename)]
            row['bug_type'] = [filename.split('_')[-1][:-5]]
            # Read the files
            with open(row['bug_path'][0], 'r') as f:
                rbp = f.read()
            with open(row['correct_path'][0], 'r') as f:
                rcp = f.read()
            with open(row['debugged_path'][0], 'r') as f:
                rdp = f.read()
            
            # Remove comments on all
            rbp = remove_comments(rbp).split('\n')
            rcp = remove_comments(rcp).split('\n')
            rdp = remove_comments(rdp).split('\n')

            # Remove empty lines for all, and also import statements (import java.)
            rbp = [line for line in rbp if (line.strip() != "" and not 'import java.' in line)]
            rcp = [line for line in rcp if (line.strip() != "" and not 'import java.' in line)]
            rdp = [line for line in rdp if (line.strip() != "" and not 'import java.' in line)]

            # Find last occurrence of string ```java in rdp and remove everything before that
            for i in range(len(rdp)):
                if "```java" in rdp[i]:
                    rdp = rdp[i+1:]
                    break
            # Find last occurrence of string ``` in rdp and remove everything after that
            for i in range(len(rdp)):
                if "```" in rdp[i]:
                    rdp = rdp[:i]
                    break
            
            row['codebleu_debugged'] = [score_codebleu(rcp, rdp)[1]]
            row['codebleu_bug'] = [score_codebleu(rcp, rbp)[1]]
            row['difference'] = row['codebleu_debugged'][0] - row['codebleu_bug'][0]
            rows.append(pd.DataFrame.from_dict(row))
    
    df = pd.concat([df] + rows, ignore_index=True)

    df.to_csv(f'codebleu_evals_f_n.csv', index=False)
    return df


# Read files
def main():
    df = evaluate_folders('../data/formatted/correct_codes', '../data/formatted/buggy_codes', '../data/formatted/debugged_codes_f_n')
    print(df)

    
if __name__ == '__main__':
    main()