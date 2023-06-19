package com.shiva.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ass_01 ass=new Ass_01();
        System.out.println("***Reverse String***");
        System.out.println(ass.StringReverse("Shiva"));
        System.out.println("***Check Palindrome***");
        System.out.println(ass.palindrome("civic"));
        System.out.println("***String Concat***");
        System.out.println(ass.concatString("hello","world"));
    }
}
