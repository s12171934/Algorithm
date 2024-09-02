package main

import (
	"bufio"
	"container/list"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	sc.Scan()
	strNums := strings.Split(sc.Text(), " ")
	N,_ := strconv.Atoi(strNums[0])
	M,_ := strconv.Atoi(strNums[1])
	K,_ := strconv.Atoi(strNums[2])

	builds := make([]int, N + 1)
	required := make([]int, N + 1)
	graph := make([]*list.List, N + 1)
	for i := 1; i <= N; i++ { graph[i] = list.New() }
	for i := 1; i <= M; i++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		from,_ := strconv.Atoi(strNums[0])
		to,_ := strconv.Atoi(strNums[1])
		graph[from].PushBack(to)
		required[to]++
	}
	
	
	for i := 1; i <= K; i++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		idx,_ := strconv.Atoi(strNums[1])
		if strNums[0] == "1" {
			if required[idx] != 0 { goto fail }
			if builds[idx] == 0 {
				for node := graph[idx].Front(); node != nil; node = node.Next() {
					required[node.Value.(int)]--
				}
			}
			builds[idx]++
		} else {
			if builds[idx] == 0 { goto fail }
			builds[idx]--
			if builds[idx] == 0 {
				for node := graph[idx].Front(); node != nil; node = node.Next() {
					required[node.Value.(int)]++
				}
			}
		}
	}
	writer.WriteString("King-God-Emperor")
	return

	fail:
	writer.WriteString("Lier!")
}