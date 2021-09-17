package com.patterns.steps;

import com.patterns.pages.SearchPage;

public class SearchSteps {
    private final SearchPage searchPage = new SearchPage();

    public SearchResultsSteps searchByKeyword(String keyword) {
        searchPage.fillTheSearchField(keyword);   // step 1
//        searchPage.pressEnter();   // step 2
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchResultsSteps searchByKeywordWithJavaScript(String keyword) {
        searchPage.fillTheSearchField(keyword);   // step 1
//        searchPage.pressEnter();   // step 2
        searchPage.clickSearchButtonOrPressEnterWithJavaScript();
        return new SearchResultsSteps();
    }

    public SearchResultsSteps searchByKeywordFromCLipboard(String keyword) {
        searchPage.pasteToSearchFieldFromClipboard(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchSteps moveToVoiceSearchButton() {
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }

    public SearchSteps clickToSearchButtonWithJavaScript() {
        searchPage.clickSearchButtonOrPressEnterWithJavaScript();
        return this;
    }
}