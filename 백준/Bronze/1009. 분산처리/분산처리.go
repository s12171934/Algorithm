package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	list := [][]int{
		{10},
		{1},
		{2,4,8,6},
		{3,9,7,1},
		{4,6},
		{5},
		{6},
		{7,9,3,1},
		{8,4,2,6},
		{9,1},
	}

	sc.Scan()
	TC, _ := strconv.Atoi(sc.Text())
	
	for tc := 0; tc < TC; tc++ {
		sc.Scan()
		strNums := strings.Split(strings.TrimSpace(sc.Text()), " ")
		a, _ := strconv.Atoi(strNums[0])
		b, _ := strconv.Atoi(strNums[1])
		res := list[a % 10][(b - 1) % len(list[a % 10])]
		writer.Write([]byte(strconv.Itoa(res) + "\n"))
	}
}