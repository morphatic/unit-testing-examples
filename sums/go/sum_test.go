package main

import "testing"

func TestSum(t *testing.T) {
  total := sum(3, 4)
  if total != 7 {
    t.Error("Sum fail")
  }
}