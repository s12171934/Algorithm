package main

import (
	"bufio"
	"container/heap"
	"os"
	"strconv"
	"strings"
)

var parents []int

func getParent(i int) int {
	if parents[i] != i { parents[i] = getParent(parents[i]) }
	return parents[i]
}

func union(i, j int) {
	i = getParent(i)
	j = getParent(j)
	if i < j { i, j = j, i }
	parents[i] = j
}

type Item struct {
	n1 int
	n2 int
	dist int
}

type PriorityQueue []Item

func (pq *PriorityQueue) Len() int { return len(*pq) }
func (pq *PriorityQueue) Less(i, j int) bool { return (*pq)[i].dist < (*pq)[j].dist }
func (pq *PriorityQueue) Swap(i, j int) { (*pq)[i], (*pq)[j] = (*pq)[j], (*pq)[i] }
func (pq *PriorityQueue) Push(x any) { *pq = append(*pq, x.(Item)) }
func (pq *PriorityQueue) Pop() (x any) {
	x = (*pq)[pq.Len() - 1]
	*pq = (*pq)[:pq.Len() - 1]
	return
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	sc.Scan()
	strNums := strings.Split(sc.Text(), " ")
	N,_ := strconv.Atoi(strNums[0])
	M,_ := strconv.Atoi(strNums[1])
	
	gender := make([]bool, N + 1)
	sc.Scan()
	strNums = strings.Split(sc.Text(), " ")
	for idx,val := range strNums {gender[idx + 1] = val == "M"}
	pq := make(PriorityQueue, 0)
	for i := 0; i < M; i++ {
		sc.Scan()
		strNums = strings.Split(sc.Text(), " ")
		var node Item
		node.n1,_ = strconv.Atoi(strNums[0])
		node.n2,_ = strconv.Atoi(strNums[1])
		node.dist,_ = strconv.Atoi(strNums[2])
		if gender[node.n1] != gender[node.n2] { heap.Push(&pq, node) }
	}
	
	parents = make([]int, N + 1)
	for i := 1; i <= N; i++ { parents[i] = i }

	var sum, cnt int
	loop:
	for {
		if cnt == N - 1 { break loop }
		if pq.Len() == 0 { goto fail }
		cur := heap.Pop(&pq).(Item)
		if getParent(cur.n1) == getParent(cur.n2) { continue }
		union(cur.n1, cur.n2)
		cnt++
		sum += cur.dist
	}

	writer.WriteString(strconv.Itoa(sum))
	return

	fail:
	writer.WriteString("-1")
}