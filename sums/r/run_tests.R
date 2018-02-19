# run_tests.R

# import testing library
library(testthat)

# run files named ./tests/test*.R
test_dir("./tests", reporter = c("progress"))