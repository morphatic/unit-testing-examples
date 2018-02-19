# get_title.R

library(httr)
library(stringr)

get_title <- function(url) {
  res <- GET(url)
  html <- content(res, "text")
  match <- str_match(
    pattern = '<title>(.*?)</title>',
    string = html
  )
  match[1,2]
}