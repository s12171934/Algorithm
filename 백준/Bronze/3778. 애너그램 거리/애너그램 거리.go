package main

import (
	"bufio"
	"math"
	"os"
	"strconv"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	sc.Scan()
	TC,_ := strconv.Atoi(sc.Text())

	for tc := 1; tc <= TC; tc++ {
		writer.WriteString("Case #" + strconv.Itoa(tc) + ": ")
		sc.Scan()
		var list [26]int
		for _,r := range sc.Text() {
			list[r - 97]++
		}
		sc.Scan()
		for _,r := range sc.Text() {
			list[r - 97]--
		}
		var sum int
		for _,v := range list {
			sum += int(math.Abs(float64(v)))
		}
		writer.WriteString(strconv.Itoa(sum) + "\n")
	}
}