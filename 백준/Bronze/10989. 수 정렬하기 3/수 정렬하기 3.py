n, nums = int(input()), [0] * 10001
for _ in range(n) : nums[int(input())] += 1
for i in range(10001) :
    for _ in range(nums[i]) :
        print(i)