package com.practice.myapplication;

import java.lang.Exception.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.SearchContext;

//import org.apache.tools.ant.taskdefs.WaitFor;
//import org.apache.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test; //edit again

public class ExampleUnitTest {

    WebDriver driver;

    @BeforeTest
    //public void setUp() throws MalformedURLException {
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        // capabilities.setCapability("deviceName", "ZY223GSN8V"); //my mobile
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        //capabilities.setCapability(CapabilityType.VERSION, "7.0"); //My motoG4
        capabilities.setCapability(CapabilityType.VERSION, "8.1.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        //capabilities.setCapability("appPackage", "com.google.android.calculator");//My MotoG4
        capabilities.setCapability("appPackage", "com.android.calculator2");


        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        capabilities.setCapability("automationName","uiautomator2");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void Sum() {
        //Click on DELETE/CLR button to clear result text box before running test.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElements(By.xpath("//android.widget.Button")).get(12).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='DEL']")).click();
        System.out.println("Executed Click on DEL");


        // Click on number 2 button.
        driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        System.out.println("Executed Click on 5");

        // Click on = button.
        driver.findElement(By.xpath("//android.widget.Button[@text='+']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Executed Click on +");

        driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Executed Click on 2");
        driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Executed Click on =");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Thread.sleep(10000);
        //test web-hook 11 once again



        // Get result from result text box.
        //String result = driver.findElement(By.className("android.widget.TextView")).getText();
        //String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText().toString();
        //String result=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
//        String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        String result=driver.findElement(By.xpath("//android.widget.TextView")).getText();

        System.out.println("Number sum result is : " + result);


    }

    @AfterTest
    public void End() {
        driver.quit();
    }
}

