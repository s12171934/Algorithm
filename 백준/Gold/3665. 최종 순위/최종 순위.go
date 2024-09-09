package main

import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
var strNums []string

func readInt(idx int) (num int) {
    if idx == 0 {
        str,_ := reader.ReadString('\n')
        strNums = strings.Split(strings.TrimSpace(str)," ")
    }
    num,_ = strconv.Atoi(strNums[idx])
    return
}

func solve() {
    N := readInt(0)
    graph := make([][]bool, N + 1)
    topology := make([]int, N + 1)
    for i := 1; i <= N; i++ { graph[i] = make([]bool, N + 1) }
    for i := 1; i <= N; i++ {
        rank := readInt(i - 1)
        for j := 1; j <= N; j++ {
            if rank == j || graph[j][rank] { continue }
            graph[rank][j] = true
        }
        topology[rank] = i - 1
    }
    
    M := readInt(0)
    for M > 0 {
        M--
        a,b := readInt(0),readInt(1)
        if graph[a][b] {
            topology[a]++
            topology[b]--
        } else {
            topology[a]--
            topology[b]++
        }
        graph[a][b],graph[b][a] = graph[b][a],graph[a][b]
    }

    changed := make([]string, N)
		for idx,rank := range topology { changed[rank] = strconv.Itoa(idx) }

    for _,visit := range changed {
        if visit == "" { goto fail }
    }
    writer.WriteString(strings.Join(changed, " ") + "\n")
    return
    
    fail:
    writer.WriteString("IMPOSSIBLE\n")
}

func main() {
    defer writer.Flush()
    
    TC := readInt(0)
    for TC > 0 { 
        TC--
        solve()
    }
}