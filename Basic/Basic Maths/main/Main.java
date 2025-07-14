package main;

import Maths.maths;

public class Main {

    public static void main(String[] args) {
        maths m1 = new maths();
        m1.countNumber(2456);
        m1.countOddDigits(2456);
        m1.reverseNumber(2456);
        m1.checkPalindrome(121);
        m1.largestDigit(2456);
        m1.divisor(36);
        m1.factorial(0);
        m1.checkArmstrong(370);
        m1.checkPerfectNumber(6);
        m1.checkPrimeNumber(1237);
        m1.GCD(20, 100);
        m1.LCM(3, 5);
    }
}