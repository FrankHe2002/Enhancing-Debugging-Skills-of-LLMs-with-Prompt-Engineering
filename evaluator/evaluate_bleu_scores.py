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

def score_coderouge(pred, actual, hyper=(0.25, 0.25, 0.25, 0.25), log=False): # alpha, beta, gamma, theta
    # See score_codebleu for more details
    if len(pred) < len(actual):
        pred += [''] * (len(actual) - len(pred))
        print("[WARN] Padding prediction to match actual length.")
    elif len(pred) > len(actual):
        actual += [''] * (len(pred) - len(actual))
        print("[WARN] Padding actual to match prediction length.")

    tokenized_hyps = [x.split() for x in pred]
    tokenized_refs = [[x.split()] for x in actual]

    ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps, use_recall=True)

    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):# TODO Weights maybe should be modified to hypothesis tokens?
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    
    weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps, use_recall=True)
    syntax_match_score = syntax_match.corpus_syntax_match(invert([actual]), pred, "java", use_recall=True)# TODO
    dataflow_match_score = dataflow_match.corpus_dataflow_match(invert([actual]), pred, "java")

    code_bleu_score = hyper[0] * ngram_match_score\
                    + hyper[1] * weighted_ngram_match_score\
                    + hyper[2] * syntax_match_score\
                    + hyper[3] * dataflow_match_score

    if log:
        print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                            format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))
        print('CodeROUGE score: ', code_bleu_score)

    return (ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score), code_bleu_score

def score_codef1(pred, actual, hyper=(0.25, 0.25, 0.25, 0.25), log=False): # alpha, beta, gamma, theta
    # See score_codebleu for more details
    if len(pred) < len(actual):
        pred += [''] * (len(actual) - len(pred))
        print("[WARN] Padding prediction to match actual length.")
    elif len(pred) > len(actual):
        actual += [''] * (len(pred) - len(actual))
        print("[WARN] Padding actual to match prediction length.")

    tokenized_hyps = [x.split() for x in pred]
    tokenized_refs = [[x.split()] for x in actual]

    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):# TODO Weights maybe should be modified to hypothesis tokens?
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    
    ngram_match_score_p = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)
    weighted_ngram_match_score_p = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps)
    syntax_match_score_p = syntax_match.corpus_syntax_match(invert([actual]), pred, "java")
    ngram_match_score_r = bleu.corpus_bleu(tokenized_refs,tokenized_hyps, use_recall=True)
    weighted_ngram_match_score_r = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps, use_recall=True)
    syntax_match_score_r = syntax_match.corpus_syntax_match(invert([actual]), pred, "java", use_recall=True)
    dataflow_match_score = dataflow_match.corpus_dataflow_match(invert([actual]), pred, "java")

    if ngram_match_score_p + ngram_match_score_r == 0:
        nms_f1 = 0
    else:
        nms_f1 = 2 * ngram_match_score_p * ngram_match_score_r / (ngram_match_score_p + ngram_match_score_r)

    if weighted_ngram_match_score_p + weighted_ngram_match_score_r == 0:
        wnms_f1 = 0
    else:
        wnms_f1 = 2 * weighted_ngram_match_score_p * weighted_ngram_match_score_r / (weighted_ngram_match_score_p + weighted_ngram_match_score_r)

    if syntax_match_score_p + syntax_match_score_r == 0:
        sms_f1 = 0
    else:
        sms_f1 = 2 * syntax_match_score_p * syntax_match_score_r / (syntax_match_score_p + syntax_match_score_r)

    code_bleu_score = hyper[0] * nms_f1\
                    + hyper[1] * wnms_f1\
                    + hyper[2] * sms_f1\
                    + hyper[3] * dataflow_match_score

    if log:
        print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                            format(nms_f1, wnms_f1, sms_f1, dataflow_match_score))
        print('CodeF1 score: ', code_bleu_score)

    return (nms_f1, wnms_f1, sms_f1, dataflow_match_score), code_bleu_score

