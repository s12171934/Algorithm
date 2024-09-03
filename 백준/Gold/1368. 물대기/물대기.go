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
	N,_ := strconv.Atoi(sc.Text())
	
	pq := make(PriorityQueue, 0)
	for i := 0; i < N; i++ {
		sc.Scan()
		num,_ := strconv.Atoi(sc.Text())
		heap.Push(&pq, Item{ n1 : i, n2 : N, dist: num })
	}
	
	for i := 0; i < N; i++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		for j := i + 1; j < N; j++ {
			d,_ := strconv.Atoi(strNums[j])
			heap.Push(&pq, Item{ n1 : i, n2 : j, dist : d })
		}
	}
	
	parents = make([]int, N + 1)
	for i := 1; i <= N; i++ { parents[i] = i }

	var sum, cnt int
	loop:
	for {
		if cnt == N { break loop }
		cur := heap.Pop(&pq).(Item)
		if getParent(cur.n1) == getParent(cur.n2) { continue }
		union(cur.n1, cur.n2)
		cnt++
		sum += cur.dist
	}

	writer.WriteString(strconv.Itoa(sum))
}