package com.shiva.app;

public class Ass_01 {

    public String StringReverse(String str) {

        char[] try1 = str.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--)
            System.out.print(try1[i]);

        return str;
    }

    public boolean palindrome(String str1) {

        String str = "civic";
        if (str1.equals(str)) {
            return true;
        } else
            return false;
    }

    public String concatString(String str1, String str2) {
        String s = str1 + str2;
        return s;

    }
}
