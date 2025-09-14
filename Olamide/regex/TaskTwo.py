email = "abc@gmail.com"
pattern = r"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,}"

print(re.match(pattern, email))
