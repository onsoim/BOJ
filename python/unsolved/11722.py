'''def big(index,N,cnt):
	global num
	if index >= N: return
	if cnt > num: num = cnt
	for i in range(index+1,N):
		if array[index] > array[i]:
			big(i,N,cnt+1)
'''
N,num = int(input()),0
array = list(map(int,input().split(" ")))
for i in range(N):
	cnt,big = 1,1001
	for j in range(i+1,N):
		if array[j] > array[i] and big > array[j]:
			cnt += 1
			big = array[j]
	if cnt > num: num = cnt
print(num)