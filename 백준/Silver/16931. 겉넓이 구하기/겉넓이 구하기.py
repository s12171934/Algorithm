n, m = map(int, input().split(" "))
list = []
for i in range(n) : list.append([*map(int, input().split(" "))])
blocks = sum(map(sum, list))

A = blocks * 6

B = (blocks - n * m) * 2

C = 0
for i in range(n - 1) :
  for j in range(m) :
    C += min(list[i][j], list[i + 1][j]) * 2
    
D = 0
for i in range(n) :
  for j in range(m - 1) :
    D += min(list[i][j], list[i][j + 1]) * 2 

print(A - B - C - D)