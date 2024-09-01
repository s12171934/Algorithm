package main

import (
	"bufio"
	"container/heap"
	"os"
	"strconv"
	"strings"
)

type Item struct {
	value int
	priority int
}

type PriorityQueue []Item

func (p *PriorityQueue) Len() int {return len(*p)}
func (p *PriorityQueue) Less(i, j int) bool {return (*p)[i].priority < (*p)[j].priority}
func (p *PriorityQueue) Swap(i, j int) {(*p)[i], (*p)[j] = (*p)[j] , (*p)[i]}

func (p *PriorityQueue) Push(x any) {*p = append(*p, x.(Item))}
func (p *PriorityQueue) Pop() (e any) {
	e = (*p)[p.Len() - 1]
	*p = (*p)[:p.Len() - 1]
	return 
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	sc.Scan()
	N, _ := strconv.Atoi(sc.Text())
	graph := make([][]int , N)
	for i := 0; i < N; i++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		graph[i] = make([]int, N)
		for j := 0; j < N; j++ {
			num,_ := strconv.Atoi(strNums[j])
			graph[i][j] = num
		}
	}
	
	visited := make([]bool, N)
	pq := make(PriorityQueue, 0)
	
	visited[0] = true
	for idx, val := range graph[0] {
		if visited[idx] { continue }
		heap.Push(&pq, Item{idx, val})
	}

	var sum int
	for cnt := 0; cnt < N - 1; {
		cur := heap.Pop(&pq).(Item)
		if visited[cur.value] { continue }
			visited[cur.value] = true
			for idx, val := range graph[cur.value] {
				if visited[idx] { continue }
				heap.Push(&pq, Item{idx, val})
			}
			sum += cur.priority
			cnt++
	}
	
	writer.WriteString(strconv.Itoa(sum))
}