<?php

namespace Morphatic;

/**
 * Gets the text from the <title> tag
 * @param  string $url The page URL
 * @return string      The <title> text
 */
function get_title($url) {
  $html = file_get_contents($url);
  preg_match('/<title>(.*?)<\/title>/', $html, $matches);
  return $matches[1];
}