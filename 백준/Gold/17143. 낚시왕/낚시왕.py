R,C,M = map(int, input().split())
grid = [[0]*C for _ in range(R)]
for _ in range(M) : r,c,s,d,z = map(int, input().split());grid[r - 1][c - 1] = [s,d,z]

ans = 0
for i in range(C) :
  for j in range(R) :
    if grid[j][i] != 0 : ans += grid[j][i][2]; grid[j][i] = 0; break
  
  new_grid = [[0]*C for _ in range(R)]  
  for x in range(R) :
    for y in range(C) :
      if grid[x][y] != 0 :
        if grid[x][y][1] == 1 or grid[x][y][1] == 2 :
          nx = x + grid[x][y][0] * (-1 if grid[x][y][1] == 1 else 1)
          if nx < 0 : 
            nx = abs(nx)
            if grid[x][y][1] == 1 : grid[x][y][1] = 2
            else : grid[x][y][1] = 1
          if ((nx - 1) // (R - 1)) % 2 == 1 :
            if grid[x][y][1] == 1 : grid[x][y][1] = 2
            else : grid[x][y][1] = 1
          if (nx // (R - 1)) % 2 == 0 : nx = nx % (R - 1)
          else : nx = (R - 1) - nx % (R - 1)
          ny = y
          
        if grid[x][y][1] == 3 or grid[x][y][1] == 4 :
          ny = y + grid[x][y][0] * (-1 if grid[x][y][1] == 4 else 1)
          if ny < 0 : 
            ny = abs(ny)
            if grid[x][y][1] == 3 : grid[x][y][1] = 4
            else : grid[x][y][1] = 3
          if ((ny - 1) // (C - 1)) % 2 == 1 :
            if grid[x][y][1] == 3 : grid[x][y][1] = 4
            else : grid[x][y][1] = 3
          if (ny // (C - 1)) % 2 == 0 : ny = ny % (C - 1)
          else : ny = (C - 1) - ny % (C - 1)
          nx = x
          
        if new_grid[nx][ny] == 0 or new_grid[nx][ny][2] < grid[x][y][2] : new_grid[nx][ny] = grid[x][y]
  grid = new_grid

print(ans)