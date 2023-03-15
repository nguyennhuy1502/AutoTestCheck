package runner;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogin {
    @Test
    public void testLogin() throws InterruptedException {
        // Khởi tạo WebDriver và mở trang web
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://phptravels.net/api/admin");

        // Tìm và điền thông tin đăng nhập
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//div[contains(@class, 'align-items-center')]/button"));
        emailField.sendKeys("admin@phptravels.com");
        passwordField.sendKeys("demoadmin");
        loginButton.click();
        Thread.sleep(3000);

        // Kiểm tra xem đã đăng nhập thành công chưa
        WebElement dashboardTitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
        String titleText = dashboardTitle.getText();
        if (titleText.equals("Dashboard")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // Đóng trình duyệt
        driver.quit();
    }

    @Test
    public void testPlaceholders() throws InterruptedException {
        // Khởi tạo WebDriver và mở trang web
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://phptravels.net/api/admin");

        // Kiểm tra placeholder của trường email và password
        WebElement logo = driver.findElement(By.xpath("//div[@class = 'text-center']/img"));
        logo.click();
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        String passwordPlaceholder = passwordField.getAttribute("placeholder");
        Assert.assertEquals(" ", emailPlaceholder);
        Assert.assertEquals(" ", passwordPlaceholder);

        // Thực hiện action click vào button Remember Me
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//div[@class = 'col-xs-6']/label"));
        rememberMeCheckbox.click();

        // Kiểm tra xem button Remember Me đã được chọn chưa
        boolean isSelected = rememberMeCheckbox.isSelected();
        Assert.assertTrue(isSelected);

        // Đóng trình duyệt
        driver.quit();
    }


}
