n = int(input())
for i in [*range(1,n + 1),*reversed(range(1,n))] : 
  for j in range(i) : print("*", end="")
  print("")