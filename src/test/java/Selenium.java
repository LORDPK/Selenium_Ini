import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium {
    private boolean control;
    WebDriver _driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _driver.navigate().to("http://google.com.ar");
    }

    @Test
    public void buscarGoogle(){
        By areaBusqueda = By.cssSelector("input[title='Buscar']");
        _driver.findElement(areaBusqueda).sendKeys("Selenium");
        _driver.findElement(areaBusqueda).sendKeys(Keys.ENTER);

        String texto = _driver.findElement(By.cssSelector("div#rso div h3")).getText();
        Assert.assertTrue(texto.contains("Selenium"));
    }

    @AfterMethod
    public void afterTest(){
        _driver.close();
        _driver.quit();
    }
}
