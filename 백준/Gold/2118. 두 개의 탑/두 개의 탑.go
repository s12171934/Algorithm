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

	var sum, maxLen int
	N := readInt(0)
	list := make([]int, 2 * N)
	for i := 0; i < N; i++ {
		list[i] =  readInt(0)
		list[i + N] = list[i]
		sum += list[i]
	}
	s,m,len1,len2 := 0,0,0,sum
	for s <= m && m <= s + N && s < N {
		if len1 == len2 { break }
		if len1 < len2 {
			len1 += list[m]
			len2 -= list[m]
			m++
		} else {
			len1 -= list[s]
			len2 += list[s]
			s++
		}
		maxLen = max(maxLen, min(len1, len2))
	}

	writer.WriteString(strconv.Itoa(maxLen))
}