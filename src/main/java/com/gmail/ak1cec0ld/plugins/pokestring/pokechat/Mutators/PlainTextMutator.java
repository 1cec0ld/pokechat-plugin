package com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Mutators;

public class PlainTextMutator {
    public static String backwards(String input){
        return new StringBuilder(input).reverse().toString();
    }
    public static String scramble(String input){
        char[] temp = input.toCharArray();
        char t;
        for(int i = 0; i < temp.length; i++){
            t = temp[i];
            int j = (int)(Math.random() * temp.length);
            temp[i] = temp[j];
            temp[j] = t;
        }
        return new String(temp);
    }
}
