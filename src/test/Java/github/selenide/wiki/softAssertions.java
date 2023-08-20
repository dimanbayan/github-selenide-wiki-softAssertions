package github.selenide.wiki;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class softAssertions {

    @Test
    void existJUnit5Code() {
//        Открыть страницу
        open("https://github.com/selenide/selenide");

// Переход в раздел wiki проекта
        $("#wiki-tab").click();

        //Проверка наличия страницы SoftAssertions
        $(".markdown-body ul").shouldHave(text("Soft assertions"));

//        Переход на страницу SoftAssertions
        $(".markdown-body ul").$(byText("Soft assertions")).click();

//        Проверка наличия кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class:"));
        $("#user-content-3-using-junit5-extend-test-class")
                .parent().sibling(0)
                .$("pre")
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));

    }

}
