alphabet, i = [-1] * 26, 0
for c in input() :
    if alphabet[ord(c) - 97] == -1 : alphabet[ord(c) - 97] = i
    i += 1
print(*alphabet)