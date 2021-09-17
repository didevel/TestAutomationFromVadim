package com.patterns.tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void typeInSearchFieldOnclickToSearchButtonWithJS() {
        String text = "javaScript";
        steps.searchByKeywordWithJavaScript(text)
                .verifyThatTopValueIsContains(text);
    }


    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.moveToVoiceSearchButton()
                .verifyThatTooltipContainsText("Голосовой поиск");
    }

    @Test
    public void searchByKeyword_FindAll_LinesResultsIsContains_withDataProvider() {
        String keyWord = "selenium";

        steps.searchByKeyword("selenium java")
                .verifyThatValuesIsContainsIgnoreCaseAndIgnoreSpace(keyWord)
                .verifyThatTopValueIsContains(keyWord);
    }

}