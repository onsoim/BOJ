r_equal,r_minus,r_j = ["c","s","z"],["c","d"],["l","n"]
s = input()
count = len(s)
for i in range(1,count,1):
	if (s[i] == "-" and s[i-1] in r_minus) or (s[i] == "j" and s[i-1] in r_j):
		count -= 1
	elif s[i] == "=" and s[i-1] in r_equal:
		count -= 1
		try:
			if s[i-2] == "d": count -= 1
		except: pass
print(count)