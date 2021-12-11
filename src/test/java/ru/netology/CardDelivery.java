package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CardDelivery {

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSendForm() {
        String localD = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        $(".input__control[type='text'][placeholder='Город']").setValue("Калининград");
        //$("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE)); // предварительная чистка поля с датой по умолчанию
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE); // предварительная чистка поля с датой по умолчанию
        $("[data-test-id='date'] input").setValue(localD);
        $("[name='name']").setValue("Иванова Алла");
        $("[name='phone']").setValue("+79993332211");
        $(".checkbox__box").click();
        $(".button").click();
        //$(".notification").setValue("");
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));


    }
}
