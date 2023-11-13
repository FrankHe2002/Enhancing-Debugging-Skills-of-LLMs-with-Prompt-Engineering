# Modified from calc_code_bleu.py

import argparse
import CodeBLEU.bleu as bleu
import CodeBLEU.weighted_ngram_match as weighted_ngram_match
import CodeBLEU.syntax_match as syntax_match
import CodeBLEU.dataflow_match as dataflow_match

def score(pred, actual, hyper=(0.25, 0.25, 0.25, 0.25)): # alpha, beta, gamma, theta
    # pred/actual are lists of strings

    # First, make sure x and y have the same length by padding
    if len(pred) < len(actual):
        pred += [''] * (len(actual) - len(pred))
    elif len(pred) > len(actual):
        actual += [''] * (len(pred) - len(actual))

    # calculate ngram match (BLEU).
    # We're supposed to pass in a list of (list of (list of token)) as
    # reference and a list of (list of token) as hypothesis, where references[i] = list of references
    # for hypothesis[i], and references[i][j] is a list of tokens corresponding to the list of tokens hypothesis[i].

    # For us, each line is a hypothesis, and we only have one reference for each line.

    tokenized_hyps = [x.split() for x in pred]
    tokenized_refs = [[x.split()] for x in actual]
    print(tokenized_hyps)
    print(tokenized_refs)

    
    print(len(tokenized_hyps), len(tokenized_refs))
    ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)

    # calculate weighted ngram match
    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps)

    # calculate syntax match
    syntax_match_score = syntax_match.corpus_syntax_match(actual, pred, "java")

    # calculate dataflow match
    dataflow_match_score = dataflow_match.corpus_dataflow_match(actual, pred, "java")

    code_bleu_score = hyper[0] * ngram_match_score\
                    + hyper[1] * weighted_ngram_match_score\
                    + hyper[2] * syntax_match_score\
                    + hyper[3] * dataflow_match_score

    print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                        format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))
    print('CodeBLEU score: ', code_bleu_score)

    return (ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score), code_bleu_score


print(score(['public static void main(String[] args) {', 'System.out.println("Hello");', 'return 0; }'], 
            ['public static void main(String[] args) {', 'System.out.println("World!");', 'return 0; }']
            , hyper=(0.25, 0.25, 0.25, 0.25)))