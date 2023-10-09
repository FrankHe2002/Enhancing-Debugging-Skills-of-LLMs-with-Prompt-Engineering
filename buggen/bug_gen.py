"""
Introduces bugs to provided Java code
"""
import bugs, test, random

def main():
    # Composite bugs
    for e in range(1000):
        applied = []
        for i in range(10):
            bt = random.randint(0, 5)
            if bt == 0:
                applied.append(bugs.MissingCharacterBug())
            elif bt == 1:
                applied.append(bugs.IncorrectOperationBug())
            elif bt == 2:
                applied.append(bugs.ArrayIndexBug())
            elif bt == 3:
                applied.append(bugs.IncorrectValueBug())
            elif bt == 4:
                applied.append(bugs.IncorrectConditionBug())
        
        code = test.CODE_2
        for bug in applied:
            code = bug.effect(code)
            print(bug.name, bug.valid)
        
        print(code)

if __name__ == '__main__':
    main()