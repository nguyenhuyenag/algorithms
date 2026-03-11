package main

import (
	"go_algorithm/test_util"
	"strconv"
)

/*
	https://leetcode.com/problems/complement-of-base-10-integer/

	Cho số nguyên n -> Chuyển nó sang nhị phân

		-> Đảo ngược các bit: '0' -> '1', '1' -> '0'
		-> Trả về gía trị thập phân.

	Ví dụ:

		10110 = 1×2⁴ + 0×2³ + 1×2² + 1×2¹ + 0×2⁰
*/
func bitwiseComplement_OK1(n int) int {
	if n == 0 {
		return 1
	}

	res, base := 0, 1

	for n > 0 {
		b := n % 2
		res += (1 - b) * base
		base *= 2
		n = n / 2
	}

	return res
}

func bitwiseComplement_OK2(n int) int {
	if n == 0 {
		return 1
	}

	res := 0
	base := 1
	binary := strconv.FormatInt(int64(n), 2)

	for i := len(binary) - 1; i >= 0; i-- {
		b := 1 - int(binary[i]-'0') // Đảo bit
		res += b * base
		base *= 2
	}

	return res
}

func bitwiseComplement(n int) int {
	res := ""
	binary := strconv.FormatInt(int64(n), 2)

	for i := range binary {
		if binary[i] == '0' {
			res += "1"
		} else {
			res += "0"
		}
	}

	ans, _ := strconv.ParseInt(res, 2, 64)
	return int(ans)
}

func main() {
	test_util.AssertInt(2, bitwiseComplement(5))
	test_util.AssertInt(0, bitwiseComplement(7))
	test_util.AssertInt(5, bitwiseComplement(10))
}
