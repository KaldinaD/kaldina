package org.example.lab2;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class TransferNumberToText {
    private static RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT);

    public static String toString(int number) {
        return rbnf.format(number);
    }
}
