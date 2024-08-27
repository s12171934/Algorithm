package main

import (
	"bufio"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	sc.Scan()
	strNums := strings.Split(strings.TrimSpace(sc.Text()), " ")
	N, _ := strconv.Atoi(strNums[0])
	K, _ := strconv.Atoi(strNums[1])

	matrix := make([][]int64, N)
	for i := 0; i < N; i++ {
		sc.Scan()
		strNums = strings.Split(strings.TrimSpace(sc.Text()), " ")
		nation, _ := strconv.Atoi(strNums[0])
		var medal int64
		for j := 1; j <= 3; j++ {
			num, _ := strconv.Atoi(strNums[j])
			medal += int64(num) * int64(math.Pow(10, float64(18 - 6 * j)))
		}
		matrix[i] = []int64{int64(nation), medal}
	}

	sort.Slice(matrix, func(n1, n2 int) bool {
		return matrix[n1][1] > matrix[n2][1]
	})

	for i := 0; i < N; i++ {
		if matrix[i][0] == int64(K) {
			if i == 0 {
				writer.WriteString("1")
				return
			}
			medal := matrix[i][1]
			for j := 0; j <= i; j++ {
				if medal == matrix[j][1] {
					writer.WriteString(strconv.Itoa(j + 1))
					return
				}
			}
		}
	}
}