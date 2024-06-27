from collections import deque

n = int(input())
nodes = [[],[]]
for i in range(n) :
  j = 0 
  for node in map(int, input().split()) : 
    if node == 1 : 
      if (i + j) % 2 == 0 : nodes[0].append([i,j])
      else : nodes[1].append([i,j])
    j += 1

ans = 0
for bw in range(2) :
  res = 0;
  stack = deque()
  stack.append([0, len(nodes[bw]),[[0]*n]*n])
  while stack :
    num, used, board = stack.pop()
    res = max(res, num)
    for ns in range(used) :
      node = nodes[bw][ns]
      if board[node[0]][node[1]] == 0 :
        new_board = [[board[i][j] for j in range(n)] for i in range(n)]
        for dist in [[1,1],[1,-1],[-1,1],[-1,-1]] :
          x, y = node[0], node[1]
          while 0<=x<n and 0<=y<n :
            new_board[x][y] = 1
            x, y = x + dist[0], y + dist[1]
        stack.append([num + 1, ns, new_board])
  ans += res      

print(ans)
