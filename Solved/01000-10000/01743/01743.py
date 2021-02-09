N,M,K = map(int, input().split(" "))

garbage = []
for _ in range(K):
	X,Y = map(int, input().split(" "))
	garbage.append([X,Y])
garbage.sort()

stack,component,count = [],0,0
while True:
	if not len(stack):
		if component < count: component = count
		if not len(garbage): break
		x,y = garbage[0]
		del garbage[0]
		count = 1
	else:
		x,y = stack[0]
		del stack[0]
		count += 1
	try:
		stack.append(garbage[garbage.index([x,y-1])])
		del garbage[garbage.index([x,y-1])]
	except: pass
	try:
		stack.append(garbage[garbage.index([x-1,y])])
		del garbage[garbage.index([x-1,y])]
	except: pass
	try:
		stack.append(garbage[garbage.index([x+1,y])])
		del garbage[garbage.index([x+1,y])]
	except: pass
	try:
		stack.append(garbage[garbage.index([x,y+1])])
		del garbage[garbage.index([x,y+1])]
	except: pass
print(component)
