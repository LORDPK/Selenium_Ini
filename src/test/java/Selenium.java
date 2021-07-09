import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Selenium {
    WebDriver _driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");

        System.out.println("Se ejecuto BeforeClass");
    }

    @BeforeMethod
    public void beforeTest(){
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _driver.navigate().to("http://google.com.ar");
        System.out.println("Se ejecuto BeforeMethod");
    }

    @Test
    public void buscarGoogle(){
        By areaBusqueda = By.cssSelector("input[title='Buscar']");
        WebElement elementBusqueda = _driver.findElement(areaBusqueda);

        elementBusqueda.sendKeys("Selenium");
        elementBusqueda.sendKeys(Keys.ENTER);

        String texto = _driver.findElement(By.cssSelector("div#rso div h3")).getText();
        Assert.assertTrue(texto.contains("Selenium"));

        System.out.println("Se ejecuto Test buscarGoogle");
    }

    @Test
    public void buscarGoogleCaballo(){
        By areaBusqueda = By.cssSelector("input[title='Buscar']");
        _driver.findElement(areaBusqueda).sendKeys("Caballo");
        _driver.findElement(areaBusqueda).sendKeys(Keys.ENTER);

        String texto = _driver.findElement(By.cssSelector("div#rso div h3")).getText();
        Assert.assertTrue(texto.contains("Caballo"));
        System.out.println("Se ejecuto Test buscarGoogleCaballo");
    }

    @AfterMethod
    public void afterTest(){
        _driver.close();
        _driver.quit();
        System.out.println("Se ejecuto AfterMethod");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("Se ejecuto AfterClass");
    }
}
