import pandas as pd
import json

def save_to_csv(data, file_path):
    df = pd.DataFrame(data)
    df.to_csv(file_path, index=False)

def save_to_json(data, file_path):
    with open(file_path, "w") as f:
        json.dump(data, f, indent=4)
