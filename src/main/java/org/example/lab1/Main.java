package org.example.lab1;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    private static final String PROJECT_PATH = Paths.get("").toAbsolutePath().toString();
    private static final String SAVE_FILE = PROJECT_PATH + File.separator + "file.txt";

    public static void main(String[] args) {
        int[][] m = Utils.readFromFile(SAVE_FILE);
        int[] d = genDenominators(m.length);
        Lab1 lab1 = new Lab1(m, d);

        for (int i = 0; i < m.length; i++) {
            System.out.print(String.format("(%s)/%d", Utils.toString(m[i]), d[i]));
            if(i!=m.length-1){
                System.out.print(" + ");
            } else {
                System.out.print(" = ");
            }
        }
        System.out.print(String.format("(%s)/%d", Utils.toString(lab1.getResult()), lab1.getCommonDenominator()));
    }

    private static int[] genDenominators(int length) {
        int[] d = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            d[i] = random.nextInt(5) + 1;
        }
        return d;
    }


}
