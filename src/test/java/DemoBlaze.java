import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoBlaze {
    WebDriver _driver;
    /*Ejemplos
        By loginButton1 = By.id("login2");
        By loginButton2 = By.className("nav-link_login");
        By loginButton3 = By.linkText("Log in");
        By loginButton4 = By.partialLinkText("Log");
        By loginButton5 = By.cssSelector("a[data-target*='logIn']");
        By loginButton6 = By.xpath("//a[contains(text(),'Log in')]");
        */

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");

        System.out.println("Se ejecuto BeforeClass");
    }

    @BeforeMethod
    public void beforeTest(){
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _driver.navigate().to("https://demoblaze.com/");
        System.out.println("Se ejecuto BeforeMethod");
    }

    @Test
    public void sumatorioTotalesPreciosProductos () throws InterruptedException {
        //Dado me logue correctamente en demoblaze
        By loginButton = By.id("login2");
        By userNameField = By.id("loginusername");
        By userPassField = By.id("loginpassword");
        By modalButtonLogin = By.cssSelector("div.modal-footer > button[onclick='logIn()']");

        _driver.findElement(loginButton).click();
        //Agregar espera
        _driver.findElement(userNameField).sendKeys("Selenium");
        _driver.findElement(userPassField).sendKeys("prueba123");
        _driver.findElement(modalButtonLogin).click();
        //Agregar espera

        //Y Tengo dos productos en mi carrito
        By sansungGalaxyS6 = By.linkText("Samsung galaxy s6");
        By addCartButton = By.linkText("Add to cart");
        _driver.findElement(sansungGalaxyS6).click();
        //espera
        _driver.findElement(addCartButton).click();
        //espera
        Alert alerta = _driver.switchTo().alert();
        alerta.accept();
        //espera
        _driver.findElement(addCartButton).click();
        //espera
        Alert alerta2 = _driver.switchTo().alert();
        alerta2.accept();
        //espera

        //Y Me encuentro en la pagina www.demoblaze.com/cart.html
        _driver.navigate().to("www.demoblaze.com/cart.html");

        //Cuando Controlo el precio de cada producto en la columna Price
        By preciosProductos = By.cssSelector("tbody#tbodyid > tr.success > td:nth-child(3)");
        By preciosTotal = By.id("totalp");
        var listaprecios = _driver.findElements(preciosProductos);
        int totalsuma = 0;

        ///Y sumó todos los valores
        totalsuma = totalsuma + Integer.parseInt(listaprecios.get(0).getText().trim());
        totalsuma = totalsuma + Integer.parseInt(listaprecios.get(1).getText().trim());

        //Entonces el monto que figura debajo de Total debería ser igual al de la suma de valores
        Assert.assertTrue(totalsuma == Integer.parseInt(_driver.findElement(preciosTotal).getText().trim()));
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
