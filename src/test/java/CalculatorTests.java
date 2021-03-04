import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class CalculatorTests extends GeneralMethods {

    @Test
    public void operationalLeasingTest1() throws InterruptedException {
        driver.get(URL);
        Assert.assertEquals(URL, driver.getCurrentUrl());
        closeCookiePopUp();
        movePriceSlider(-30, 0); //ostuhind 5000
        movePeriodSlider(55, 0); //periood 72
        setInitialPayment("10");
        setLastPayment("50");
        selectOperationalLeasing();
        String monthlyPayment = driver.findElement(By.xpath(MONTHLY_PAYMENT_XPATH)).getText();
        Assert.assertEquals("36.89", monthlyPayment);
        applyForLeasing();
        Assert.assertEquals(APPLY_URL, driver.getCurrentUrl());

    }

    @Test
    public void operationalLeasingTest2() throws InterruptedException {
        driver.get(URL);
        Assert.assertEquals(URL, driver.getCurrentUrl());
        closeCookiePopUp();
        movePriceSlider(300, 0); //ostuhind 50000
        movePeriodSlider(-230, 0); //periood 12
        setInitialPayment("10");
        setLastPayment("50");
        selectOperationalLeasing();
        String monthlyPayment = driver.findElement(By.xpath(MONTHLY_PAYMENT_XPATH)).getText();
        Assert.assertEquals("1 759", monthlyPayment);
        applyForLeasing();
        Assert.assertEquals(APPLY_URL, driver.getCurrentUrl());

    }

    @Test
    public void financialLeasingTest1() throws InterruptedException {
        driver.get(URL);
        Assert.assertEquals(URL, driver.getCurrentUrl());
        closeCookiePopUp();
        movePriceSlider(300, 0); //ostuhind 50000
        movePeriodSlider(-230, 0); //periood 12
        setInitialPayment("10");
        setLastPayment("50");
        selectFinancialLeasing();
        String monthlyPayment = driver.findElement(By.xpath(MONTHLY_PAYMENT_XPATH)).getText();
        Assert.assertEquals("1 929", monthlyPayment);
        applyForLeasing();
        Assert.assertEquals(APPLY_URL, driver.getCurrentUrl());
    }

    @Test
    public void financialLeasingTest2() throws InterruptedException {
        driver.get(URL);
        Assert.assertEquals(URL, driver.getCurrentUrl());
        closeCookiePopUp();
        movePriceSlider(-30, 0); //ostuhind 5000
        movePeriodSlider(55, 0); //periood 72
        setInitialPayment("10");
        setLastPayment("50");
        selectFinancialLeasing();
        String monthlyPayment = driver.findElement(By.xpath(MONTHLY_PAYMENT_XPATH)).getText();
        Assert.assertEquals("39.12", monthlyPayment);
        applyForLeasing();
        Assert.assertEquals(APPLY_URL, driver.getCurrentUrl());
    }

}
