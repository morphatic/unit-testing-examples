// sum.spec.js

// import the arithmetic libraries
const sum  = require('./sum');

describe('An arithmetic library', () => {
  it('can compute sums', () => {
    expect(sum(3, 4)).toBe(7);
    expect(sum(5, 6)).toBe(11);
  });
});