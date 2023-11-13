import pandas as pd
from leetscrape.utils import get_all_questions_body
from leetscrape.GetQuestionsList import GetQuestionsList

ls = GetQuestionsList()
ls.scrape() # Scrape the list of questions
ls.to_csv(directory_path="./data/") # Save the scraped tables to a directory

# This table can be generated using the previous commnd
questions_info = pd.read_csv("./data/questions.csv")


print("Getting question bodies...")
# Scrape question body
questions_body_list = get_all_questions_body(
    questions_info["titleSlug"].tolist(),
    questions_info["paidOnly"].tolist(),
    save_to="./data/questionBody.pickle",
)

# Save to a pandas dataframe
questions_body = pd.DataFrame(
    questions_body_list
).drop(columns=["titleSlug"])
questions_body["QID"] = questions_body["QID"].astype(int)
questions_body.to_csv("./data/questionBody.csv", index=False)