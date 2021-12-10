import copy

R, C, T = map(int, input().split(' '))
house, empty = [], [ [ 0 for _ in range(C) ] for _ in range(R) ]
cleaner = 0

def diffusion():
    global house
    tmp = copy.deepcopy(empty)

    for x in range(R):
        for y in range(C):
            dif, dust = house[x][y] // 5, house[x][y]

            if dust > 4:
                if y + 1 < C and house[x][y + 1] + 1:
                    tmp[x][y + 1] += dif
                    dust -= dif

                if x + 1 < R and house[x + 1][y] + 1:
                    tmp[x + 1][y] += dif
                    dust -= dif

                if x != 0 and house[x - 1][y] + 1:
                    tmp[x - 1][y] += dif
                    dust -= dif

                if y != 0 and house[x][y - 1] + 1:
                    tmp[x][y - 1] += dif
                    dust -= dif

            tmp[x][y] += dust
    house = tmp

def circulation():
    global cleaner

    if not cleaner:
        for i in range(R):
            if house[i][0] == -1:
                cleaner = i
                break

    for i in range(cleaner - 2, -1, -1):
        house[ i + 1 ][0] = house[i][0]
    for j in range(1, C):
        house[0][ j - 1 ] = house[0][j]
    for i in range(1, cleaner + 1):
        house[ i - 1 ][ C - 1 ] = house[i][ C - 1 ]
    for j in range(C - 2, 0, -1):
        house[cleaner][ j + 1 ] = house[cleaner][j]
    house[cleaner][1] = 0

    for i in range(cleaner + 3, R):
        house[ i - 1 ][0] = house[i][0]
    for j in range(1, C):
        house[ R - 1 ][ j - 1 ] = house[ R - 1 ][j]
    for i in range(R - 2, cleaner, -1):
        house[ i + 1 ][ C - 1 ] = house[i][ C - 1 ]
    for j in range(C - 2, 0, -1):
        house[ cleaner + 1 ][ j + 1 ] = house[ cleaner + 1 ][ j]
    house[ cleaner + 1 ][1] = 0

for i in range(R):
    house += [ list(map(int, input().split(' '))) ]

while T:
    T -= 1
    diffusion()
    circulation()

count = 2
for i in range(R):
    for j in range(C):
        count += house[i][j]
print(count)