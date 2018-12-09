package Interview;

import java.lang.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class FirstTest {
    private WebDriver driver;
    private java.lang.String baseUrl;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://ecconnect.com.ua/";
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void Test()  {

        driver.manage().window().maximize(); //открытие на полный экран
        driver.get("https://ecconnect.com.ua"); //ссылка на сайт
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"UPC-demo\"]/a/img")).click();// Тестировать
        driver.findElement(By.xpath("//*[@id=\"buy\"]/table/tbody/tr/td[1]/form/input[12]")).click(); // Купить



        String parent_window = driver.getWindowHandle(); //Переход на 2 окно
        Set<String> s1 = driver.getWindowHandles();
        s1.iterator();
        Iterator<String> i1=s1.iterator();
        while (i1.hasNext()){
            String child_window = i1.next();
            if(!((parent_window)).equalsIgnoreCase(child_window)){
            driver.switchTo().window(child_window);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }

            }
        }

       WebElement magazinesRadioBtn = driver.findElement(By.cssSelector("input[id='paymentTypeCard']")); // выбор типа оплаты

        if (magazinesRadioBtn.isSelected()) {
            // Print message to console
            System.out.println("Magazines radio button is selected by default");
        } else {
            // Click the radio button
            magazinesRadioBtn.click();
        }


        driver.findElement(By.id("CardNumber")).sendKeys("4999999999990011"); //ввод номера карты
        driver.findElement(By.id("ExpMonth")).click();
        new Select(driver.findElement(By.id("ExpMonth"))).selectByVisibleText("12"); //месяц
        driver.findElement(By.id("ExpYear")).click();
        new Select(driver.findElement(By.id("ExpYear"))).selectByVisibleText("2050");//год
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("troyanda12@ukr.net");//почта

        driver.findElement(By.id("cardDataSubmit")).click(); //подтверждение

        driver.findElement(By.id("Cvc")).click();
        driver.findElement(By.id("Cvc")).clear();
        driver.findElement(By.id("Cvc")).sendKeys("999"); //код карты
        driver.findElement(By.id("CVCSubmit")).click(); //подтверждение

    }

    @After
    public void End() {
        driver.quit();

    }
}
