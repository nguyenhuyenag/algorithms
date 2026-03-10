package test_util

import (
	"fmt"
	"reflect"
)

const (
	Red   = "\033[31m"
	Green = "\033[32m"
	Reset = "\033[0m"
)

const width = 10

//func AssertEquals[I any, T comparable](input I, actual T, expected T) {
//	if expected == actual {
//		fmt.Printf(Green+"✔ PASS: "+Reset+" %-*v\n", width, input)
//	} else {
//		fmt.Printf(Red+"❌ FAIL:"+Reset+" %-*v (expected=%v, got=%v)\n",
//			width, input, expected, actual)
//	}
//}

func AssertBool(expected bool, actual bool) {
	if expected == actual {
		fmt.Printf(Green+"✔ PASS: "+Reset+" %-*v\n", width, actual)
	} else {
		fmt.Printf(Red+"❌ FAIL:"+Reset+" %-*v (expected=%v, got=%v)\n",
			width, actual, expected, actual)
	}
}

func AssertInt(expected int, actual int) {
	if expected == actual {
		fmt.Printf(Green+"✔ PASS: "+Reset+" %-*d\n", width, actual)
	} else {
		fmt.Printf(Red+"❌ FAIL:"+Reset+" %-*d (expected=%d, got=%d)\n",
			width, actual, expected, actual)
	}
}

func AssertList(expected []int, actual []int) {
	if reflect.DeepEqual(expected, actual) {
		fmt.Printf(Green+"✔ PASS: "+Reset+" %v\n", actual)
	} else {
		fmt.Printf(Red+"❌ FAIL: "+Reset+" got=%v expected=%v\n",
			actual, expected)
	}
}
