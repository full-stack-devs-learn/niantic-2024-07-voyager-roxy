package com.niantic;

public class EscapeCharacters {

    public static void main(String[] args)
    {
        // \" - include a quote in a string
        // \n - new line
        // \t - tab
        String product = "this\nis\na\nnew\nline";

        String multiLineString = """
                this is my first line.
                this is the second line
                this is the last line""";

        System.out.println(product);
        System.out.println(multiLineString);
    }
}
