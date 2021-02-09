num,count = int(input()),0

for i in range(1,num + 1,1):
	if i < 100: count += 1
	elif int(str(i)[0])-int(str(i)[1]) == int(str(i)[1])-int(str(i)[2]): count += 1
print(count)