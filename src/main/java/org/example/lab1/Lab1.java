package org.example.lab1;

/**
 * @author Kaldina Darya
 * @version 1.0
 * @since 1.0
 * Task 1
 */
public class Lab1 {
    /**
     * Array of variables of a mathematical function
     */
    private int[][] massive;
    /**
     * Array of variable denominators of the function
     */
    private int[] denominators;
    /**
     * Common denominator
     */
    private int cDenominator;
    /**
     * The resulting function
     */
    private int[] result;

    /**
     * Example: 32x^2+2x^1+1x^0 + 2x^2+1x^1+32x^0 its [0][1,2,32] and [1][32,1,2]
     * @see Utils
     * @param massive - Array of variables of a mathematical function
     * @param denominators - Array of variable denominators of the function
     */
    public Lab1(int[][] massive, int[] denominators) {
        this.massive = massive;
        this.denominators = denominators;
        if (massive.length != denominators.length) {
            throw new RuntimeException();
        }
        cDenominator = Utils.commonDenominator(denominators);
        calculate();
    }

    /**
     * Counting the result
     */
    private void calculate() {
        result = new int[]{0, 0, 0};
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                result[j] += (cDenominator / denominators[i]) * massive[i][j];
            }
        }
    }

    /**
     * @return The resulting function
     */
    public int[] getResult() {
        return result;
    }

    /**
     * @return Common denominator
     */
    public int getCommonDenominator() {
        return cDenominator;
    }
}
