N = int(input())
calc,cnt = N % 10 * 10 + ((N - N % 10) // 10 + (N % 10)) % 10,1
while calc != N:
	calc = calc % 10 * 10 + ((calc - calc % 10) // 10 + (calc % 10)) % 10
	cnt += 1
print(cnt)