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

    tokenized_hyps = [[x.split() for x in pred]]
    references = []
    for i in range(len(hypothesis)):
        ref_for_instance = []
        # pre_references[j][i] is the i-th line in the j-th reference
        for j in range(len(pre_references)):
            ref_for_instance.append(pre_references[j][i])
        # ref_for_instance is a list of the i-th lines in all references
        references.append(ref_for_instance)
    
    tokenized_refs = [[x.split() for x in reference] for reference in references]

    
    print(len(tokenized_hyps[0]), len(tokenized_refs))
    ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)

    # calculate weighted ngram match
    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps)

    # calculate syntax match
    syntax_match_score = syntax_match.corpus_syntax_match([actual], pred, "java")

    # calculate dataflow match
    dataflow_match_score = dataflow_match.corpus_dataflow_match([actual], pred, "java")

    print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                        format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))

    code_bleu_score = hyper[0] * ngram_match_score\
                    + hyper[1] * weighted_ngram_match_score\
                    + hyper[2] * syntax_match_score\
                    + hyper[3] * dataflow_match_score

    print('CodeBLEU score: ', code_bleu_score)


print(score(['a', 'b', 'c'], ['a', 'b', 'c'], hyper=(0.25, 0.25, 0.25, 0.25)))

"""
    

parser = argparse.ArgumentParser()
parser.add_argument('--refs', type=str, nargs='+', required=True,
                        help='reference files')
parser.add_argument('--hyp', type=str, required=True, 
                        help='hypothesis file')
parser.add_argument('--params', type=str, default='0.25,0.25,0.25,0.25',
                        help='alpha, beta and gamma')

args = parser.parse_args()

lang = args.lang
alpha,beta,gamma,theta = [float(x) for x in args.params.split(',')]

# preprocess inputs
# pre_references[i] = [all lines for this reference]
pre_references = [[x.strip() for x in open(file, 'r', encoding='utf-8').readlines()] \
                for file in args.refs]
hypothesis = [x.strip() for x in open(args.hyp, 'r', encoding='utf-8').readlines()]

# Make sure inputs have same # of lines (perhaps we should just pad if not?)
for i in range(len(pre_references)):
    assert len(hypothesis) == len(pre_references[i])

references = []
for i in range(len(hypothesis)):
    ref_for_instance = []
    # pre_references[j][i] is the i-th line in the j-th reference
    for j in range(len(pre_references)):
        ref_for_instance.append(pre_references[j][i])
    # ref_for_instance is a list of the i-th lines in all references
    references.append(ref_for_instance)

assert len(references) == len(pre_references)*len(hypothesis)

# references[i] = [list of the i-th lines in all instances]
# hypothesis[i] = i-th line in hypothesis
# calculate ngram match (BLEU)
tokenized_hyps = [x.split() for x in hypothesis]
tokenized_refs = [[x.split() for x in reference] for reference in references]

ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)

# calculate weighted ngram match
keywords = [x.strip() for x in open('keywords/java.txt', 'r', encoding='utf-8').readlines()]
def make_weights(reference_tokens, key_word_list):
    return {token:1 if token in key_word_list else 0.2 \
            for token in reference_tokens}
tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)]\
            for reference_tokens in reference] for reference in tokenized_refs]

weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights,tokenized_hyps)

# calculate syntax match
syntax_match_score = syntax_match.corpus_syntax_match(references, hypothesis, "java")

# calculate dataflow match
dataflow_match_score = dataflow_match.corpus_dataflow_match(references, hypothesis, "java")

print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                    format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))

code_bleu_score = alpha*ngram_match_score\
                + beta*weighted_ngram_match_score\
                + gamma*syntax_match_score\
                + theta*dataflow_match_score

print('CodeBLEU score: ', code_bleu_score)





"""