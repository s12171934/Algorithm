package main

import (
	"bufio"
	"container/list"
	"os"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
var strNums []string
var cnt int

func readInt(idx int) (num int) {
	if idx == 0 { 
		str,_ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ") 
	}
	num,_ = strconv.Atoi(strNums[idx])
	return
}

func main() {
	defer writer.Flush()

	N := readInt(0)
	M := readInt(1)
	graph := make([]map[int]bool, N + 1)
	topology := make([]*list.List, N + 1)
	for i := 1; i <= N; i++ { graph[i] = make(map[int]bool) }
	for i := 1; i <= N; i++ { topology[i] = list.New() }
	for i := 1; i <= M; i++ {
		num := readInt(0)
		result := readInt(num + 1)
		recipe := make([]int, num)
		for j := 1; j <= num; j++ {
			require := readInt(j)
			graph[require][result] = true
			recipe[j - 1] = require
			topology[result].PushBack(recipe)
		}
	}
	
	q := list.New()
	res := make([]bool, N + 1)
	L := readInt(0)
	for i := 0; i < L; i++ {
		num := readInt(i)
		res[num] = true
		cnt++
		q.PushBack(num)
	}

	loop:
	for {
		if q.Len() == 0 { break loop }
		cur := q.Remove(q.Front()).(int)
		for val := range graph[cur] {
			if res[val] { continue }

			check :
			for n := topology[val].Front(); n != nil; n = n.Next() {
				recipe := n.Value.([]int)
				for _,val := range recipe {
					if !res[val] { continue check }
				}
				goto canMake
			}
			continue;

			canMake:
			q.PushBack(val)
			res[val] = true
			cnt++
		}
	}

	writer.WriteString(strconv.Itoa(cnt))
	writer.WriteByte('\n')
	
	var space bool
	for idx,val := range res {
		if val {
			if space { writer.WriteByte(' ')}
			writer.WriteString(strconv.Itoa(idx))
			space = true
		}
	}
}