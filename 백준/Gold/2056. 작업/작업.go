package main

import (
	"bufio"
	"container/list"
	"os"
	"strconv"
	"strings"
)

type Item struct {
	value int
	priority int
}

type minHeap []Item

func (h minHeap) Len() int {return len(h)}
func (h minHeap) Less(i, j int) bool {return h[i].priority < h[j].priority}
func (h minHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}

func (h *minHeap) Push(x interface{}) {
	*h = append(*h, x.(Item))
	// 힙의 성질을 유지하기 위해 재구성
	h.up(h.Len() - 1)
}

func (h *minHeap) Poll() (item interface{}) {
	if h.Len() == 0 {
		return nil
	}
	// 최소 요소를 저장
	item = (*h)[0]
	// 마지막 요소를 루트로 이동
	(*h)[0] = (*h)[h.Len()-1]
	*h = (*h)[:h.Len()-1]
	// 힙의 성질을 유지하기 위해 재구성
	h.down(0)
	return
}

func (h *minHeap) up(index int) {
	for index > 0 {
		parent := (index - 1) / 2
		if h.Less(index, parent) {
			h.Swap(index, parent)
			index = parent
		} else {
			break
		}
	}
}

func (h *minHeap) down(index int) {
	n := h.Len()
	for {
		left := 2*index + 1
		right := 2*index + 2
		smallest := index

		if left < n && h.Less(left, smallest) {
			smallest = left
		}
		if right < n && h.Less(right, smallest) {
			smallest = right
		}
		if smallest == index {
			break
		}
		h.Swap(index, smallest)
		index = smallest
	}
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	sc.Scan()
	N,_ := strconv.Atoi(sc.Text())
	graph := make([]*list.List, N + 1)
	topology := make([]int, N + 1)
	time := make([]int, N + 1)
	for i := 1; i <= N; i++ {
		graph[i] = list.New()
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		priority,_ := strconv.Atoi(strNums[0])
		relNum,_ := strconv.Atoi(strNums[1])
		time[i] = priority
		for r := 0; r < relNum; r++ {
			relIdx,_ := strconv.Atoi(strNums[2 + r])
			graph[relIdx].PushFront(Item{value: i, priority: priority})
			topology[i]++
		}
	}

	pq := &minHeap{}
	for idx := 1; idx <= N; idx++ {
		if topology[idx] == 0 {
			pq.Push(Item{value: idx, priority: time[idx]})
		}
	}

	var work int
	find:
	for {
		if pq.Len() == 0 {
			writer.WriteString(strconv.Itoa(work))
			break find
		}
		cur := pq.Poll().(Item)
		work = cur.priority
		for next := graph[cur.value].Front(); next != nil; next = next.Next() {
			nextItem := next.Value.(Item)
			topology[nextItem.value]--
			if topology[nextItem.value] == 0 {
				pq.Push(Item{value : nextItem.value, priority : cur.priority + nextItem.priority})
			}
		}
	}
}