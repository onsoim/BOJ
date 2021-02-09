origin = input()
origin, compare = origin.split(" "), origin.split(" ")
compare.sort()

if origin == compare: print("ascending")
else:
	compare.sort(reverse=True)
	if origin == compare: print("descending")
	else: print("mixed")