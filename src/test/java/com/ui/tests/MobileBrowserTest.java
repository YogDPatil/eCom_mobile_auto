package com.ui.tests;

import org.testng.annotations.Test;

public final class MobileBrowserTest extends BrowserTestBase {

	@Test
	public void browserTest() {
		mobileBrowserPage.enterUrl("https://www.medscape.com/");
	}

}
