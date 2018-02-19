// __mocks__/request-promise.js

const rp = jest.genMockFromModule('request-promise');

const request = url => {
  return new Promise((resolve, reject) => {
    resolve(`
      <html>
        <head>
          <title>Cool Title, Bro</title>
        </head>
        <body>
          <p>yo</p>
        </body>
      </html>
    `);
  });
};

rp.request = request;

module.exports = rp;