package github.selenide.wiki;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class softAssertions {

    @Test
    void existCodeJUnit5() {
        Configuration.holdBrowserOpen = false;

        //Открыть репозиторий selenide
        open("https://github.com/selenide/selenide");

//        Открыть раздел Wiki
        $("#wiki-tab").click();

//        Поиск страницы softAssertions и открытие её
        $("div.markdown-body").shouldHave(text("Soft assertions"));

        $("div.markdown-body").$(byText("Soft assertions")).click();

//        Поиск примера код для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class:"));

        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .sibling(0)
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
