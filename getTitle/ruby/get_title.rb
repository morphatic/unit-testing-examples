# get_title.rb

require "http"

# Gets the <title> from HTML
def get_title(url)
  html = HTTP.get(url).body
  p = /<title>(.*?)<\/title>/
  m = p.match(html)
  return m[1]
end