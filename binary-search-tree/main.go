package main

import (
	"bufio"
	"errors"
	"fmt"
	"log"
	"os"
	"strconv"
)

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func (t *TreeNode) Insert(value int) error {
	if t == nil {
		return errors.New("Tree is nil")
	}
	if t.val == value {
		fmt.Println("+")
		return nil
	}

	if t.val > value {
		if t.left == nil {
			t.left = &TreeNode{val: value}
			fmt.Println("-")
			return nil
		}
		return t.left.Insert(value)
	}

	if t.val < value {
		if t.right == nil {
			t.right = &TreeNode{val: value}
			fmt.Println("-")
			return nil
		}
		return t.right.Insert(value)
	}
	return nil
}

func main() {
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	n, _ := strconv.Atoi(sc.Text())

	tree := TreeNode{}

	for i := 0; i < n; i++ {
		sc.Scan()
		val, err := strconv.Atoi(sc.Text())
		if err != nil {
			log.Fatalln(err)
		}
		err = tree.Insert(val)
		if err != nil {
			log.Fatalln(err)
		}
	}

}
