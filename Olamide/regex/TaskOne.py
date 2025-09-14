import re

phone = "123-456-7890"
pattern = r"\d{3}-\d{3}-\d{4}"

print(re.match(pattern, phone))
