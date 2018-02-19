// get-title.js

// 3rd party library for HTTP requests
const rp = require('request-promise');

const getTitle = url => {
  return rp.request(url)
    .then(html => {
      const regex = /<title>(.*?)<\/title>/;
      let title = html.match(regex);
      return title[1];
    });
}

module.exports = getTitle;