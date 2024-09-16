package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

var reader = bufio.NewReader(os.Stdin)
var strNums []string

func read(idx int) (num int) {
	if idx == 0 {
		str, _ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ")
	}
	num, _ = strconv.Atoi(strNums[idx])
	return
}

var N int
var minTime int64
var freezes []int64

func calcSide(s, e, heat int) (res int64) {
	var mod int64 = 1
	if e == heat {
		mod = -1
	}
	for i := s; i < e; i++ {
		res = max(res, freezes[i]*int64(i-heat)*mod)
	}
	return
}

func main() {
	minTime = math.MaxInt64
	N = read(0)
	freezes = make([]int64, N)
	for i := 0; i < N; i++ {
		freezes[i] = int64(read(i))
	}
	s, e := 0, N
	for s < e {
		m := (s + e) / 2
		left, right := calcSide(0, m, m), calcSide(m, N, m)
		minTime = min(minTime, max(left, right))
		if left < right {
			s = m + 1
		} else {
			e = m
		}
	}
	fmt.Println(minTime)
}