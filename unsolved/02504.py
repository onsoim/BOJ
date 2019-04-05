_in,stack,score,sub = list(input()),[],0,1

for i in range(len(_in)):
	if _in[i] == "(" or _in[i] == "[":
		stack.append(_in[i])
	else:
		tmp = stack.pop()
		if not len(stack):
			if tmp == "(" and _in[i] == ")":
				score += 2 * sub
				sub = 1
			elif tmp == "[" and _in[i] == "]":
				score += 3 * sub
				sub = 1
			else: 
				print("0")
				exit(0)
		else:
			if tmp == "(" and _in[i] == ")":
				sub	*= 2
			elif tmp == "[" and _in[i] == "]":
				sub *= 3
			else:
				print("0")
				exit(0)
print(score)