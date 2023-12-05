# This script is used to copy descriptions of problems.

import os
import shutil
import glob
import re

def get_description_for_all_files(source_directory, target_directory, keep_examples=False, keep_constraints=True):
    # Create the target directory if it doesn't exist
    if not os.path.exists(target_directory):
        os.makedirs(target_directory)

    # Iterate over all Java files in the source directory
    for file_path in glob.glob(os.path.join(source_directory, '*', '*', '*.java')):
        # Define the target file path
        # Replace .java with .txt
        target_file_path = os.path.join(target_directory, os.path.basename(file_path).replace('.java', '.txt'))

        # Take the readme file, parse it, and then pass it to the target directory
        # Note that the readme file is in the same directory as the Java file
        readme_file_path = os.path.join(os.path.dirname(file_path), 'README.md')
        
        # If the readme file exists, open it, delete all <...> block.
        # Then, copy the rest of the file to the target directory.
        if os.path.exists(readme_file_path):
            with open(readme_file_path, 'r') as readme_file:
                readme_content = readme_file.read()
                readme_content = re.sub('<.*?>', '', readme_content) # Use regular expression to delete all <...> block.
                # Delete the first line (the title of the problem)
                readme_content = readme_content.split('\n', 1)[1]
                # Delete all '&nbsp;' in the file
                readme_content = readme_content.replace('&nbsp;', '')
                # Change &le; to <=, &ge; to >=, &lt; to <, &gt; to >, &amp; to &, &quot; to ", &apos; to ',
                # &ldquo; to ", &rdquo; to ", &rsquo; to ', &lsquo; to ', &hellip; to ..., &mdash; to -, &ndash; to -
                readme_content = readme_content.replace('&le;', '<=')
                readme_content = readme_content.replace('&ge;', '>=')
                readme_content = readme_content.replace('&lt;', '<')
                readme_content = readme_content.replace('&gt;', '>')
                readme_content = readme_content.replace('&amp;', '&')
                readme_content = readme_content.replace('&quot;', '"')
                readme_content = readme_content.replace('&apos;', "'")
                readme_content = readme_content.replace('&ldquo;', '"')
                readme_content = readme_content.replace('&rdquo;', '"')
                readme_content = readme_content.replace('&rsquo;', "'")
                readme_content = readme_content.replace('&lsquo;', "'")
                readme_content = readme_content.replace('&hellip;', '...')
                readme_content = readme_content.replace('&mdash;', '-')
                readme_content = readme_content.replace('&ndash;', '-')
                # Also delete all lines that are empty or with only tabs or spaces
                readme_content = os.linesep.join([s for s in readme_content.splitlines() if s.strip()])
                # Some files end with "Note:..." or " Follow up:..." or " Hint:..." 
                # Make sure to delete these lines
                readme_content = re.sub('Note:.*', '', readme_content)
                readme_content = re.sub('Follow up:.*', '', readme_content)
                readme_content = re.sub('Hint:.*', '', readme_content)
                readme_content = re.sub('Hints:.*', '', readme_content)
                # Constraints are the lines starting from "Constraints:" to the end of file
                # Make sure to include the "Constraints:" line
                constraints_content = "Constraints:" + readme_content.split('Constraints:', 1)[1]
                before_constraints_content = readme_content.split('Constraints:', 1)[0].rstrip()
                # Core of description is the lines starting from the beginning of file to "Example 1:" line or to "Example:" line
                # Make sure it does not include the "Example 1:" line or empty lines in the end
                core_content = readme_content.split('Example 1:', 1)[0].rstrip()
                core_content = core_content.split('Example:', 1)[0].rstrip()
                
                if not keep_examples and not keep_constraints:
                    readme_content = core_content
                elif not keep_examples and keep_constraints:
                    readme_content = core_content + '\n' + constraints_content
                elif keep_examples and not keep_constraints:
                    readme_content = before_constraints_content
                # else:
                #     readme_content = readme_content
                
                with open(target_file_path, 'w') as target_file:
                    target_file.write(readme_content)
                print(f"Written: {readme_file_path} to {target_file_path}")
        else:
            print(f"Cannot find: {readme_file_path}")

if __name__ == "__main__":
    source_dir = 'solutions_correct/algorithms'  # Source directory
    target_dir = 'data/description'  # Target directory where description files will be saved

    get_description_for_all_files(source_dir, target_dir, keep_examples=0, keep_constraints=1)
