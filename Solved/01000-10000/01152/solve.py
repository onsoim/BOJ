num = input().split(" ")
count = len(num)

for i in range(len(num)):
	if not num[i]: count -= 1
print(count)