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

func read(idx int) (num int) {
	if idx == 0 {
		str, _ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ")
	}
	num, _ = strconv.Atoi(strNums[idx])
	return
}

func main() {
	defer writer.Flush()

	N, M, prev := read(0), read(1), 0
	A, ans, visited := make([]int, N), make([]int, N), make([]bool, N)
	for i := 0; i < N; i++ {
		A[i] = read(i)
	}
	for i := 0; i < M; i++ {
		ans[read(0)-1] = read(1)
		visited[read(1)-1] = true
	}
	for i := 0; i < N; i++ {
		if A[i] == 0 {
			continue
		}
		if ans[i] != 0 && ans[i] != prev + 1 {
			goto fail
		}
		ans[i] = prev + 1
		temp := i + 1
		for j := i - 1; j >= prev; j-- {
			if ans[j] > i+1 {
				goto fail
			}
			if ans[j] != 0 {
				continue
			}
			for visited[temp-1] {
				temp--
			}
			ans[j] = temp
			visited[temp-1] = true
		}
		prev = i + 1
	}

	for idx, num := range ans {
		if idx != 0 {
			writer.WriteByte(' ')
		}
		writer.WriteString(strconv.Itoa(num))
	}
	return

fail:
	writer.WriteString("-1")
}
