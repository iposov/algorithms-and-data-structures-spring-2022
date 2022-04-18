package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func levensteinInstruction(str1, str2 []rune, insertCost, deleteCost, replaceCost int) int {
	D := make([][]int, len(str1)+1)
	for i := range D {
		D[i] = make([]int, len(str2)+1)
	}
	for i := 0; i < len(str2); i++ {
		D[0][i+1] = D[0][i] + insertCost
	}
	for i := 1; i <= len(str1); i++ {
		D[i][0] = D[i-1][0] + deleteCost
		for j := 1; j <= len(str2); j++ {
			if str1[i-1] != str2[j-1] {
				D[i][j] = int(math.Min(math.Min(float64(D[i-1][j]+deleteCost), float64(D[i][j-1]+insertCost)), float64(D[i-1][j-1]+replaceCost)))
			} else {
				D[i][j] = D[i-1][j-1]
			}
		}
	}
	return D[len(str1)][len(str2)]
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	str1 := sc.Text()
	sc.Scan()
	str2 := sc.Text()
	str1Rune := []rune(str1)
	str2Rune := []rune(str2)
	fmt.Println(levensteinInstruction(str1Rune, str2Rune, 1, 1, 1))
}
