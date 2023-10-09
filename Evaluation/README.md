1. Install dependencies:
```
pip install gitpython
```

2. Clone CodeBLEU repo:
```
git clone https://github.com/microsoft/CodeXGLUE.git
``` 

3. Navigate to CodeBLEU directory:
```
cd CodeXGLUE/Code-Code/code-to-code-trans/evaluator/evaluator.py
```

4. Use CodeBLEU:
- To calculate CodeBLEU score:
```
python evaluator.py -ref <path-to-reference-code> -pre <path-to-hypothesis-code>
```
