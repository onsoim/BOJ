tile,n = [0,1,2],int(input())
if n > 2:
	for i in range(3,n+1,1):
		tile.append((tile[i-1]+tile[i-2])%10007)
print(tile[n])