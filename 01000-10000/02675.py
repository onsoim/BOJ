for i in range(int(input())):
	S = input().split(" ")
	for j in range(len(S[1])):
		print(S[1][j]*int(S[0]),end="")
	print()