package main

import (
	"bufio"
	"os"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	vowel := "aeiou"

	loop:
		for {
			sc.Scan()
			str := sc.Text();
			if str == "end" {
				break loop
			}
			if !strings.ContainsRune(str, 'a') &&  !strings.ContainsRune(str, 'e') &&  !strings.ContainsRune(str, 'i') &&  !strings.ContainsRune(str, 'o') &&  !strings.ContainsRune(str, 'u') {
				writer.WriteString("<" + str + "> is not acceptable.\n")
					continue loop
			}
			if len(str) == 1 {
				writer.WriteString("<" + str + "> is acceptable.\n")
				continue loop
			}
			for i := 0; i < len(str) - 1; i++ {
				if str[i] == str[i + 1] && str[i] != 'e' && str[i] != 'o' {
					writer.WriteString("<" + str + "> is not acceptable.\n")
					continue loop
				}
			}
			if len(str) > 2 {
				for i := 0; i < len(str) - 2; i++ {
					if strings.ContainsRune(vowel, rune(str[i])) == strings.ContainsRune(vowel, rune(str[i + 1])) && strings.ContainsRune(vowel, rune(str[i])) == strings.ContainsRune(vowel, rune(str[i + 2])) {
						writer.WriteString("<" + str + "> is not acceptable.\n")
						continue loop
					}
				}
			}
			writer.WriteString("<" + str + "> is acceptable.\n")
		}
}