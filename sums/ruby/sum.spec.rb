# sum.spec.rb
# import testing library
require 'minitest/autorun'

# import code to be tested
require_relative 'sum'

describe "An arithmetic library" do
  it "can compute sums" do
    sum(3, 4).must_equal 7
  end
end
