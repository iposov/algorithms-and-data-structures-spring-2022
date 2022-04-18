package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func binarySearch(intS []int, left, right, numToSearch int) int {
	if right >= left {
		middle := left + (right-left)/2

		if intS[middle] == numToSearch {
			return middle
		}

		if intS[middle] > numToSearch {
			right = middle - 1
		} else {
			left = middle + 1
		}
		return binarySearch(intS, left, right, numToSearch)
	}
	return -1
}

func main() {

	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	n, _ := strconv.Atoi(sc.Text())

	sc.Scan()
	str := sc.Text()
	strS := strings.Split(str, " ")
	var intS []int
	for _, val := range strS {
		num, _ := strconv.Atoi(val)
		intS = append(intS, num)
	}

	sc.Scan()
	countToSearch, _ := strconv.Atoi(sc.Text())

	for i := 0; i < countToSearch; i++ {
		sc.Scan()
		numToSearch, _ := strconv.Atoi(sc.Text())
		fmt.Println(binarySearch(intS, 0, n-1, numToSearch))
	}

}
