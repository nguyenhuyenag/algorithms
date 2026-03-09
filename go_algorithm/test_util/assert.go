package test_util

import (
	"fmt"
)

const (
	Red   = "\033[31m"
	Green = "\033[32m"
	Reset = "\033[0m"
)

const width = 10

func AssertEquals[I any, T comparable](input I, actual T, expected T) {
	if expected == actual {
		fmt.Printf(Green+"✔ PASS: "+Reset+" %-*v\n", width, input)
	} else {
		fmt.Printf(Red+"❌ FAIL:"+Reset+" %-*v (expected=%v, got=%v)\n",
			width, input, expected, actual)
	}
}

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

//func Assert[T comparable](expected T, fn any, params ...any) {
//	f := reflect.ValueOf(fn)
//
//	args := make([]reflect.Value, len(params))
//	for i, p := range params {
//		args[i] = reflect.ValueOf(p)
//	}
//
//	results := f.Call(args)
//	actual := results[0].Interface().(T)
//
//	if actual == expected {
//		fmt.Printf(Green+"✔ PASS: "+Reset+" %-*v\n", width, params)
//	} else {
//		fmt.Printf(Red+"❌ FAIL:"+Reset+" %-*v (expected=%v, got=%v)\n",
//			width, params, expected, actual)
//	}
//}
