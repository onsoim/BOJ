A,B = map(list,input().split(" "))
A,B = "".join(reversed(A)),"".join(reversed(B))
print(A if int(A) > int(B) else B)