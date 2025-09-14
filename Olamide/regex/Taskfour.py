sentence = "Hello! How are you doing?"
words = re.findall(r"\b\w+\b", sentence)
print(words)
