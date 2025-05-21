package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.CartPage;

public final class CartPageTest extends TestBase {

	private CartPage cartPage;

	@Test
	public void validateSumOfAllItemPriceWithTotalPrice() {
		cartPage = startPage.goToProductsPage().userAddsMultipleProductsInCart("PG 3");
		Assert.assertEquals(cartPage.getTotalPriceOfCartItems(), cartPage.sumOfAddedItemPrice());
	}

	@Test
	public void validateUserNavigatesToWebPageAndHitUrl() {
		startPage.goToProductsPage().userAddsProductToCart("PG 3").userNavigatesToWebAndHitUrl();
	}

}