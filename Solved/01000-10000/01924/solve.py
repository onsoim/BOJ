week = ["SUN","MON","TUE","WED","THU","FRI","SAT"]
month = [1,4,4,0,2,5,0,3,6,1,4,6]

m, d = map(int, input().split(" "))
print(week[(month[m-1] + (d-1)) % 7])