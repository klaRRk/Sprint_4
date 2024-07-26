package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Класс окна "Про аренду"
public class OrderDetailsPage {
    private WebDriver driver;
    // Конструктор
    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы формы "Про аренду"
    private By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']"); //Локатор поля "Когда привезти самокат"
    private By rentalPeriodField = By.xpath("//input[@placeholder='* Срок аренды']"); //Локатор поля "Срок аренды"
    private By dropdownArrow = By.className("Dropdown-arrow");; //Локатор для стрелки "Срок аренды"
    private By placeOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"); //Локатор кнопки "Заказать"


    //Локаторы появляющегося окна "Хотите оформить заказ?"
    private By confirmOrderWindow = By.className("Order_Text__2broi"); //Локатор окна "Хотите оформить заказ?"
    private By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"); //Локатор кнопки "Да"

    //Локаторы появляющегося окна "Заказ оформлен"
    private By checkStatusButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']"); //Локатор кнопки "Посмотреть статус"
    private By getRentalPeriod = (By.xpath(".//*[text() = 'двое суток']"));  //Выбор срока аренды


    //Методы заполнения данными полей
    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(dropdownArrow).click();
    }

    public void setRentalPeriod() {

        driver.findElement(getRentalPeriod).click();
    }

       //Заполнение всех полей одним методом
    public void fillOrderFields2(String deliveryDate) {
        setDeliveryDate(deliveryDate);
        setRentalPeriod();
    }
    // Клик на кнопку "Заказать"
    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    // Клик на кнопку "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    // Клик на кнопку "Посмотреть статус"
    public void clickCheckStatusButton() {
        driver.findElement(checkStatusButton).click();
    }

    private By orderDoneText = By.xpath(".//*[text() = 'Заказ оформлен']"); //Локатор заголовка "Заказ оформлен"

    //Проверка, что заголовок "Заказ оформлен" видим
    public void orderDoneTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement checkStatusTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDoneText));
        Assert.assertTrue("Текст 'Заказ оформлен' не виден", checkStatusTextElement.isDisplayed());
    }


}
