package main

import (
	"bufio"
	"os"
	"sort"
	"strconv"
	"strings"
)
var N int
var parent []int

func getParent(n int) int {
	if parent[n] != n { parent[n] = getParent(parent[n]) }
	return parent[n]
}

func union(i, j int) {
	i = getParent(i)
	j = getParent(j)
	if i < j { i, j = j, i }
	parent[i] = j
}

func main()  {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	sc.Scan()
	strNums := strings.Split(sc.Text(), " ")
	N,_ = strconv.Atoi(strNums[0])
	M,_ := strconv.Atoi(strNums[1])
	var sum int
	parent = make([]int, N + 1)
	for i := 1; i < N; i++ { parent[i] = i }
	graph := make([][]int, M)
	for i := 0; i < M; i++ {
		graph[i] = make([]int, 3)

		sc.Scan()
		strNums = strings.Split(sc.Text(), " ")
		graph[i][0],_ = strconv.Atoi(strNums[0])
		graph[i][1],_ = strconv.Atoi(strNums[1])
		graph[i][2],_ = strconv.Atoi(strNums[2])
		sum += graph[i][2]
	}
	sort.Slice(graph, func(i, j int) bool { return graph[i][2] < graph[j][2] })

	var cnt int
	for i := 0; i < M; i++ {
		if cnt == N - 1 { break }
		if getParent(graph[i][0]) == getParent(graph[i][1]) { continue }
		union(graph[i][0], graph[i][1])
		cnt++
		sum -= graph[i][2]
	}
	if cnt != N - 1 { writer.WriteString("-1") } else { writer.WriteString(strconv.Itoa(sum)) }
}