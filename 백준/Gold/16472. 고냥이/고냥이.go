package main

import (
	"bufio"
	"math/bits"
	"os"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
var strNums []string

func readInt(idx int) (res int) {
	if idx == 0 {
		str,_ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ")
	}
	res,_ = strconv.Atoi(strNums[idx])
	return
}

func main() {
	defer writer.Flush()

	N, s, e, maxLen := readInt(0), 0, 1, 1
	str,_ := reader.ReadString('\n')
	str = strings.TrimSpace(str)
	var alphabet [26]int
	var check uint
	alphabet[str[s] - 97] = 1
	check = 1 << (str[s] - 97)
	for s < e && e < len(str) {
		if N >= bits.OnesCount(check) {
			maxLen = max(maxLen, e - s)
			alphabet[str[e] - 97]++
			check |= 1 << (str[e] - 97)
			e++
		} else {
			alphabet[str[s] - 97]--
			if alphabet[str[s] - 97] == 0 { check ^= 1 << (str[s] - 97) }
			s++
		}
	}
	if N >= bits.OnesCount(check) { maxLen = max(maxLen, e - s) }
	writer.WriteString(strconv.Itoa(maxLen))
}