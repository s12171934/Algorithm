package main

import (
	"bufio"
	"os"
	"strconv"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	var maxLen int
	sc.Scan()
	str := sc.Text()
	list := make([]int, len(str) + 1)
	for i,r := range str { list[i + 1] = list[i] + int(r) - 48 }
	for i := 2; i <= len(str); i++ {
		for j := i % 2; j < i; j += 2 {
			m := (i + j) / 2
			if list[i] - list[m] == list[m] - list[j] { maxLen = max(maxLen, i - j) }
		} 
	}
	writer.WriteString(strconv.Itoa(maxLen))
}