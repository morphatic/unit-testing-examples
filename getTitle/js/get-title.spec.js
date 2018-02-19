// get-title.spec.js

// import the target library
const getTitle = require('./get-title');

describe('An HTML parsing library', () => {
  it('can get the <title>', () => {
    expect(getTitle('http://example.com'))
      .resolves.toBe('Cool Title, Bro');
  });
});