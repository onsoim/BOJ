for i in range(int(input())):
	ox,score = input().split("X"),0
	for i in range(len(ox)):
		if ox[i]: score += (len(ox[i]) + 1) * len(ox[i]) / 2
	print(int(score))

'''
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
'''