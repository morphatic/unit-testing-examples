# import code to be tested
from get_title import get_title
import requests
import pytest

@pytest.fixture
def patched_requests(monkeypatch):
  def mocked_get(uri, *args, **kwargs):
    r = type('MockedReq', (), {})()
    r.text = '''
      <html>
        <head>
          <title>Cool Title, Bro</title>
        </head>
        <body>
          <p>yo</p>
        </body>
      </html>
    '''
    return r

  monkeypatch.setattr(requests, 'get', mocked_get)

# test the get_title() function
def test_get_title(patched_requests):
  title = get_title("http://example.com")
  assert title == "Cool Title, Bro"