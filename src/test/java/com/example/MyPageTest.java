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
    assertAll(() -> assertEquals("ichiro@example.com", myPage.getEmail()),
        () -> assertEquals("山田一郎", myPage.getName()),
        () -> assertEquals("プレミアム会員", myPage.getRank()),
        () -> assertEquals("東京都豊島区池袋", myPage.getAddress()),
        () -> assertEquals("01234567891", myPage.getTel()),
        () -> assertEquals("男性", myPage.getGender()),
        () -> assertEquals("未登録", myPage.getBirthday()),
        () -> assertEquals("受け取る", myPage.getNotification()));
  }
}
