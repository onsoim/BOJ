import sys

num,s = [],sys.stdin.readline
for _ in range(int(s().rstrip())):
	num.append(int(s().rstrip()))

print()
print("\n".join(str(x) for x in sorted(num)))