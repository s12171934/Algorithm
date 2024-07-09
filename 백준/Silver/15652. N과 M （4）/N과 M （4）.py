n, m = map(int, input().split())
ans = []


def make(list, arr, j, k):
    global n, m, ans
    for i in range(j, n + 1):
        new_list = [*list]
        new_arr = [*arr]
        if arr[i]:
            continue
        new_list.append(i)
        new_arr[i] = True
        if k == m:
            ans.append(new_list)
        else:
            make(new_list, arr, i, k + 1)


make([], [False for _ in range(9)], 1, 1)

for list in ans:
    print(*list)
