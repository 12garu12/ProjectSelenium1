package com.selenium.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class googleSearchTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage() {
        WebElement searchBox = driver.findElement(By.name("q")); //Encuentra el input de busqueda en google.

        searchBox.clear();

        searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software"); // introduce el texto en el input de google.

        searchBox.submit(); // Este comando es como dar un enter

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        String title = driver.getTitle();

        System.out.println(title);
        assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", title);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}


