package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

type coin struct {
	coins []int
}

func newCoin(coins []int) *coin {
	return &coin{coins: coins}
}

func (c *coin) check(sum int) bool {
	f := make([]bool, sum+1, sum+1)
	f[0] = true
	for i := 0; i <= sum; i++ {
		for _, coyn := range c.coins {
			if i-coyn >= 0 {
				if f[i-coyn] {
					f[i] = true
					break
				}
			}
		}
	}
	return f[sum]
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	k, _ := strconv.Atoi(sc.Text())
	var mas []int
	for i := 0; i < k; i++ {
		sc.Scan()
		num, _ := strconv.Atoi(sc.Text())
		mas = append(mas, num)
	}
	sc.Scan()
	sum, _ := strconv.Atoi(sc.Text())

	coin := newCoin(mas)
	if coin.check(sum) {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
