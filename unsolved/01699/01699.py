def calc(n):
	i = 1
	while i * i <= n: i += 1
	return i - 1

n,count = int(input()),0
while calc(n):
	count += 1
	print(calc(n) ** 2,end=" ")
	n -= calc(n) ** 2
print()
print(count)