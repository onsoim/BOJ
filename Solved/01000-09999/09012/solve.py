for i in range(int(input())):
	count,flag,s = 0,1,input()
	for j in range(len(s)):
		if s[j] == "(": count += 1
		else: count -= 1
		if count < 0:
			flag = 0
			break
	print("YES" if flag and not count else "NO")
'''
())(()
'''