def reconstruct_path(bug_path):
    # The file names of the buggy paths are of the form <problem name>_<bug type>.java but the
    # file names of the fixed paths are of the form <problem name>.java, so we need to reconstruct
    # the fixed path from the buggy path. Split the path by '_' and then join everything except
    # the last element.
    if "no_bug" in bug_path:
        bug_path = bug_path.replace("no_bug", "nobug")
    
    if not '_' in bug_path:
        return bug_path
    return '_'.join(bug_path.split('_')[:-1]) + '.java'


def evaluate_folders(folder_correct, folder_bug, folder_debugged, output_path):
    df = pd.DataFrame(columns=['problem_name', 'bug_path', 'correct_path', 'debugged_path', 'bug_type',
                               'codebleu_bug', 'codebleu_debugged', 'codebleu_diff',
                               'coderouge_bug', 'coderouge_debugged', 'coderouge_diff',
                               'codef1_bug', 'codef1_debugged', 'codef1_diff', 'truncated', 'pad_bug', 'pad_correct', 'pad_debugged'])
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
            found_start = False
            for i in range(len(rdp)):
                if "```java" in rdp[i]:
                    rdp = rdp[i+1:]
                    found_start = True
                    break
            # Find last occurrence of string ``` in rdp and remove everything after that
            row['truncated'] = found_start
            if found_start:
                for i in range(len(rdp)):
                    if "```" in rdp[i]:
                        rdp = rdp[:i]
                        row['truncated'] = False
                        break

            if row['truncated']:
                print("[ERR] Code may have been truncated. No ``` found.")
                print(row['debugged_path'][0])
                print(rdp)
                row['truncated'] = True
            
            row['pad_correct'] = False
            row['pad_debugged'] = False
            row['pad_bug'] = False

            if len(rcp) < len(rdp):
                rcp += [''] * (len(rdp) - len(rcp))
                row['pad_correct'] = True
            if len(rcp) > len(rdp):
                rdp += [''] * (len(rcp) - len(rdp))
                row['pad_debugged'] = True
            
            if len(rcp) < len(rbp):
                rcp += [''] * (len(rbp) - len(rcp))
                row['pad_correct'] = True
            if len(rcp) > len(rbp):
                rbp += [''] * (len(rcp) - len(rbp))
                row['pad_bug'] = True
            

            row['codebleu_debugged'] = [score_codebleu(rcp, rdp)[1]]
            row['codebleu_bug'] = [score_codebleu(rcp, rbp)[1]]
            row['codebleu_diff'] = row['codebleu_debugged'][0] - row['codebleu_bug'][0]

            row['coderouge_debugged'] = [score_coderouge(rcp, rdp)[1]]
            row['coderouge_bug'] = [score_coderouge(rcp, rbp)[1]]
            row['coderouge_diff'] = row['coderouge_debugged'][0] - row['coderouge_bug'][0]

            row['codef1_debugged'] = [score_codef1(rcp, rdp)[1]]
            row['codef1_bug'] = [score_codef1(rcp, rbp)[1]]
            row['codef1_diff'] = row['codef1_debugged'][0] - row['codef1_bug'][0]
            rows.append(pd.DataFrame.from_dict(row))
    
    df = pd.concat([df] + rows, ignore_index=True)

    df.to_csv(output_path, index=False)
    return df


# Read files
def main():
    df = evaluate_folders('../data/formatted/correct_codes', '../data/formatted/buggy_codes', '../data/formatted/debugged_desc_codes_0_n', 'codef1_evals_desc_0_n.csv')
    print(df)
    df = evaluate_folders('../data/formatted/correct_codes', '../data/formatted/buggy_codes', '../data/formatted/debugged_desc_codes_0_c', 'codef1_evals_desc_0_c.csv')
    print(df)
    df = evaluate_folders('../data/formatted/correct_codes', '../data/formatted/buggy_codes', '../data/formatted/debugged_desc_codes_f_n', 'codef1_evals_desc_f_n.csv')
    print(df)
    df = evaluate_folders('../data/formatted/correct_codes', '../data/formatted/buggy_codes', '../data/formatted/debugged_desc_codes_f_c', 'codef1_evals_desc_f_c.csv')
    print(df)
    print("Done.")

    
if __name__ == '__main__':
    main()