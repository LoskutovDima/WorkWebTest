package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Logger {
    protected static WebDriver driver;

    @Before
    public void setDriver (){
    WebDriverManager.chromedriver().setup();

    }
    @After
    public void end() {
        if (driver!=null)
            driver.quit();
    }
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);


        @Test
        public void webTest() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            ChromeDriver driver = new ChromeDriver(options);
            driver.get("https://duckduckgo.com/");
            logger.info("Открылась страница сайта");
            driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
            logger.info("В поисковую строку введено значение 'ОТУС'");
            driver.findElement(By.id("search_button_homepage")).click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            logger.info("Проверка поисковой выдачи");
            Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение...", driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]")).getText());
            logger.info("Тест прошел успешно!");
            end();

        }

        @Test
    public void webTest2 () {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("kiosk");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        logger.info("Открыта страица сайта");
        driver.findElement(By.xpath("/html/body/section[2]/div/ul[2]/li[2]/span/a/div[1]")).click();
        driver.findElement(By.xpath("/html/body/section[2]/div/ul[2]"));
        logger.info("Картинка открыта в модальном окне");
       end();

        }
        @Test
    public void webTest3 () {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            ChromeDriver driver = new ChromeDriver(options);
            driver.get("https://otus.ru");
            logger.info("Страница сайта открыта");
            driver.findElement(By.xpath("/html/body/div[1]/div/header[2]/div/div[3]/div[1]/button")).click();
            logger.info("Открыта страница авторизации");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("test19282@yandex.ru");
            logger.info("Поле e-mail заполнено");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("Test1928");
            logger.info("Поле пароль заполнено");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[4]/button")).submit();
            logger.info("Авторизация успешно произведена");
            Assert.assertEquals("Тест",driver.findElement(By.xpath("/html/body/div[1]/div/header[2]/div/div[3]/div/div[1]/div[3]/p")).getText());
            driver.manage().getCookies();
            logger.info(driver.manage().getCookies());
            end();

        }



    }






