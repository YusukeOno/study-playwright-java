package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.page.LoginPage;
import com.example.page.MyPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * MyPageTest.
 */
public class MyPageTest extends TestBase {

  @Test
  @DisplayName("定義済みユーザの情報が表示されること_ichiro")
  void testMyPageExistUserOne() {

    // Given
    LoginPage loginPage = new LoginPage(page);
    MyPage myPage = new MyPage(page);
    loginPage.navigate();

    // When
    loginPage.doLogin("ichiro@example.com", "password");

    // Then
    assertAll(() -> assertEquals("ichiro@example.com", myPage.getEmail()));
  }
}
