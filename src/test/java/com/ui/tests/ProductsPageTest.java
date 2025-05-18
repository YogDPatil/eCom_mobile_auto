package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public final class ProductsPageTest extends TestBase {

	@Test
	public void validateUserNavigatesToProductsPage() {
		Assert.assertEquals(startPage.goToProductsPage().getProductPageTitle(), "Products");
	}

	@Test
	public void validateUserCandAddsProductToCart() {
		startPage.goToProductsPage().verifyUserAddsProductToCart("PG 3");
	}

}
