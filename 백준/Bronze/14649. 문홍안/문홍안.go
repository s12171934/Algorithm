package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	sc.Scan()
	money,_ := strconv.Atoi(sc.Text())
	moneyPerDol := float64(money) / 100

	sc.Scan()
	N,_ := strconv.Atoi(sc.Text())

	var dols [100]int
	for i := 0; i < N; i++ {
		sc.Scan()
		strArr := strings.Split(sc.Text()," ")
		start,_ := strconv.Atoi(strArr[0])
		switch strArr[1] {
		case "L" :
			for i := 0; i < start - 1; i++ {
				dols[i]++
			}
		case "R" :
			for i := start; i < 100; i++ {
				dols[i]++
			}
		}
	}
	var cnt [3]int
	for _, v := range dols {
		cnt[v % 3]++
	}
	for _, v := range cnt {
		writer.WriteString(fmt.Sprintf("%.2f\n", float64(v) * moneyPerDol))
	}
}