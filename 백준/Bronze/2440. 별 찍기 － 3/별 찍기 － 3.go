package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	stdin := bufio.NewReader(os.Stdin)
	stdout := bufio.NewWriter(os.Stdout)
	defer stdout.Flush()

	var N int
	fmt.Fscanln(stdin, &N)
	for i := 0; i < N; i++ {
		fmt.Fprintln(stdout, strings.Repeat("*", N - i))		
	}
}