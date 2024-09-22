package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	strNums, _ := reader.ReadString('\n')
	tc, _ := strconv.Atoi(strings.TrimSpace(strNums))

	for i := 0; i < tc; i++ {
		strNums, _ = reader.ReadString('\n')
		tokens := strings.Fields(strings.TrimSpace(strNums))
		var deque []string
		cnt := len(tokens)/2 - 1

	multiple:
		for j := 0; j < len(tokens); j++ {
			if cnt == 0 {
				for j < len(tokens) {
					deque = append(deque, tokens[j])
					j++
				}
				break multiple
			}
			if tokens[j] == "X" {
				last := deque[len(deque)-1]
				deque = deque[:len(deque)-1]
				j++
				deque = append(deque, fmt.Sprintf("(%s X %s)", last, tokens[j]))
				cnt--
			} else {
				deque = append(deque, tokens[j])
			}
		}

		for len(deque) > 3 {
			first := deque[0]
			second := deque[1]
			third := deque[2]
			deque = deque[3:]
			deque = append([]string{fmt.Sprintf("(%s %s %s)", first, second, third)}, deque...)
		}

		fmt.Printf("%s %s %s\n\n", deque[0], deque[1], deque[2])
	}
}
