n = int(input())
peoples = [[0,0] for _ in range(n)]
rank = [1] * n
for i in range(n):
    peoples[i] = [*map(int,input().split())]
for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if peoples[i][0] < peoples[j][0] and peoples[i][1] < peoples[j][1]:
            rank[i] += 1
print(*rank,sep=" ")