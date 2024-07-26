import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CustomerInfoPage;
import pages.OrderDetailsPage;
import pages.MainPageSamokat;

@RunWith(Parameterized.class)
public class FirstOrderButtonTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String deliveryDate;


    private WebDriver driver;
    private MainPageSamokat mainPageSamokat;
    private OrderDetailsPage orderDetailsPage;
    private CustomerInfoPage customerInfoPage;

    public static final String SAMOKAT_URL = "https://qa-scooter.praktikum-services.ru/"; //Адрес главной страницы "Яндекс Самоката"

    //Конструктор
    public FirstOrderButtonTest(String name, String surname, String address, String phoneNumber, String deliveryDate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Роман", "Шагеев", "Ленина 1", "79232356401", "16.07.2024"},
                {"Иван", "Петров", "Ленина 2", "79232356402", "17.07.2024"}
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(); // Хром
        mainPageSamokat = new MainPageSamokat(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        customerInfoPage = new CustomerInfoPage(driver);
        driver.get(SAMOKAT_URL);
        mainPageSamokat.clickCookieButton();

    }
    @Test

    public void testFirstButtonTest() {
        mainPageSamokat.clickOrderUpButton(); //Клик на верхнюю кнопку "Заказать" на главной странице

        customerInfoPage.fillOrderFields1(name, surname, address, phoneNumber);  //Заполняется форма "Для кого самокат"
        customerInfoPage.clickNextButton(); //Клик на кнопку "Далее"

        orderDetailsPage.fillOrderFields2(deliveryDate); // Заполняется форма "Про аренду"
        orderDetailsPage.clickPlaceOrderButton(); // Клик на кнопку "Заказать"
        orderDetailsPage.clickYesButton(); //Клик на кнопку "Да"
        orderDetailsPage.orderDoneTextVisible(); //Проверка, что заголовок "Заказ оформлен" видим
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}