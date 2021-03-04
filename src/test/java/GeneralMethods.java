import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GeneralMethods extends WebDriverSettings {

    public final String URL = "https://www.cooppank.ee/autoliising";
    public final String APPLY_URL = "https://i.cooppank.ee/liisingtaotlusII";
    public final String PRICE_SLIDER_XPATH = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]";
    public final String PERIOD_SLIDER_XPATH = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]";
    public final String MONTHLY_PAYMENT_XPATH = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[6]/div[2]/p[1]/span[1]";
    public final String OPERATIONAL_LEASING_RADIO = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[2]/label[1]";
    public final String FINANCIAL_LEASING_RADIO = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/label[1]";



    public void movePriceSlider(int x, int y) throws InterruptedException {
        Actions moveSlider = new Actions(driver);
        Action priceAction;
        WebElement priceSlider = driver.findElement(By.xpath(PRICE_SLIDER_XPATH));
        Thread.sleep(500);
        priceAction = moveSlider.dragAndDropBy(priceSlider, x, y).build();
        priceAction.perform();

    }

    public void movePeriodSlider(int x, int y) throws InterruptedException {
        Actions moveSlider = new Actions(driver);
        Action periodAction;
        WebElement periodSlider = driver.findElement(By.xpath(PERIOD_SLIDER_XPATH));
        Thread.sleep(500);
        periodAction = moveSlider.dragAndDropBy(periodSlider, x, y).build();
        periodAction.perform();
    }

    public void setInitialPayment(String x) {
        WebElement initialPayment = driver.findElement(By.cssSelector("input[name='esmaneprots']"));
        initialPayment.clear();
        initialPayment.sendKeys(x);
    }

    public void setLastPayment(String x) {
        WebElement lastPayment = driver.findElement((By.cssSelector("input[name='jaakvprots']")));
        lastPayment.clear();
        lastPayment.sendKeys(x);
    }

    public void closeCookiePopUp() {
        WebElement slidingPopup = driver.findElement(By.cssSelector("#sliding-popup > div.agree-button.eu-cookie-compliance-default-button > img"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(slidingPopup));
        slidingPopup.click();
    }

    public void selectOperationalLeasing() {
        WebElement operationalLeasingRadioBtn = driver.findElement(By.xpath(OPERATIONAL_LEASING_RADIO));
        operationalLeasingRadioBtn.click();
    }

    public void selectFinancialLeasing() {
        WebElement operationalLeasingRadioBtn = driver.findElement(By.xpath(FINANCIAL_LEASING_RADIO));
        operationalLeasingRadioBtn.click();
    }

    public void applyForLeasing() {
        WebElement applyBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]"));
        applyBtn.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }


}
