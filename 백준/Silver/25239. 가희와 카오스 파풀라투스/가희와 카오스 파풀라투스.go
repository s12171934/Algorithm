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
	clock := strings.Split(sc.Text(), ":")
	hh,_ := strconv.Atoi(clock[0])
	mm,_ := strconv.Atoi(clock[1])

	var section [6]int
	sc.Scan()
	strNums := strings.Split(sc.Text(), " ")
	for i := 0; i < 6; i++ { section[i],_ = strconv.Atoi(strNums[i]) }

	sc.Scan()
	N,_ := strconv.Atoi(sc.Text())

	for i := 0; i < N; i++ {
		sc.Scan()
		strNums = strings.Split(sc.Text(), " ")
		time,_ := strconv.ParseFloat(strNums[0], 64)
		if time > 60 { break }
		switch(strNums[1]) {
		case "^":
			section[hh / 2] = 0
		case "10MIN":
			mm += 10
		case "30MIN":
			mm += 30
		case "50MIN":
			mm += 50
		case "2HOUR":
			hh = (hh + 2) % 12 
		case "4HOUR":
			hh = (hh + 4) % 12 
		case "9HOUR":
			hh = (hh + 9) % 12 
		}
		if mm >= 60 {
			mm -= 60
			hh = (hh + 1) % 12 
		} 
	}
	var sum int
	for _,val := range section { sum += val }
	writer.WriteString(strconv.Itoa(min(sum, 100)))
}