package day07;

import day06._03_PlaceOrderElements;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

public class _01_WishListPOM extends BaseDriver {

    @Test
    @Parameters("searchedText")
    void addToWishList(String text) {

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();

        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _02_WishListElements wle=new _02_WishListElements();

        int randomSelection= Tools.RandomGenerator(wle.searchResults.size());
        String wishItemText=wle.searchResults.get(randomSelection).getText();
        wle.wishLists.get(randomSelection).click();
        wle.wishProductsButton.click();
        Tools.listContainsString(wle.wishTableNames,wishItemText);

    }
}