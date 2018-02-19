// htmlparser.go

package htmlparser

import (
  "net/http"
  "io/ioutil"
  "regexp"
)

func getTitle(url string) string {
  resp, err := http.Get(url)
  if err != nil { /* handle error */ }
  body, err := ioutil.ReadAll(resp.Body)
  if err != nil { /* handle error */ }
  re := regexp.MustCompile(`<title>(.*?)</title>`)
  matches := re.FindStringSubmatch(string(body));
  return matches[1]
}

func main() {}