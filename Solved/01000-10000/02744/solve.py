change = list(input())

for i in range(len(change)):
	x = ord(change[i])
	change[i] = chr(x-32) if x > 96 else chr(x+32)

print("".join(change))