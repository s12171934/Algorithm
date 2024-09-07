package main

import (
	"bufio"
	"container/list"
	"os"
	"strconv"
	"strings"
)

var sc *bufio.Scanner
var strNums []string

type Toy struct {
	idx int
	required int
}

func read(idx int) (num int) {
	if idx == 0 {
		sc.Scan()
		strNums = strings.Split(sc.Text(), " ")
	}
	num,_ = strconv.Atoi(strNums[idx])
	return
}

func main() {
	sc = bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	N, M := read(0), read(0);
	topology, graph, q := make([]int, N + 1), make([]*list.List, N + 1), list.New()
	for i := 1; i <= N; i++ { graph[i] = list.New() }
	for i := 1; i <= M; i++ {
		X, Y, K := read(0), read(1), read(2)
		graph[Y].PushBack(Toy{ idx: X, required: K});
		topology[X]++
	}
	for i :=1; i <= N; i++ {
		if topology[i] == 0 { 
			q.PushBack(i)
		}
	}
	basic := make([][]int, N + 1)
	for i := 0; i <= N; i++ { basic[i] = make([]int, q.Len()) }
	for i, n := 0, q.Front(); n != nil; i, n = i + 1, n.Next() {
		basic[0][i] = n.Value.(int)
		basic[n.Value.(int)][i] = 1
	}
	loop:
	for {
		if q.Len() == 0 { break loop }
		cur := q.Remove(q.Front()).(int)
		for n := graph[cur].Front(); n != nil; n = n.Next() {
			next := n.Value.(Toy)
			for i := 0; i < len(basic[0]); i++ { basic[next.idx][i] += basic[cur][i] * next.required }
			topology[next.idx]--
			if topology[next.idx] == 0 { q.PushBack(next.idx) }
		}
	}
	for i := 0; i < len(basic[0]); i++ { writer.WriteString(strconv.Itoa(basic[0][i]) + " " + strconv.Itoa(basic[N][i]) + "\n") }
}