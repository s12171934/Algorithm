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
	
	sc.Scan()
	strArr := strings.Split(strings.TrimSpace(sc.Text()), " ")
	N, _ := strconv.Atoi(strArr[0])
	var G int
	switch strArr[1] {
	case "Y" :
		G = 1
	case "F" :
		G = 2
	case "O" :
		G = 3
	}
	set := make(map[string]bool)
	for i := 0; i < N; i++ {
		sc.Scan()
		set[sc.Text()] = true;
	}
	writer.WriteString(strconv.Itoa(len(set) / G))
}