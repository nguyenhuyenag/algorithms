package main

import (
	testutil "go_algorithm/testutil"
	"strings"
)

type TestCase struct {
	input    string
	expected bool
}

func checkOnesSegment(s string) bool {
	return !strings.Contains(s, "01")
}

func main() {
	testCases := []TestCase{
		{"110011", false},
		{"110", true},
		{"1001", false},
		{"1", true},
		{"10", true},
		{"111", true},
		{"10010", true},
	}

	//const (
	//	Red   = "\033[31m"
	//	Green = "\033[32m"
	//	Reset = "\033[0m"
	//)

	for _, v := range testCases {
		result := checkOnesSegment(v.input)
		testutil.AssertEquals(v.input, v.expected, result)
	}

}
