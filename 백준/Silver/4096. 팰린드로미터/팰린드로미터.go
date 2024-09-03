package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)
func makePalindrome(str string) (newNum int) {
	for i := 0;  2 * i < len(str); i++ {
		val := int(str[i]) - 48;
		if 2 * i + 1 == len(str) {
			newNum += val * int(math.Pow10(i))
		} else {
			newNum += val * (int(math.Pow10(i)) + int(math.Pow10(len(str) - i - 1)))
		}
	}
	return
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	loop:
	for{
		sc.Scan()
		str := sc.Text()
		if str == "0" { break loop }
		num,_ := strconv.Atoi(str)
		newNum := makePalindrome(str)
		if newNum < num {
			newNum += int(math.Pow10(len(str) / 2))
			newNum = makePalindrome(fmt.Sprintf("%0" + strconv.Itoa(len(str)) + "d", newNum))
		}
		writer.WriteString(strconv.Itoa(newNum - num) + "\n")
	}
}