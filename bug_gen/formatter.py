import os, re

def remove_comments(code):
    # Remove single-line comments
    code = re.sub(r'//.*', '', code)
    # Remove multi-line comments
    code = re.sub(r'/\*.*?\*/', '', code, flags=re.DOTALL)
    return code

# def add_spaces_around_symbols(code):
#     # Define patterns for matching and their replacements
#     patterns = {
#         r'(\w+)\.append\((\w+)\);': r'\1.append ( \2 ) ;',  # Matches 'sb.append(rem);' and converts to 'sb.append ( rem ) ;'
#         r'public\s+(\w+)\s+(\w+)\(([^)]*)\)': r'public \1 \2 ( \3 )',  # Matches 'public String convertToBase7(int num)' and converts to 'public String convertToBase7 ( int num )'
#     }

#     for pattern, replacement in patterns.items():
#         code = re.sub(pattern, replacement, code)

#     return code

def format(code):
    """
    This function takes a Java code string, removes empty lines except the last one,
    and adds at most one space around symbols and parentheses.
    """
    # First remove comments
    code = remove_comments(code)
    
    # # Add spaces around symbols based on the defined patterns
    # code = add_spaces_around_symbols(code)
    
    # Split the code into lines
    lines = code.split('\n')

    # Remove empty lines
    formatted_lines = [line for line in lines if line.strip()]
    
    # Ensure the file ends with an empty line
    formatted_lines.append('')

    # # Function to add spaces around symbols and parentheses
    # def add_spaces(line):
    #     symbols = ['{', '}', '(', ')', '[', ']', '<', '>', '=', ';', ',']
    #     for symbol in symbols:
    #         line = line.replace(symbol, f' {symbol} ')
    #     # Remove extra spaces
    #     line = ' '.join(line.split())
    #     return line

    # # Apply the add_spaces function to each line
    # formatted_lines = [add_spaces(line) for line in formatted_lines]

    # Join the lines back into a single string
    formatted_code = '\n'.join(formatted_lines)

    return formatted_code


def format_file(file_path, formatted_file_path):
    with open(file_path, 'r') as file:
        content = file.read()
    formatted_content = format(content)
    with open(formatted_file_path, 'w') as file:
        file.write(formatted_content)

def main(folder_path, change_name=True):
    for filename in os.listdir(folder_path):
        if filename.endswith('.java') and not filename.endswith('_formatted.java'):
            file_path = os.path.join(folder_path, filename)
            formatted_file_path = os.path.join(folder_path, filename[:-5] + '_formatted.java')  # Remove '.java' and add '_formatted.java'
            format_file(file_path, formatted_file_path)
            print(f"Formatted {filename} and saved as {formatted_file_path}")

if __name__ == "__main__":
    folder_path = '.'  # Replace with the folder path
    main(folder_path, change_name=False)