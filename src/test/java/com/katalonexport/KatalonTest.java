package com.katalonexport;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");

        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testKatalonForm() throws Exception {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys("Karol");
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys("Kowalski");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.id("dob")).click();
        driver.findElement(By.id("dob")).click();
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of birth'])[1]/following::label[1]")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("Prosta 51");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("karol.kowalski@mailnator.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Pass123");
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("Coders Lab");
        driver.findElement(By.id("role")).click();
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("QA");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Role'])[1]/following::option[2]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=expectation | label=Challenging]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Job expectation'])[1]/following::option[6]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ways of development'])[1]/following::label[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Read books'])[1]/following::label[1]")).click();
        driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).clear();
        driver.findElement(By.id("comment")).sendKeys("Pierwszy automattestowy.");
        driver.findElement(By.id("submit")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
