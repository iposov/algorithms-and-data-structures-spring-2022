package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type forest struct {
	forest []int
}

func newForest(n int) *forest {
	mas := make([]int, 0, n)
	for i := 0; i < n; i++ {
		mas = append(mas, i)
	}
	return &forest{mas}
}

func (f *forest) get(x int) int {
	if f.forest[x] != x {
		f.forest[x] = f.get(f.forest[x])
	}
	return f.forest[x]
}

func (f *forest) union(x, y int) bool {
	x = f.get(x)
	y = f.get(y)
	if x != y {
		f.forest[x] = y
		return false
	}
	return true
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	params := strings.Split(sc.Text(), " ")
	n, _ := strconv.Atoi(params[0])
	k, _ := strconv.Atoi(params[1])

	forest := newForest(n)

	for i := 0; i < k; i++ {
		sc.Scan()
		nums := strings.Split(sc.Text(), " ")
		x, _ := strconv.Atoi(nums[0])
		y, _ := strconv.Atoi(nums[1])
		if forest.union(x, y) {
			fmt.Println("YES")
		} else {
			fmt.Println("NO")
		}

	}
}
