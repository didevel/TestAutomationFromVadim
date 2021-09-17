package com.testOne;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class TmpExperimental {

    public static void main(String[] args) {
        String expectedValue = "selenium";

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "", " ", "selenium", "Selenium", " Selenium ");

        List<String> seleniumList = new ArrayList<>();
        Collections.addAll(seleniumList, "selenium", "selenium");


        list.forEach(v -> System.out.print("value: _" + v + "_, "));

        List<String> collect = list.stream()
                .filter(v -> !v.isEmpty() & !v.trim().equals(""))
                .map(v -> v.trim().toLowerCase())
                .collect(Collectors.toList());

        System.out.println("___");
        collect.forEach(v -> System.out.print("value: _" + v + "_, "));
    }

    // Experimental and trash..
    @Test
    public void experimentalCollections() {
        // Use Hamcrest _ How!?
//        MatcherAssert.assertThat("dnt contains selenium", g.getText(), "selenium");
//        MatcherAssert.assertThat(g.getText(), contains("selenium"));

        String expectedValue = "selenium";

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "", " ", "selenium", "Selenium", " Selenium ");

        List<String> seleniumList = new ArrayList<>();
        Collections.addAll(seleniumList, "selenium", "selenium");

        // Dnt wrk
        // https://www.baeldung.com/hamcrest-collections-arrays
//        MatcherAssert.assertThat(seleniumList, contains(expectedValue));
        // wrk but in not like contains it like equals 2 collections
//        MatcherAssert.assertThat(seleniumList, contains("selenium", "selenium"));

        // hz how
//        assertThat(seleniumList, contains(expectedValue//                hasProperty("name", is("foo")),));

        // how to use filter ?
        assertTrue(seleniumList.stream()
                .filter(element -> element.isEmpty() & element.trim().equals(""))
                // work for any if contains one expected
//                .anyMatch(item -> expectedValue.equals(item)));
                .allMatch(expectedValue::equals));


        // dnt wrk
//        Assertions.assertThat(list)
//                .extracting((v) -> v.toLowerCase())
//                .containsAll(Collections.singleton("selenium"));

        // Work
//        forEachWay(expectedValue, list);
    }

    private void forEachWay(String expectedValue, List<String> list) {
        for (String element : list) {
            if (!element.trim().isEmpty())
                assertThat(element.toLowerCase())
                        .as(expectedValue + " - expected value, is not contains")
                        .containsIgnoringCase(expectedValue);
        }
    }

    @Test
    public static void collectionsTest() {
        List<Integer> numbers = Lists.newArrayList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        assertThat(numbers).contains(12);
        assertThat(numbers).doesNotContain(50);
    }
}
