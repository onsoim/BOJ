count = 0
for i in range(int(input())):
	s,dup,flag = list(input()),[],1
	# remove continuous character
	for j in range(1,len(s),1):
		if s[j-1] == s[j]: dup.append(j-1)
	dup.sort(reverse=True)
	for j in dup: del s[j]
	# check group word
	s.sort()
	for j in range(1,len(s),1):
		if s[j-1] == s[j]:
			flag = 0
			break
	if flag: count +=1
print(count)

'''
aaa is group word
'''