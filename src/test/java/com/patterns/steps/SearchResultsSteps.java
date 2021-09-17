package com.patterns.steps;

import com.patterns.pages.SearchResultsPage;

public class SearchResultsSteps {
    private final SearchResultsPage searchResultsSteps = new SearchResultsPage();

    public SearchResultsSteps verifyThatTopValueIsContains(String expectedValue) {
        searchResultsSteps.assertThatExpectedValueIsContainsOnSearchTop(expectedValue);
        return this;
    }

    public SearchResultsSteps verifyThatValueIsContainsIgnoreCaseSensitive(String expectedValue) {
        searchResultsSteps.assertThatExpectedValueIsContainsIgnoreCaseSensitive(expectedValue);
        return this;
    }

    public SearchResultsSteps verifyThatValuesIsContainsIgnoreCaseAndIgnoreSpace(String expectedValue) {
        searchResultsSteps.assertThatExpectedValuesIsContainsIgnoreCaseAndIgnoreSpace(expectedValue);
        return this;
    }
}