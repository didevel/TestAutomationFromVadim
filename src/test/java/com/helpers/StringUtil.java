package com.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String stringSplitEvery(int perNum, String text, String splitter) {
        char[] chars = text.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            if (j == perNum) {
                j = 0;
                sb.append(".");
            }
            sb.append(chars[i]);
        }

        String reverse = sb.reverse().toString();
        String resutl = reverse;
        int index = reverse.lastIndexOf(splitter); // "."
        int length = reverse.length();
        if (index == (length - 1)) resutl = reverse.substring(0, index);

        return resutl;
    }

    public static String getStringNumbersFromText(String text) {
        int index = text.lastIndexOf("(");
        String substring = text.substring(0, index);

        Pattern compile = Pattern.compile("[0-9]*");
        Matcher matcher = compile.matcher(substring);

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) stringBuilder.append(matcher.group().trim());

        return stringBuilder.toString();
    }
}