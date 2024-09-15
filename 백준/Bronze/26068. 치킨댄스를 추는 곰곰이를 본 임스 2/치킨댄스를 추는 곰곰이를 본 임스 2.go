package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)

func readInt() (num int) {
	str, _ := reader.ReadString('\n')
	num, _ = strconv.Atoi(strings.TrimSpace(str))
	return
}

func read() (num int) {
	str, _ := reader.ReadString('\n')
	num, _ = strconv.Atoi(strings.Split(strings.TrimSpace(str), "-")[1])
	return
}

func main() {
	defer writer.Flush()

	var cnt int
	N := readInt()
	for i := 0; i < N; i++ {
		if read() <= 90 {
			cnt++
		}
	}

	writer.WriteString(strconv.Itoa(cnt))
}
