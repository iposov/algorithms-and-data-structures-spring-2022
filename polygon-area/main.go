package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	n, _ := strconv.Atoi(sc.Text())
	coordinates := make([][]float64, n)
	for i := 0; i < n; i++ {
		coordinates[i] = make([]float64, 2)
		sc.Scan()
		xy := sc.Text()
		xys := strings.Split(xy, " ")
		x, _ := strconv.Atoi(xys[0])
		y, _ := strconv.Atoi(xys[1])
		coordinates[i][0] = float64(x)
		coordinates[i][1] = float64(y)
	}
	var res float64
	for i := 0; i < len(coordinates); i++ {
		res += coordinates[i][0]*coordinates[(i+1)%len(coordinates)][1] - coordinates[(i+1)%len(coordinates)][0]*coordinates[i][1]
	}
	res = math.Abs(res) / 2
	fmt.Printf("%.2f", res)
}
