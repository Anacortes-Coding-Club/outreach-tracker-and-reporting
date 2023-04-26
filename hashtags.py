import yaml
import json

## Create a variable to hold the data to import
hashtags = {}


def json2yaml():
    # Open the JSON file for reading
    with open("hashtags.json", "r") as infile:
        # Marshall the JSON into the variable defined above
        hashtags = json.load(infile)
        # Print the List to the console.
        # print(os_list)

    # Open a file to write the YAML output. The 'w' makes the file writable
    with open("hashtags.yaml", "w") as outfile:
        # Marshall the YAML, setting "indent" makes the file more readable
        yaml.dump(hashtags, outfile, indent=2)
        print("YAML file written.")


def yaml2json():
    ## Read the YAML file
    with open("hashtags.yaml") as infile:
        # Marshall the YAML into the variable defined above
        hashtags = yaml.load(infile, Loader=yaml.FullLoader)
        # Print the List to the console.
        # print(os_list)

    # Open a file to write the JSON output. The 'w' makes the file writable
    with open("hashtags.json", "w") as outfile:
        # Marshall the JSON, setting "indent" makes the file more readable
        json.dump(hashtags, outfile, indent=2)
        print("JSON file written.")


if __name__ == "__main__":
    yaml2json()
    # json2yaml()
