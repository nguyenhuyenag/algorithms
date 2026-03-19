package main

import (
	"go_algorithm/test_util"
	"strings"
)

/*
	- https://leetcode.com/problems/adding-spaces-to-a-string/

	Cho một chuỗi s và một mảng chỉ số spaces. Thêm một khoảng trắng
	vào chuỗi s tại mỗi vị trí được chỉ định trong mảng spaces.
*/
func addSpaces_OK1(s string, spaces []int) string {
	res := ""
	spaceIndex := 0
	for i := range s {
		if spaceIndex < len(spaces) && i == spaces[spaceIndex] {
			res += " "
			spaceIndex++
		}
		res += string(s[i])
	}
	return res
}

func addSpaces_OK2(s string, spaces []int) string {
	var res strings.Builder
	p := 0

	for i := range s {
		if p < len(spaces) && i == spaces[p] {
			res.WriteByte(' ')
			p++
		}
		res.WriteByte(s[i])
	}

	return res.String()
}

func addSpaces_OK3(s string, spaces []int) string {
	// Duyệt spaces và cắt chuỗi s, sau đó nối lại bằng khoảng trắng
	var res strings.Builder
	start := 0
	for _, space := range spaces {
		res.WriteString(s[start:space])
		res.WriteByte(' ')
		start = space
	}

	// Cắt từ vị trí cuối cùng -> end
	res.WriteString(s[start:])
	return res.String()
}

func addSpaces(s string, spaces []int) string {
	var splits []string
	prev := 0
	for _, space := range spaces {
		splits = append(splits, s[prev:space])
		prev = space
	}
	splits = append(splits, s[prev:])
	return strings.Join(splits, " ")
}

func main() {
	test_util.AssertEquals(
		"Leetcode Helps Me Learn",
		addSpaces("LeetcodeHelpsMeLearn", []int{8, 13, 15}),
	)
}
