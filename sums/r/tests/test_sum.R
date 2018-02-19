# tests/test_sum.R

source("../sum.R")
context("Arithmetic library")
test_that("sum() adds 2 numbers", {
  expect_that(my_sum(3, 4), equals(7))
})
