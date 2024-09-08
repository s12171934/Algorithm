package main

import (
	"bufio"
	"container/list"
	"os"
	"slices"
	"strconv"
	"strings"
)

var sc *bufio.Scanner = bufio.NewScanner(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
var strNums []string

func readInt(idx int) (num int) {
	if idx == 0 { sc.Scan(); strNums = strings.Split(sc.Text(), " ") }
	num,_ = strconv.Atoi(strNums[idx])
	return
}

func readString(idx int) string {
	if idx == 0 { sc.Scan(); strNums = strings.Split(sc.Text(), " ") }
	return strNums[idx]
}

func main() {
	defer writer.Flush()

	N := readInt(0)
	names := make([]string, N)
	for i := 0; i < N; i++ { names[i] = readString(i) }
	slices.Sort(names)
	nameToIdx := make(map[string]int)
	idxToName := make(map[int]string)
	for idx,val := range names {
		nameToIdx[val] = idx
		idxToName[idx] = val
	}

	topology := make([]int, N)
	graph := make([][]int, N)
	child := make([]*list.List, N)
	for i := 0; i < N; i++ { graph[i] = make([]int, N) }
	for i := 0; i < N; i++ { child[i] = list.New() }

	M := readInt(0)
	for i := 0; i < M; i++ { 
		child := nameToIdx[readString(0)]
		parent := nameToIdx[readString(1)]
		graph[parent][child] = 1;
		topology[child]++
	}

	var cnt int
	q := list.New()
	for idx,val := range topology {
		if val == 0 {
			cnt++
			q.PushBack(idx)
		}
	}

	writer.WriteString(strconv.Itoa(cnt) + "\n")
	for n := q.Front(); n != nil; n = n.Next() { writer.WriteString(idxToName[n.Value.(int)] + " ") }

	loop: 
	for {
		if q.Len() == 0 { break loop }
		cur := q.Remove(q.Front()).(int)
		for i := 0; i < N; i++ {
			if graph[cur][i] == 0 { continue }
			topology[i]--
			if topology[i] == 0 {
				q.PushBack(i)
				child[cur].PushBack(i)
			}
		} 
	}

	for i := 0; i < N; i++ {
		writer.WriteString("\n" + idxToName[i] + " " + strconv.Itoa(child[i].Len()))
		for n := child[i].Front(); n != nil; n = n.Next() { writer.WriteString(" " + idxToName[n.Value.(int)]) }
	}
}