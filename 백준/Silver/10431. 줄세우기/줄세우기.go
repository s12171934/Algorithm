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
	TC, _ := strconv.Atoi(sc.Text())
	
	for tc := 1; tc <= TC; tc++ {
		writer.WriteString(strconv.Itoa(tc) + " ")
		sc.Scan()
		strNums := strings.Split(strings.TrimSpace(sc.Text()), " ")
		var list [20]int
		for idx, str := range strNums {
			if idx == 0 {
				continue
			}
			num, _ := strconv.Atoi(str)
			list[idx - 1] = num
		}

		var cnt int
		for i := 0; i < 20; i++ {
			for j := 0; j < i; j++ {
				if list[i] < list[j] {
					cnt++
				}
			}
		}

		writer.WriteString(strconv.Itoa(cnt) + "\n")
	}
}