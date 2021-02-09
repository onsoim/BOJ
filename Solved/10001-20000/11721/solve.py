strings = input()

for i in range(len(strings)):
	if i != 0 and i % 10 == 0: print()
	print(strings[i],end="")