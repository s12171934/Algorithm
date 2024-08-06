from itertools import combinations

n, m = map(int, input().split(" "))
house, chicken = [], []

for j in range(n) :
  idx = 0
  for i in map(int, input().split(" ")) :
    if i == 1 : house.append([j, idx])
    if i == 2 : chicken.append([j, idx])
    idx += 1

grid = []
for c in chicken : grid.append([*map(lambda h : abs(c[0] - h[0]) + abs(c[1] - h[1]), house)])

print(min(map(lambda com_grid : sum([min(map(lambda arr : arr[i], com_grid)) for i in range(len(house))]),combinations(grid,m))))

