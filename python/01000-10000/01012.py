for _ in range(int(input())):
	m,n,k = map(int,input().split(" "))
	cabbage = []
	for _ in range(k):
		x,y = map(int, input().split(" "))
		cabbage.append([x,y])
	cabbage.sort()
	stack = []
	count = 0
	while True:
		if not len(stack):
			if not len(cabbage): break
			x,y = cabbage[0]
			del cabbage[0]
			count += 1
		else:
			x,y = stack[0]
			del stack[0]
		try:
			stack.append(cabbage[cabbage.index([x,y-1])])
			del cabbage[cabbage.index([x,y-1])]
		except: pass
		try:
			stack.append(cabbage[cabbage.index([x-1,y])])
			del cabbage[cabbage.index([x-1,y])]
		except: pass
		try:
			stack.append(cabbage[cabbage.index([x+1,y])])
			del cabbage[cabbage.index([x+1,y])]
		except: pass
		try:
			stack.append(cabbage[cabbage.index([x,y+1])])
			del cabbage[cabbage.index([x,y+1])]
		except: pass
	print(count)