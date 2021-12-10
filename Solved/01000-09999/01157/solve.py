alpha = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
s,feq = input(),[[-1],0]

for i in range(len(s)):
	if ord(s[i]) >= 97: alpha[ord(s[i])-97] += 1
	elif ord(s[i]) >= 65: alpha[ord(s[i])-65] += 1

for i in range(26):
	if alpha[i] > feq[1]: feq[0],feq[1] = [i],alpha[i]
	elif alpha[i] == feq[1]: feq[0].append(i)

if len(feq[0]) > 1: print("?")
else: print(chr(feq[0][0]+65))