package main

import (
	"go_algorithm/test_util"
	"slices"
)

/*
	https://leetcode.com/problems/check-if-a-string-can-break-another-string/

	Cho 2 chuỗi s1, s2. Kiểm tra xem s1 có trội hơn s2 hay không.

	Chuỗi s1 trội hơn s2 nếu tồn tại hoán vị s1 mà s1[i] >= s2[j], với mọi i = [0, n - 1]
*/
func checkIfCanBreak(s1 string, s2 string) bool {
	// Chuyển string thành slice rune để xử lý từng ký tự
	r1 := []rune(s1)
	r2 := []rune(s2)

	// Sắp xếp hai chuỗi theo thứ tự tăng dần
	slices.Sort(r1)
	slices.Sort(r2)

	// Giả sử r1 >= r2 hoặc r1 <= r2
	asc, desc := true, true

	for i := 0; i < len(r1); i++ {
		// Nếu r1[i] < r2[i] thì r1 không thể >= r2
		if r1[i] < r2[i] {
			asc = false
		}

		// Nếu r1[i] > r2[i] thì r1 không thể <= r2
		if r1[i] > r2[i] {
			desc = false
		}
	}

	// Nếu tồn tại một trong hai trường hợp: r1 >= r2 hoặc r1 <= r2
	return asc || desc
}

func main() {
	test_util.AssertBool(true, checkIfCanBreak("abc", "xya"))
	test_util.AssertBool(false, checkIfCanBreak("abe", "acd"))
}
