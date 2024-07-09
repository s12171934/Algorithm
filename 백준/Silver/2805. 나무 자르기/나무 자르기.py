n, m = map(int, input().split())
list1 = [*map(int, input().split())]
list1.sort(reverse=True)
max_len = list1[0]
list2 = [*map(lambda i: list1[0] - i, list1)]
for i in range(1, n): list2[i] += list2[i - 1]
for i in range(n): list2[i] = max_len * (i + 1) - list1[i] * (i + 1) - list2[i]

start, end = 0, n - 1
while start < end:
    mid = (start + end) // 2
    if list2[mid] < m:
        start = mid + 1
    elif list2[mid] > m:
        end = mid
    else:
        end = mid
        break
if list1[end] != list1[end -1] : end -= 1

print(list1[end] - (m - list2[end] - 1) // (end + 1) - 1)
