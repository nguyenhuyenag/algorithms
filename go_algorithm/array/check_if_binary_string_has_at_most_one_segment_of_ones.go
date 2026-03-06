package main

import (
	"go_algorithm/testutil"
	"strings"
)

type TestCase struct {
	input    string
	expected bool
}

func checkOnesSegment_OK(s string) bool {
	return !strings.Contains(s, "01")
}

func checkOnesSegment(s string) bool {
	count := 0
	for i := 0; i < len(s)-1; i++ {
		if s[i] != s[i+1] {
			count++
			if count > 1 {
				return false
			}
		}
	}
	return true
}

func main() {
	testCases := []TestCase{
		{"110011", false},
		{"110", true},
		{"1001", false},
		{"1", true},
		{"10", true},
		{"111", true},
		{"1000", true},
	}
	for _, v := range testCases {
		result := checkOnesSegment(v.input)
		testutil.AssertEquals(v.input, v.expected, result)
	}

}
