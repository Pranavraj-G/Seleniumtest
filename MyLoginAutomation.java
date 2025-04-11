
public class MyLoginAutomation {

    public static void main(String[] args) {

        // Probably could've externalized this path, but hardcoding for now
        System.setProperty("webdriver.chrome.driver", "D:\\chrome-win64");

        WebDriver driver = new ChromeDriver();  // switched name to 'driver' -

        // Navigate to the test login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Fill in the login form
        
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Hit the login button
        driver.findElement(By.id("submit")).click();

        // Checking if we landed on the expected page after login
        String pageAfterLogin = driver.getCurrentUrl();

        // Could use contains() in case of redirects or trailing slashes, but keeping it strict for now
        if (pageAfterLogin.equals("https://practicetestautomation.com/logged-in-successfully/")) {
            System.out.println("Successfully logged in!");
        } else {
            System.out.println("Login failed. URL I ended up on: " + pageAfterLogin);
        }

        // Close the browser 
        driver.quit();
    }
}

