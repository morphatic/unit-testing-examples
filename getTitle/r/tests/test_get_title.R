# tests/test_get_title.R

# import code to be tested
source("../get_title.R")

# load library for faking HTTP requests
library(httptest)

context("HTML Parsing Library")
test_that("get_title() can parse <title>", {
  with_mock(
    GET = function(url) {
      fake_response(url, content = '<html>
        <head>
          <title>Cool Title, Bro</title>
        </head>
        <body>
          <p>Yo</p>
        </body>
      </html>')
    },
    expect_that(
      get_title('http://example.com'),
      equals("Cool Title, Bro")
    )
  )
})