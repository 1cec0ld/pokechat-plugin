package com.gmail.ak1cec0ld.plugins.pokechat.Mutators;

public class UpsidedownMutator {
    public static String toUpsidedown(String input){
        return flipText(PlainTextMutator.backwards(input));
    }

    private static String flipText(String input){
        String template = input;
        template = template.replaceAll("a","ɐ");
        template = template.replaceAll("b","ԛ");
        template = template.replaceAll("c","ɔ");
        template = template.replaceAll("d","ρ");
        template = template.replaceAll("e","ə");
        template = template.replaceAll("f","ɟ");
        template = template.replaceAll("g","ᵷ");
        template = template.replaceAll("h","ɥ");
        template = template.replaceAll("i","ᴉ");
        template = template.replaceAll("j","ɾ");
        template = template.replaceAll("k","ʞ");
        template = template.replaceAll("l","ɿ");
        template = template.replaceAll("m","ω");
        template = template.replaceAll("n","υ");
        template = template.replaceAll("o","ο");
        template = template.replaceAll("p","ḋ");
        template = template.replaceAll("q","Ƅ");
        template = template.replaceAll("r","ɹ");
        template = template.replaceAll("s","ѕ");
        template = template.replaceAll("t","ʇ");
        template = template.replaceAll("u","ƞ");
        template = template.replaceAll("v","ʌ");
        template = template.replaceAll("w","ɱ");
        template = template.replaceAll("x","х");
        template = template.replaceAll("y","λ");
        template = template.replaceAll("z","ȥ");

        template = template.replaceAll("'","˛");
        template = template.replaceAll("\"","„");
        template = template.replaceAll(",","́");
        template = template.replaceAll("\\.","͘");
        template = template.replaceAll("!","¡");
        template = template.replaceAll("\\?","¿");
        template = template.replaceAll("A","∀");
        template = template.replaceAll("B","ʚ");
        template = template.replaceAll("C","Ɔ");
        template = template.replaceAll("D","Ɑ");
        template = template.replaceAll("E","Ǝ");
        template = template.replaceAll("F","Ⅎ");
        template = template.replaceAll("G","פ");
        template = template.replaceAll("H","Η");
        template = template.replaceAll("I","Ι");
        template = template.replaceAll("J","ſ");
        template = template.replaceAll("K","ﻼ");
        template = template.replaceAll("L","˥");
        template = template.replaceAll("M","Ԝ");
        template = template.replaceAll("N","Ν");
        template = template.replaceAll("O","Ơ");
        template = template.replaceAll("P","Ԁ");
        template = template.replaceAll("Q","Ὁ");
        template = template.replaceAll("R","ᴚ");
        template = template.replaceAll("S","Ś");
        template = template.replaceAll("T","﬩");
        template = template.replaceAll("U","Ω");
        template = template.replaceAll("V","Λ");
        template = template.replaceAll("W","Μ");
        template = template.replaceAll("X","Χ");
        template = template.replaceAll("Y","ʎ");
        template = template.replaceAll("Z","Ζ");

        return template;
    }

}
