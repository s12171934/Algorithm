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
	
	for tc := 0; tc < TC; tc++ {
		sc.Scan()
		strNums := strings.Split(strings.TrimSpace(sc.Text()), " ")
		a, _ := strconv.Atoi(strNums[0])
		b, _ := strconv.Atoi(strNums[1])
		res := 1;
		for i := 0; i < b; i++ {
			res *= a
			res %= 10
		}
		if res == 0 {
			res = 10
		}
		writer.Write([]byte(strconv.Itoa(res) + "\n"))
	}
}