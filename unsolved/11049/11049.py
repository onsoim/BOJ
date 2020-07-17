num, calc = int(input()) - 1, 0

base1, base2 = map(int, input().split(" "))

for i in range(num):
	matrix = input().split(" ")
	calc += ( base1 * int(matrix[0]) * int(matrix[1]) )
print(calc)

# 곱셈의 순서에 따라 연산의 횟수가 달라지는데, 이를 수정해야 함