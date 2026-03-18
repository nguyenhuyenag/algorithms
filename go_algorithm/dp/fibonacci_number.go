package main

import "go_algorithm/test_util"

/*
	- https://leetcode.com/problems/fibonacci-number/

	- Tính số fibonacci thứ n.
*/
func fib_OK1(n int) int {
	if n < 2 { return  n}
	return fib(n-1) + fib(n-2)
}

func fib_OK2(n int) int {
	if n <= 1 {
		return n
	}
	a, b := 0, 1
	for i := 2; i <= n; i++ {
		a, b = b, a+b
	}
	return b
}

func fib(n int ) int {
	if n < 2 {
		return n
	}
	f := make([]int, n+1)
	f[0], f[1] = 0, 1
	for i := 2; i < len(f); i++ {
		f[i] = f[i-1]+f[i-2]
	}
	return f[n]
}

func main() {
	test_util.AssertInt(1, fib(2))
	test_util.AssertInt(2, fib(3))
	test_util.AssertInt(3, fib(4))
}
