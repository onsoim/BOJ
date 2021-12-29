N = int(input())
n = 0

while n < N:
    n += 1
    if n + sum([ int(_) for _ in str(n)]) == N: break

print( 0 if n == N else n )
