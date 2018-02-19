// htmlparser_test.go

package htmlparser

import (
  "testing"
  "gopkg.in/jarcoal/httpmock.v1"
)

func TestGetTitle(t *testing.T) {
  body :=
`<html>
  <head>
    <title>Cool Title, Bro</title>
  </head>
  <body>
    <p>yo</p>
  </body>
</html>`
  httpmock.Activate()
  defer httpmock.DeactivateAndReset()
  httpmock.RegisterResponder("GET", "http://example.com",
    httpmock.NewStringResponder(200, body))
  title := getTitle("http://example.com")
  if title != "Cool Title, Bro" {
    t.Error(title + " != Cool Title, Bro")
  }
}