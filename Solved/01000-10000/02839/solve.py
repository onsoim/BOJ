kg = int(input())
_5 = int(kg / 5)
remain = kg - _5 * 5

for i in range(_5,-1,-1):
	if remain % 3 == 0:
		print(i + int(remain/3))
		exit()
	else: remain += 5
print("-1")