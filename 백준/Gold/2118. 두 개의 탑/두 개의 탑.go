package main

import (
	"bufio"
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

	N := readInt(0)
	list := make([]int, N + 1)
	for i := 1; i <= N; i++ { list[i] = list[i - 1] + readInt(0) }
	var maxLen int
	for i := 0; i <= N; i++ {
		for j := i + 1; j <= N; j++ {
			inner := list[j] - list[i]
			maxLen = max(maxLen, min(inner, list[N] - inner))
			if inner * 2 > list[N] { continue }
		}
	}
	writer.WriteString(strconv.Itoa(maxLen))
}