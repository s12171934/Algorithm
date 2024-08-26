package main

import (
	"bufio"
	"os"
	"sort"
	"strconv"
	"strings"
)

var stdin *bufio.Scanner
var stdout *bufio.Writer

func init() {
	stdin = bufio.NewScanner(os.Stdin)
	stdout = bufio.NewWriter(os.Stdout)
}

func readInt() int {
	stdin.Scan()
	n, _ := strconv.Atoi(stdin.Text())
	return n
}

func main() {
	defer stdout.Flush()
	N := readInt()
	var list = make([]int, N)
	stdin.Scan()
	strNumbers := strings.Split(strings.TrimSpace(stdin.Text()), " ")
	for i, str := range strNumbers {
		num, _ := strconv.Atoi(str)
		list[i] = num
	}
	sort.Ints(list)
	stdout.WriteString(strconv.Itoa(list[0] * list[len(list)-1]))
}