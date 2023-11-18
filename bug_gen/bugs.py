import re, random

def find_variables(code):
    """Finds all variables in the code, excluding function names, keywords."""
    keywords = ["public", "private", "if", "else", "for", "while", "do", "switch", "case", "break", "continue", "return", "try", "catch", "finally", "throw", "throws", "default", "import", "package", "class", "interface", "extends", "implements", "static", "final", "void", "int", "long", "double", "float", "char", "byte", "short", "boolean", "String", "null", "true", "false", "new", "this", "super", "instanceof", "enum", "assert", "const", "goto"]
    functions = [x[:-1] for x in re.findall(r"[A-Za-z_][A-Za-z0-9_]*\(", code)]
    variables = re.findall(r"[A-Za-z_][A-Za-z0-9_]*", code)
    # Note that variables can also contain class names, but that's fine
    return list(set([variable for variable in variables if variable not in keywords and variable not in functions]))

def find_variables_int(code):
    """Find all variables that are integers."""
    # Use regex to find all variable declarations that start with an int (e.g. int x = 3, y = 2, z = 3;) and then find all variables in that declaration
    variables = []
    for declaration in re.findall(r"int [A-Za-z0-9_ =,]* [A-Za-z_][A-Za-z0-9_]* = [A-Za-z0-9_ =,]*;", code):
        
        variables += re.findall(r"[A-Za-z_][A-Za-z0-9_]*", declaration[3:])
    functions = [x[:-1] for x in re.findall(r"[A-Za-z_][A-Za-z0-9_]*\(", code)]
    return list(set([variable for variable in variables if variable not in functions]))

class BugBase:
    def __init__(self):
        self.name = "base"

        # State is a string that describes the bug, e.g. "an array index was replaced with a random variable"
        self.state = ""
        
    def effect(self, code):
        pass

class ArrayIndexBug(BugBase):
    def __init__(self):
        super().__init__()
        self.name = "index"
        
    def effect(self, code):
        """Introduces an array index bug to the provided code."""
        
        # Get all array accesses
        accesses = re.findall(r"\[[A-Za-z0-9_]+\]", code)

        if len(accesses) == 0:
            self.valid = False
            return code
        self.valid = True
        # Choose a random array access; not that this could also be an array declaration
        access = random.choice(accesses)
        expression = access[1:-1]

        # Three choices: Replace with random variable, replace with random int, or add a random number to the expression
        choice = random.randint(0, 2)
        if choice == 0:
            # Replace with random variable
            variable = random.choice(find_variables(code))
            code = code.replace(access, "[" + variable + "]", 1)
            self.state = "an array index was replaced with another integer variable"
        elif choice == 1:
            # Replace with random int
            code = code.replace(access, f"[{random.randint(-1, 3)}]", 1)
            self.state = "an array index was replaced with another integer"
        else:
            # Add a random number to the expression, but only if it's a variable or a variable plus a number
            if re.match(r"[A-Za-z_][A-Za-z0-9_]*", expression):
                # It's just a variable
                code = code.replace(access, "[" + expression + random.choice([" - 1", " + 1", " + 2"]) + "]", 1)
                self.state = "an array index had a number added to it"
            elif re.match(r"[A-Za-z_][A-Za-z0-9_]* [+-] [0-9]+", expression):
                # It's a variable plus a number
                code = code.replace(access, "[" + expression.split()[0] + random.choice([" - 1", " + 1", " + 2"]) + "]", 1)
                self.state = "an array index had a number added to it"
            else:
                # Try again.
                return self.effect(code)
        return code

class MissingCharacterBug(BugBase):
    def __init__(self):
        super().__init__()
        self.name = "character"
    
    def effect(self, code):
        """Introduces a missing character bug to the provided code, specifically a parenthesis, bracket, brace, or semicolon."""
        
        # Get indices of all characters that could be removed
        indices = []
        for i in range(len(code)):
            if code[i] in "([{;}])":
                indices.append(i)
        
        # If there are no characters that can be removed, return the code unchanged
        if len(indices) == 0:
            self.valid = False
            return code
        self.valid = True

        # Choose a random index and remove
        index = random.choice(indices)
        self.state = f"a {code[index]} was removed"

        code = code[:index] + code[index + 1:]

        return code


