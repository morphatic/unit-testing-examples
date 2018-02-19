<?php

use PHPUnit\Framework\TestCase;

// import code to be tested
require_once 'sum.php';

final class ArithmeticTest extends TestCase {
  public function testSum() {
    $this->assertEquals(sum(3, 4), 7);
  }
}