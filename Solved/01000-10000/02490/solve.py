for _ in range(3):
	game,cnt = input().split(" "),0
	for i in range(4):
		if game[i] == "0": cnt += 1
	if cnt == 1: print("A")
	elif cnt == 2: print("B")
	elif cnt == 3: print("C")
	elif cnt == 4: print("D")
	else: print("E")