class IncorrectOperationBug(BugBase):
    def __init__(self):
        super().__init__()
        self.name = "operation"
    
    def effect(self, code):
        """Introduces an incorrect operation bug to the provided code, specifically a +, -, *, /, or %."""
        
        # Get indices of all characters that could be removed, except ++ and --.
        indices = []
        for i in range(1, len(code) - 1):
            if code[i] in "+-*/%":
                # Check if it's ++ or --
                if code[i + 1] == code[i] or code[i - 1] == code[i]:
                    continue
                # Check if it's a comment
                if code[i - 1:i + 1] == "//" or code[i:i + 2] == "//":
                    continue
                if code[i - 1:i + 1] == "/*" or code[i - 1:i + 1] == "*/":
                    continue
                if code[i:i + 2] == "/*" or code[i:i + 2] == "*/":
                    continue

                # Also make sure it's not a negative number
                if code[i] == "-" and code[i + 1] in "0123456789":
                    continue
                indices.append(i)
        
        # If there are no operations, return the code unchanged
        if len(indices) == 0:
            self.valid = False
            return code
        self.valid = True

        # Choose a random index and remove
        index = random.choice(indices)
        replacement = random.choice(["+", "-", "*", "/", "%"])
        self.state = f"a {code[index]} was replaced with a {replacement}"
        code = code[:index] + replacement + code[index + 1:]

        return code
    
class IncorrectValueBug(BugBase):
    def __init__(self):
        super().__init__()
        self.name = "value"
    
    def effect(self, code):
        """Replaces a defined/constant integer with a random other value."""
        
        # Get starting indices of all integers (counting consecutive digits as one integer)
        integers = []
        cur = -1
        for i in range(len(code)):
            # Start new integer
            if code[i] in "0123456789":
                if cur == -1:
                    cur = i
            else:
                # End integer
                if cur != -1:
                    # Store start/end index of integer
                    integers.append((cur, i))
                    cur = -1
        
        # If there are no integers, return the code unchanged
        if len(integers) == 0:
            self.valid = False
            return code
        self.valid = True

        # Choose a random integer and replace it with a random value
        index = random.choice(integers)
        # Replace with the integer * 2, +/- 1, or just the number -1, 1, or 2.
        choice = random.randint(0, 2)
        if choice == 0:
            # Replace with the integer * 2
            self.state = f"the integer {code[index[0]:index[1]]} was multiplied by 2"
            code = code[:index[0]] + str(int(code[index[0]:index[1]]) * 2) + code[index[1]:]
        elif choice == 1:
            # Replace with the integer +/- 1
            dx = random.choice([-1, 1])
            self.state = f"the integer {code[index[0]:index[1]]} was added to by {dx}"
            code = code[:index[0]] + str(int(code[index[0]:index[1]]) + dx) + code[index[1]:]
        else:
            # Replace with -1, 0, 1, or 2.
            c = random.choice([-1, 0, 1, 2])
            self.state = f"the integer {code[index[0]:index[1]]} was replaced with {c}"
            code = code[:index[0]] + str(c) + code[index[1]:]

        return code
    
class IncorrectConditionBug(BugBase):
    def __init__(self):
        super().__init__()
        self.name = "condition"
    
    def effect(self, code):
        """Replaces a boolean condition with a random other condition."""

        # Find indices of all conditions with regex
        indices = []
        last = ""
        for i in range(len(code)):
            if code[i] == "=":
                if last == "=" or last == "!" or last == "<" or last == ">":
                    # Store index of condition and the exact condition
                    indices.append((i - 1, code[i - 1] + code[i]))
            elif last == "<" or last == ">":
                if code[i] != "=":
                    indices.append((i - 1, code[i - 1]))
            last = code[i]

        # Remove conditions that aren't surrounded by spaces
        indices = [index for index in indices if index[0] > 0 and index[0] < len(code) - 2 and code[index[0] - 1] == " " and (code[index[0] + 2] == " " or code[index[0] + 1] == " ")]

        
        # If there are no conditions, return the code unchanged
        if len(indices) == 0:
            self.valid = False
            return code
        self.valid = True

        # Choose a random index and replace
        index = random.choice(indices)
        
        # Replace anything in (<, >, <=, >=) with one of the others
        s = ["<", ">", "<=", ">="]
        if index[1] in ["<", ">", "<=", ">="]:
            s.remove(index[1])
            c = random.choice(s)
            self.state = f"a condition {index[1]} was replaced with {c}"
            code = code[:index[0]] + c + code[index[0] + len(index[1]):]

        # Or, replace == with != or vice versa
        elif index[1] == "==":
            self.state = f"a condition {index[1]} was replaced with !="
            code = code[:index[0]] + "!=" + code[index[0] + len(index[1]):]
        elif index[1] == "!=":
            self.state = f"a condition {index[1]} was replaced with =="
            code = code[:index[0]] + "==" + code[index[0] + len(index[1]):]
        return code


# Capitalize keyword?