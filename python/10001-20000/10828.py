stack = []
def empty(stack): return 0 if len(stack) else 1

for i in range(int(input())):
	command = input().split(" ")
	if len(command) != 2:
		if command[0] == "top":
			if not empty(stack): print(stack[len(stack)-1])
			else: print("-1")
		if command[0] == "size":
			print(len(stack))
		if command[0] == "empty":
			print(empty(stack))
		if command[0] == "pop":
			if not empty(stack):
				print(stack[len(stack)-1])
				del stack[len(stack)-1]
			else: print("-1")
	else: stack.append(command[1])
