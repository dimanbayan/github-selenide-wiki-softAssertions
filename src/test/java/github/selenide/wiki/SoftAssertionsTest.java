package github.selenide.wiki;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {

    @Test
    void existJUnit5Code() {
//        Открыть страницу
        open("https://github.com/selenide/selenide");

// Переход в раздел wiki проекта
        $("#wiki-tab").click();

        //Проверка наличия страницы SoftAssertions в разделе Pages
        $("#wiki-pages-box div div ul").$(byText("Show 2 more pages…")).click();
        $("#wiki-pages-box div div ul").shouldHave(text("SoftAssertions"));

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
