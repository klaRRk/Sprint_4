package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//Класс окна "Для кого самокат"
public class CustomerInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameInput = By.cssSelector("input[placeholder='* Имя']");
    private By surnameInput = By.cssSelector("input[placeholder='* Фамилия']");
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By phoneInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private By metroStationOption = By.xpath("//li[@class='select-search__row']");
    private By nextButton = By.xpath("//button[text()='Далее']");
    // Конструктор
    public CustomerInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    // Ввод имени
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    // Ввод фамилии
    public void enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }
    // Ввод адреса
    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }
    // Ввод номера телефона
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }
    // Ввод станции метро
    public void  selectMetroStation() {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationOption).click();
    }
    // Клик кнопки "Дальше"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Заполнение всех полей одним методом
    public void fillOrderFields1(String name, String surname, String address, String phoneNumber) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        selectMetroStation();
        enterPhoneNumber(phoneNumber);
    }
}
