n = int(input())
nums = [[0, 0] for _ in range(8001)]
for i in range(8001):
    nums[i][0] = i - 4000
for _ in range(n):
    nums[int(input()) + 4000][1] += 1
nums = [*filter(lambda num: num[1] != 0, nums)]
nums_avg = round(sum(map(lambda num: num[0] * num[1], nums)) / n)
mid, m = 0, 0
while True:
    mid += nums[m][1]
    if mid >= n // 2 + 1:
        break
    m += 1
nums_mid = nums[m][0]
nums_range = nums[len(nums) - 1][0] - nums[0][0]
nums.sort(lambda num: (-num[1], num[0]))
if len(nums) > 1:
    if nums[0][1] == nums[1][1]:
        nums_freq = nums[1][0]
    else:
        nums_freq = nums[0][0]
else:
    nums_freq = nums[0][0]
print(nums_avg, nums_mid, nums_freq, nums_range, sep="\n")
