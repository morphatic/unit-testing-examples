<?php

namespace Morphatic;

use PHPUnit\Framework\TestCase;

// import code to be tested
require_once 'get_title.php';

// mock file_get_contents()
function file_get_contents($url) {
  return <<<HTML
<html>
  <head>
    <title>Cool Title, Bro</title>
  </head>
  <body>
    <p>yo</p>
  </body>
</html>
HTML;
}

final class HTMLParserTest extends TestCase {
  public function testGetTitle() {
    $this->assertEquals(
      get_title('http://example.com'),
      'Cool Title, Bro'
    );
  }
}