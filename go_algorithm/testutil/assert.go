package testutil

import (
	"reflect"
	"testing"
)

func AssertEquals[T comparable](t *testing.T, expected, actual T) {
	if expected != actual {
		t.Fatalf("expected %v but got %v", expected, actual)
	}
}

func AssertArrayEquals[T any](t *testing.T, expected, actual []T) {
	if !reflect.DeepEqual(expected, actual) {
		t.Fatalf("expected %v but got %v", expected, actual)
	}
}