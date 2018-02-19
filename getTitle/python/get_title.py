import requests # HTTP request library
import re       # regular expressions

def get_title(url):
  """Get the <title> from the HTML at the url"""
  r = requests.get(url)
  p = re.compile('<title>(.*?)</title>')
  s = p.search(r.text)
  return s.group(1)
