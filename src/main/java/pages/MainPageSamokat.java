package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Главная страница Яндекс Самокат
public class MainPageSamokat {
    private WebDriver driver;

    // Конструктор
    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор верхней кнопки "Заказать"
    private By orderUpButton = By.xpath("//button[@class='Button_Button__ra12g' and text()='Заказать']");
    // Клик на верхнюю кнопку "Заказать"
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }
    //Локатор нижней кнопки "Заказать"
    private By orderDownButton = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp' or (@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    //Скролл и клик на нижнюю кнопку "Заказать"
    public void scrollToOrderDownButtonAndClick() {
        WebElement element = driver.findElement(orderDownButton);
        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Ожидание
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(orderDownButton));
        // Клик по кнопке
        element.click();
    }
    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();   // Клик на нижнюю кнопку "Заказать"
    }

    // Локатор кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    // Клик на куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    private By howMuchButton = By.id("accordion__heading-0"); // Локатор "Сколько это стоит? И как оплатить"
    private By someScootersButton = By.id("accordion__heading-1"); // Локатор "Хочу сразу несколько самокатов! Так можно?"
    private By rentTimeButton = By.id("accordion__heading-2"); // Локатор "Как рассчитывается время аренды?"
    private By orderTodayButton = By.id("accordion__heading-3"); // Локатор "Можно ли заказать самокат прямо на сегодня?"
    private By extendOrderButton = By.id("accordion__heading-4"); // Локатор "Можно ли продлить заказ или вернуть самокат раньше?"
    private By chargerButton = By.id("accordion__heading-5"); // Локатор "Вы привозите зарядку вместе с самокатом?"
    private By cancelOrderButton = By.id("accordion__heading-6"); // Локатор "Можно ли отменить заказ?"
    private By farAwayButton = By.id("accordion__heading-7"); // Локатор "Я живу за МКАДом, привезёте?"


    private By howMuchText = By.xpath("//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]"); // Локатор текста первой кнопки
    private By someScootersText = By.xpath("//p[contains(text(),'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]"); // Локатор текста второй кнопки
    private By rentTimeText = By.xpath("//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]"); // Локатор текста третьей кнопки
    private By orderTodayText = By.xpath("//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]"); // Локатор текста четвёртой кнопки
    private By extendOrderText = By.xpath("//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.')]"); // Локатор текста пятой кнопки
    private By chargerText = By.xpath("//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.')]"); // Локатор текста шестой кнопки
    private By cancelOrderText = By.xpath("//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.')]"); // Локатор текста седьмой кнопки
    private By farAwayText = By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]"); // Локатор текста восьмой кнопки

// Клики по кнопкам
    public void clickHowMuchButton() {
        driver.findElement(howMuchButton).click();
    }
    public void clickSomeScootersButton() {
        driver.findElement(someScootersButton).click();
    }
    public void clickRentTimeButton() {
        driver.findElement(rentTimeButton).click();
    }
    public void clickOrderTodayButton() {
        driver.findElement(orderTodayButton).click();
    }
    public void clickExtendOrderButton() {
        driver.findElement(extendOrderButton).click();
    }
    public void clickChargerButton() {
        driver.findElement(chargerButton).click();
    }
    public void clickCancelOrderButton() {
        driver.findElement(cancelOrderButton).click();
    }
    public void clickFarAwayButton() {
        driver.findElement(farAwayButton).click();
    }

    // Появляющейся текст
    public String getHowMuchText() {
        return driver.findElement(howMuchText).getText();
    }
    public String getSomeScootersText() {
        return driver.findElement(someScootersText).getText();
    }
    public String getRentTimeText() {
        return driver.findElement(rentTimeText).getText();
    }
    public String getOrderTodayText() {
        return driver.findElement(orderTodayText).getText();
    }
    public String getExtendOrderText() {
        return driver.findElement(extendOrderText).getText();
    }
    public String getChargerText() {
        return driver.findElement(chargerText).getText();
    }
    public String getCancelOrderText() {
        return driver.findElement(cancelOrderText).getText();
    }
    public String getFarAwayText() {
        return driver.findElement(farAwayText).getText();
    }

    // Клик по закрытому выпадающему списку
    public void clickClosedDropdownByIndex(int index) {
        driver.findElement(By.id(String.format("accordion__heading-%d", index))).click();
    }

    // Получение текста после клика по выпадающему списку
    public String getTextFromTextInputByIndex(int index) {
        return  driver.findElement(By.id(String.format("accordion__panel-%d", index))).getText();
    }

}