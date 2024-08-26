package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	stdin := bufio.NewReader(os.Stdin)
	stdout := bufio.NewWriter(os.Stdout)
	defer stdout.Flush()

	var N int
	fmt.Fscanln(stdin, &N)

	var list = make([]int, N)
	for i := 0; i < N; i++ {
		fmt.Fscanln(stdin, &list[i])	
	}

	sort.Ints(list)

	for i := 0; i < N; i++ {
		fmt.Fprintln(stdout, list[i])
	}
}