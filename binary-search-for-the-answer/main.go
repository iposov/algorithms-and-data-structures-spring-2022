package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func binarySearch(intS []int, n, k int) int {
	left := 0
	right := intS[len(intS)-1] - intS[0] + 1
	for right-left > 1 {
		mid := (left + right) / 2
		if check(intS, mid, k) {
			left = mid
		} else {
			right = mid
		}
	}

	return left
}

func check(intS []int, sec, k int) bool {
	sections := 0
	lastPoint := intS[0]
	for _, point := range intS {
		if point-lastPoint >= sec {
			sections++
			lastPoint = point
		}
	}

	return sections >= k
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	n, _ := strconv.Atoi(sc.Text())

	sc.Scan()
	k, _ := strconv.Atoi(sc.Text())

	var intS []int
	for i := 0; i < n; i++ {
		sc.Scan()
		num, _ := strconv.Atoi(sc.Text())
		intS = append(intS, num)
	}
	fmt.Println(binarySearch(intS, n, k))
}
