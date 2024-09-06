package main

import (
	"bufio"
	"os"
	"container/list"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	sc.Scan()
	TC,_ := strconv.Atoi(sc.Text())

	for tc := 1; tc <= TC; tc++ {
		sc.Scan()
		strNums := strings.Split(sc.Text(), " ")
		K,_ := strconv.Atoi(strNums[0])
		M,_ := strconv.Atoi(strNums[1])
		P,_ := strconv.Atoi(strNums[2])

		upper := make([]*list.List, M + 1);
		lower := make([]*list.List, M + 1);
		for i := 1; i <= M; i++ {
			upper[i] = list.New()
			lower[i] = list.New()
		}

		topology := make([]int, M + 1)
		strahler := make([]int, M + 1)
		for i := 0; i < P; i++ {
			sc.Scan()
			rel := strings.Split(sc.Text(), " ")
			from,_ := strconv.Atoi(rel[0])
			to,_ := strconv.Atoi(rel[1])
			upper[to].PushBack(from)
			lower[from].PushBack(to)
			topology[to]++
		}

		q := list.New()
		for i := 1; i <= M; i++ {
			if topology[i] == 0 { q.PushBack(i) }
		}

		loop:
		for {
			if q.Len() == 0 { break loop }
			cur := q.Remove(q.Front()).(int)
			if upper[cur].Len() == 0 {
				strahler[cur] = 1
			} else {
				var max int
				for n := upper[cur].Front(); n != nil; n = n.Next() {
					if strahler[n.Value.(int)] > max {
						max = strahler[n.Value.(int)]
						strahler[cur] = max
					} else if strahler[n.Value.(int)] == max {
						strahler[cur] = max + 1;
					}
				}
			}
			for n := lower[cur].Front(); n != nil; n = n.Next() {
				if topology[n.Value.(int)] == 0 { continue }
				topology[n.Value.(int)]--
				if topology[n.Value.(int)] == 0 { q.PushBack(n.Value.(int)) }
			}
		}

		var maxStrahler int
		for _,val := range strahler {
			maxStrahler = max(maxStrahler, val)
		}
		writer.WriteString(strconv.Itoa(K) + " " + strconv.Itoa(maxStrahler) + "\n")
	}
}