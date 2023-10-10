# CSCI499FinalProject

To call bug_gen from CLI:
`python bug_gen.py -i <Input File Path> -o <Output File Path> -n <# of bugs to introduce, default 5>`

To call bug_gen from code:
`bug_gen.add_bugs(code, num_bugs)`
Where code is a string of java code and num_bugs is the number of bugs to introduce.
Returns the `code` string, with `num_bugs` introduced in it.