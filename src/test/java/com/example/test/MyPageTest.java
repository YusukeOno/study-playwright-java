package com.example.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.TestBase;
import com.example.page.LoginPage;
import com.example.page.MyPage;
import com.example.util.CustomEvidence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * MyPageTest.
 */
public class MyPageTest extends TestBase {

  /** CustomEvidence. */
  private CustomEvidence evidence;

  @BeforeEach
  void setup(final TestInfo testInfo) {
    evidence = new CustomEvidence(super.page, super.context, testInfo);
  }

  @AfterEach
  void teardown(final TestInfo testInfo) {
    evidence.takeScreenshot();
  }

  /**
   * testMyPageExistUserOne.
   */
  @Test
  @DisplayName("定義済みユーザの情報が表示されること_ichiro")
  final void testMyPageExistUserOne() {

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
