package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Konstruktor terima driver dan set WebDriverWait selama 10 detik
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Isi username
    public void enterUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    // Isi password
    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    // Klik tombol login
    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    // Ambil pesan error, tunggu sampai element visible terlebih dahulu
    public String getErrorMessage() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']"))
        );
        return errorElement.getText();
    }
}
