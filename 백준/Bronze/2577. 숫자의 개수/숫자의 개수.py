word = str(int(input()) * int(input()) * int(input()))
list = [0] * 10
for w in word :
    list[int(w)] += 1
print(*list, sep="\n")