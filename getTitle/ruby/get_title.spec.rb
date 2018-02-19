# get_title.spec.rb

# import testing library
require 'minitest/autorun'
require 'webmock/minitest'

# import code to be tested
require_relative 'get_title'

body = <<HTML
<html>
  <head>
    <title>Cool Title, Bro</title>
  </head>
  <body>
    <p>yo</p>
  </body>
</html>
HTML

describe "An HTML parsing library" do
  it "can get the <title> content" do
    stub_request(:any, "http://example.com").
      to_return(body: body)
    get_title("http://example.com")
      .must_equal "Cool Title, Bro"
  end
end
