package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    String testBaseUrl;

    String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testCreateProductFeature(ChromeDriver driver) {
        // Navigate to the Create Product page.
        driver.get(baseUrl + "/product/create");

        // Locate the input fields for product name and quantity.
        WebElement nameField = driver.findElement(By.name("productName"));
        WebElement quantityField = driver.findElement(By.name("productQuantity"));

        // Enter product details.
        String newProductName = "Test Product";
        nameField.clear();
        nameField.sendKeys(newProductName);

        quantityField.clear();
        quantityField.sendKeys("50");

        // Submit the form.
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait for the redirection to the product list page.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/product/list"));

        // Verify that the product list is on list product.
        WebElement productCell = driver.findElement(By.xpath("//*[contains(text(),'" + newProductName + "')]"));
        assertTrue(productCell.isDisplayed(), "The new product should be displayed in the product list.");
    }
}
