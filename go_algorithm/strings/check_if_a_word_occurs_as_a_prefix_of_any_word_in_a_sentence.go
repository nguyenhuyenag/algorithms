package main

import (
	"go_algorithm/test_util"
	"strings"
)

/*
	https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

	Cho chuỗi s (gồm các từ cách nhau bởi khoảng trắng và ký tự key). Kiểm tra xem có từ nào
	bắt đầu bằng key hay không?
*/
func isPrefixOfWord(s string, searchWord string) int {
	arr := strings.Split(s, " ")
	for i, v := range arr {
		if strings.HasPrefix(v, searchWord) {
			return i + 1
		}
	}
	return -1
}

func main() {
	test_util.AssertInt(-1, isPrefixOfWord("i am tired", "you"))
	test_util.AssertInt(4, isPrefixOfWord("i love eating burger", "burg"))
	test_util.AssertInt(2, isPrefixOfWord("this problem is an easy problem", "pro"))
}
