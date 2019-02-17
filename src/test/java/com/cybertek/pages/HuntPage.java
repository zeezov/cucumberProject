package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HuntPage extends NavigationMenu {

    @FindBy(tagName = "input")
    public WebElement date;

    @FindBy(css = "#mat-select-0 .mat-select-arrow")
    public WebElement from;

    @FindBy(css = "#mat-select-1 .mat-select-arrow")
    public WebElement to;

    public void selectFrom(String startTime){
        from.click();
        String xpath = "//span[contains(.,'"+startTime+"')]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void selectTo(String endTime){
        to.click();
        String xpath = "//span[contains(.,'"+endTime+"')]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

}
