import sys
limit_number = 250000
sys.setrecursionlimit(limit_number)

n, m = map(int, input().split(" "))
grid = []
visited = [[0 for _ in range(m)] for _ in range(n)]
for i in range(n) : grid.append([*map(int, input().split(" "))])
count, max_size, size = 0, 0, 0

def DFS(x, y) :
  global gird, visited, n, m, size
  if visited[x][y] == 1 : return
  size += 1
  grid[x][y] = 0
  visited[x][y] = 1
  for dist in [[0,1], [0, -1], [1, 0], [-1, 0]] :
    if x + dist[0] < 0 or x + dist[0] >= n or y + dist[1] < 0 or y + dist[1] >= m : continue
    if grid[x + dist[0]][y + dist[1]] == 1 : DFS(x + dist[0], y + dist[1])

for x in range(n) :
  for y in range(m) :
    if grid[x][y] == 1 and visited[x][y] == 0 : DFS(x,y); count += 1; max_size = max(max_size, size); size = 0
    else : visited[x][y] = 1
    
print(count)
print(max_size)
