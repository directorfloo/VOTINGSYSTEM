text = "Alice and Bob are Good Friends."
pattern = r"\b[A-Z][a-z]*\b"

matches = re.findall(pattern, text)
print(matches, len(matches))
