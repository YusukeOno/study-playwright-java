package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoginTest extends TestBase {

  @Test
  void testプレミアム会員でログインする() {
    // Given
    page.navigate("https://hotel.testplanisphere.dev/ja/login.html");
    page.getByLabel("メールアドレス").fill("ichiro@example.com");
    page.getByLabel("パスワード").fill("password");

    // When
    page.locator("#login-button").click();

    // Then
    assertTrue(page.url().contains("https://hotel.testplanisphere.dev/ja/mypage.html"));
  }
}
