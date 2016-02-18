package com.sreeja.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**Helper class that runs all sub-tasks of Assignment 1 interactively**/
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Usage: (Type the function number followed by argument)\n" +
            "[1] Easiest exercise ever \n" +
            "[2] Horizontal line (accepts 1 arg) \n" +
            "[3] Vertical line (accepts 1 arg) \n" +
            "[4] Right Triangle (accepts 1 arg) \n" +
            "[5] Isosceles Triangle (accepts 1 arg) \n" +
            "[6] Diamond (accepts 1 arg) \n" +
            "[7] Diamond with name (accepts 1 arg) \n" +
            "[8] FizzBuzz \n" +
            "[9] Prime Factor generation (accepts 1 arg)");
            System.exit(0);
        }

        int choice = 0, arg = 0;
        try {
            choice = Integer.parseInt(args[0]);
            if (choiceRequiresArgument(choice)) {
                if (args.length > 1) {
                    arg = Integer.parseInt(args[1]);
                } else {
                    System.exit(1);
                }
            }
        } catch(Exception e) {
            System.exit(1);
        }
        switch (choice) {
            case 1:
                easiest();
                break;
            case 2:
                printNAsterisksHorizontally(arg);
                break;
            case 3:
                printNAsterisksVertically(arg);
                break;
            case 4:
                printRightTriangleWithBaseN(arg);
                break;
            case 5:
                printIsoscelesTriangleOfLevelN(arg);
                break;
            case 6:
                printDiamond(arg);
                break;
            case 7:
                printDiamondWithName(arg);
                break;
            case 8:
                fizzBuzz();
                break;
            case 9:
                generate(arg).forEach(System.out::println);
                break;
            default:
                System.out.println("Unexpected option received. Exiting");
                System.exit(1);
        }
    }

    private static boolean choiceRequiresArgument(int choice) {
        return (choice >= 2 && choice <= 7) || choice == 9;
    }

    /**
     * Prints a single asterisk
     */
    private static void easiest() {
        System.out.println("*");
    }

    /**
     * Prints n asterisks in a row
     * Assuming new line  is printed before and after
     * the line for formatting
     * @param n number of asterisks to be printed n > 0
     */
    private static void printNAsterisksHorizontally(int n) {
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Prints n asterisks vertically
     * Assuming new line  is printed before and after
     * the line for formatting
     * @param n number of asterisks to be printed n > 0
     */
    private static void printNAsterisksVertically(int n) {
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.println("*");
        }
        System.out.println();
    }

    /**
     * Prints right angled triangle with a base of n asterisks
     * Assume padding of newline at top and bottom
     * @param n number of asterisks at base n > 0
     */
    private static void printRightTriangleWithBaseN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    /**
     * Print isosceles triangle of n levels
     * Assume padding of newline at top and bottom
     * @param n no of levels of isosceles triangle n > 0
     */
    private static void printIsoscelesTriangleOfLevelN(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println();
            for(int j = 1;j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <= (2*i)-1; k++) {
                System.out.print("*");
            }
        }

        System.out.println();
    }

    /**
     * Print centered diamond of 2*n -1 levels
     * Assume padding of newline at top and bottom
     * @param n - half the number of levels of the centered diamond; n > 0
     */
    private static void printDiamond(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println();
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <= (2*i)-1; k++) {
                System.out.print("*");
            }
        }
        for(int i = n - 1; i >= 1; i--) {
            System.out.println();
            for(int j = i; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <= (2*i)-1; k++) {
                System.out.print("*");
            }
        }

        System.out.println();
    }

    /**
     * Print centered diamond of 2*n -1 levels
     * Pre-chosen name is printed in the middle line
     * Assume padding of newline at top and bottom
     * @param n - half the number of levels of the centered diamond; n > 0
     */
    private static void printDiamondWithName(int n) {
        for(int i = 1; i < n; i++) {
            System.out.println();
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <= (2*i)-1; k++) {
                System.out.print("*");
            }
        }
        System.out.println("Sreeja");
        for(int i = n - 1; i >= 1; i--) {
            System.out.println();
            for(int j = i; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1;k <= (2*i)-1; k++) {
                System.out.print("*");
            }
        }

        System.out.println();
    }

    /**
     * Prints numbers from 1 to 100
     * Instead of numbers divisible by three print "Fizz".
     * Instead of numbers divisible by five print "Buzz".
     * Instead of numbers divisible by three and five print "FizzBuzz".
     */
    private static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            boolean fizzbuzzed = false;
            if (i % 3 == 0) {
                System.out.print("Fizz");
                fizzbuzzed = true;
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
                fizzbuzzed = true;
            }
            if (!fizzbuzzed) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Generate prime factors of n
     * @param n number whose prime factors are generated, n > 0
     * @return list of integer prime factors
     */
    private static List<Integer> generate(int n) {

        List<Integer> factors = new ArrayList<>();

        if (n == 1) {
            return factors;
        }

        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        if (factors.isEmpty()) {
            factors.add(n);
        }
        return factors;
    }
}
