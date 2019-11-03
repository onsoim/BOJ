alpha = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]
S = input()

for i in range(len(S),0,-1): alpha[ord(S[i-1]) - 97] = i - 1
for i in range(26): alpha[i] = str(alpha[i])
print(" ".join(alpha))