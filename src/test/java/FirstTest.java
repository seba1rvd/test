import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    @Step("Проверка разности числа {num1} и числа {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {
        Assert.assertTrue(num1 - num2 == expectedResult, "Результат вычитания не соответствует ожидаемому значению");
    }

    @Test(description = "Сравнение чисел")
    public void chislo() {
        checkSubtractionStep(2, 2, 0);

    }

    @Test(description = "Вывод ссылок в Links")
    @Links(value = {@Link(name = "Ссылка1", url = "http://sberbank.ru"),
            @Link(name = "Ссылка2", url = "http://yandex.ru")})
    public void checkSubtractionWithLinksTest() {
        checkSubtractionStep(14, 5, 9);
    }

    @Test(description = "Вывод логотипов в Links")
    @Issue(value = "FGY-4627")
    @TmsLinks({@TmsLink(value = "TL-135"), @TmsLink(value = "TL-158")})
    public void simpleTest15() {
        Assert.assertTrue(1 == 1);
    }

    @BeforeTest
    public void profileSetup() {
        System.out.println("Начало теста");
    }

    @AfterTest
    public void reportReady() {
        System.out.println("Отчет готов к публикации со скриншотами тестов");
    }

}