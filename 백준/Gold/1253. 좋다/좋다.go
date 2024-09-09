package main

import (
	"bufio"
	"os"
	"slices"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
var strNums []string
var sum []int

func readInt(idx int) (res int) {
	if idx == 0 {
		str,_ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ")
	}
	res,_ = strconv.Atoi(strNums[idx])
	return
}

func binarySearch(search int) bool {
	var s int
	var e int = len(sum) - 1
	for s < e {
		m := (s + e) / 2
		if search == sum[m] { return true }
		if search < sum[m] {
			e = m
		} else {
			s = m + 1
		}
	}
	return false
}

func main() {
	defer writer.Flush()

	var zero int
	N := readInt(0)
	list := make([]int, N)
	for i := 0; i < N; i++ {
		list[i] = readInt(i)
		if list[i] == 0 { zero++ }
	}
	slices.Sort(list)
	sum = make([]int, (N - zero) * (N - zero - 1) / 2)
	var cnt int
	for i,u := range list {
		for j := i + 1; j < N; j++ {
			if u == 0 || list[j] == 0 { continue }
			sum[cnt] = u + list[j]
			cnt++
		}
	}
	slices.Sort(sum)

	var res int
	for idx,val := range list {
		good := binarySearch(val)
		if val == 0 {
			good = good || zero > 2
		} else {
			if idx > 0 { good = good || (zero > 0 && val == list[idx - 1]) }
			if idx < N - 1 { good = good || (zero > 0 && val == list[idx + 1]) }
		}
		if good { res++ }
	}
	writer.WriteString(strconv.Itoa(res))
}