python calc_code_bleu.py --refs reference_files --hyp candidate_file --lang java ( or c_sharp) --params 0.25,0.25,0.25,0.25(default)


for CARC environment set-up;
run the following command:

module purge
module load gcc/8.3.0
module load python/3.6.8
pip install tree_sitter==0.2.0
pip install nltk


for evaluation:

python calc_code_bleu.py --refs ../../bug_gen/output_txt/**_correct.txt 
--hyp ../../bug_gen/output_txt/**_refined.txt --lang java --params 0.25,0.25,0.25,0.25


python calc_code_bleu.py --refs ../references.txt --hyp ../predictions.txt --lang java --params 0.25,0.25,0.25,0.25

