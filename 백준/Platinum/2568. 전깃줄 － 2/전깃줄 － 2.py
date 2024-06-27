n = int(input())
list = [0 for _ in range(500_000)]
index = [0 for _ in range(500_000)]
for _ in range(n) : value, idx = map(int, input().split());list[idx -  1] = value
upper = []
for i in range(500_000) : 
  if list[i] != 0:
    if upper : 
      if list[i] > upper[len(upper) - 1] : upper.append(list[i]); index[i] = len(upper)
      else :
        start, end = 0, len(upper) - 1
        while start < end :
          mid = (start + end) // 2
          if upper[mid] < list[i] : start = mid + 1
          else : end = mid
        upper[end] = list[i]
        index[i] = end + 1
    else : upper.append(list[i]); index[i] = len(upper)

ans = []
cnt = len(upper)
upper_fit = [0 for _ in range(len(upper) + 1)]
for i in reversed(range(500_000)) :
  if list[i] != 0:
    if cnt == index[i] and (cnt == len(upper) or list[i] < upper_fit[cnt]) : upper_fit[cnt - 1] = list[i]; cnt -= 1
    else : ans.append(list[i]) 
print(len(ans))
for i in sorted(ans) : print(i)