n = int(input())
list = []
for i in range(n) : list.append([*map(int,input().split(" "))])
list.sort(key = lambda m : (-m[0], m[1]))
print(*list[0],*list[1])
list.sort(key = lambda m : (m[1], -m[0]))
print(*list[0],*list[1])