package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var strNums []string

func readInt(idx int) (num int) {
	if idx == 0 { 
		str,_ := reader.ReadString('\n')
		strNums = strings.Split(strings.TrimSpace(str), " ") 
	}
	num,_ = strconv.Atoi(strNums[idx])
	return
}

func main() {
	N := readInt(0)
	atk := readInt(1)
	var curHp, maxHp int64
	for i := 0; i < N; i++ {
		if readInt(0) == 1 {
			curHp += int64(readInt(1)) * (int64(readInt(2) - 1) / int64(atk))
			maxHp = max(maxHp, curHp)
		} else {
			atk += readInt(1)
			curHp = max(curHp - int64(readInt(2)), 0)
		}
	}
	fmt.Println(maxHp + 1)
}