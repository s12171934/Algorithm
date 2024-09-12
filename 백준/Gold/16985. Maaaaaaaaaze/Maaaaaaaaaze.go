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
var matrix [5][4]int
var deltas [][]int = [][]int{{1,0},{-1,0},{5,0},{-5,0},{0,1},{0,-1}}
var order []int
var minLen int = 126

func BFS(order []int, rotate int, visited []int) {
	if (matrix[order[0]][rotate & 3] & 1) == 0 || (matrix[order[4]][(rotate >> 8) & 3] & (1 << 24)) == 0 { return }
	q := list.New()
	q.PushBack([]int{0,0,0})
	visited[0] = 1
	for q.Len() > 0 {
		cur := q.Remove(q.Front()).([]int)
		if cur[0] == 24 && cur[1] == 4 { minLen = min(minLen, cur[2]); return }
		for _,d := range deltas {
			x,y := cur[0] + d[0],cur[1] + d[1]
			if x < 0 || x >= 25 || (cur[0] / 5 != x / 5 && cur[0] % 5 != x % 5) || y < 0 || y >= 5 { continue }
			if (visited[y] & (1 << x)) != 0 || (matrix[order[y]][((rotate >> (y * 2))) & 3] & (1 << x)) == 0 { continue }
			visited[y] |= (1 << x)
			q.PushBack([]int{x,y,cur[2] + 1})
		}
	}
}

func readInt(idx int) (res int) {
	if idx == 0 { str,_ := reader.ReadString('\n'); strNums = strings.Split(strings.TrimSpace(str), " ") }
	res,_ = strconv.Atoi(strNums[idx]); return
}

func np() bool {
	pivot := 3
	for pivot >= 0 && order[pivot] >= order[pivot + 1] { pivot-- }
	if pivot < 0 { return false }
	pointer := 4
	for order[pointer] < order[pivot] { pointer-- }
	order[pivot], order[pointer] = order[pointer], order[pivot]
	for i := 1; i <= (4 - pivot) / 2; i++ { order[pivot + i], order[5 - i] = order[5 - i], order[pivot + i] }
	return true
}

func main() {
	defer writer.Flush()

	for i := 0; i < 5; i++ {
		for j := 0; j < 25; j++ {
			num := readInt(j % 5)
			matrix[i][0] |= num << j
			matrix[i][1] |= num << ((j % 5) * 5 + (4 - (j / 5))) 
			matrix[i][2] |= num << (24 - j)
			matrix[i][3] |= num << ((4 - (j % 5)) * 5 + (j / 5))
		}
	}
	order = []int{0,1,2,3,4}
	for true {
		for i := 0; i < 1 << 10; i++ { BFS(order, i, make([]int, 5)) }
		if !np() { break }
	}
	if minLen == 126 { minLen = -1 }
	writer.WriteString(strconv.Itoa(minLen))
}