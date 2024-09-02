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
	N, _ := strconv.Atoi(sc.Text())
	graph := make([]*list.List, N + 1)
	times := make([]int, N + 1)
	wait := make([]int, N + 1)
	topology := make([]int, N + 1)
	for i := 1; i <= N; i++ { graph[i] = list.New() }
	for i := 1; i <= N; i++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		times[i],_ = strconv.Atoi(strNums[0])
		idx := 1
		addSchedule:
			for {
				if strNums[idx] == "-1" { break addSchedule }
				num,_ := strconv.Atoi(strNums[idx])
				graph[num].PushBack(i)
				topology[i]++
				idx++
			}
	}

	q := list.New()
	for i := 1; i <= N; i++ {
		if topology[i] != 0 { continue }
		q.PushBack(i)
	}

	topologySort:
		for {
			if q.Len() == 0 { break topologySort }
			cur := q.Remove(q.Front()).(int)
			times[cur] += wait[cur]
			for node := graph[cur].Front(); node != nil; node = node.Next() {
				next := node.Value.(int)
				if topology[next] == 0 { continue }
				topology[next]--
				wait[next] = max(wait[next], times[cur])
				if topology[next] == 0 { q.PushBack(next) }
			}
		}

	for i := 1; i <= N; i++ {
		writer.WriteString(strconv.Itoa(times[i]) + "\n")
	}
}