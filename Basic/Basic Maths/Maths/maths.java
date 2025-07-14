package Maths;

import java.util.Arrays;

public class maths {
    public int countNumber(int number) {
        if (number == 0) {
            return 1;
        } else {
            int count = 0;
            while (number > 0) {
                number = number / 10;
                count++;
            }
            System.out.println("The number of digits are: " + count);
            return count;
        }
    }

    public int countOddDigits(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                count++;
            }
            number = number / 10;
        }
        System.out.println("The number of odd digits are: " + count);
        return count;
    }

    public int reverseNumber(int number) {
        int original = number;
        int revNum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            revNum = (revNum * 10) + lastDigit;
            number = number / 10;
        }
        System.out.println("The Reverse of " + original + " is: " + revNum);
        return revNum;
    }

    public boolean checkPalindrome(int number) {
        int original = number;
        int rev = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            rev = (rev * 10) + lastDigit;
            number = number / 10;
        }
        if (original == rev) {
            System.out.println("The Number is a palindrome");
            return true;
        } else {
            System.out.println("Not a Palindrome");
            return false;
        }
    }

    public int largestDigit(int number) {
        int largest = 0;
        while (number > 0) {
            int lastDigits = number % 10;
            if (largest < lastDigits) {
                largest = lastDigits;
            }
            number = number / 10;
        }
        System.out.println("The Largest Number is: " + largest);
        return largest;
    }

    public int[] divisor(int number) {
        int[] temp = new int[number];
        int count = 0;
        int sqrtN = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrtN; i++) {
            if (number % i == 0) {
                temp[count++] = i;
                if (i != number / i) {
                    temp[count++] = number / i;
                }
            }
        }
        int[] ans = Arrays.copyOf(temp, count);
        Arrays.sort(ans);
        System.out.println("Divisors: " + Arrays.toString(ans));
        return ans;
    }

    public int factorial(int number) {
        int original = number;
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative number");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("The Fatorial of " + original + " is: " + result);
        return result;
    }

    public boolean checkArmstrong(int number) {
        int original = number;
        int sum = 0;
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }

        number = original;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += Math.pow(lastDigit, count);
            number = number / 10;
        }
        if (sum == original) {
            System.out.println("The Number " + original + " is an Armstrong Number. ");
            return true;
        } else {
            System.out.println("Not an Armstrong Number");
            return false;
        }
    }

    public boolean checkPerfectNumber(int number) {
        int original = number;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (sum == original) {
            System.out.println("The Number " + original + " is a Perfect Number");
            return true;
        } else {
            System.out.println("Not a Perfect Number");
            return false;
        }
    }

    public boolean checkPrimeNumber(int number) {
        int original = number;
        if (number <= 1) {
            System.out.println("0 and 1 are not prime number");
            return false;
        }
        int sqrtN = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrtN; i++) {
            if (number % i == 0) {
                System.out.println("The Number " + number
                        + " is not a Prime Number");
                return false;
            }
        }
        System.out.println("The Number " + original + " is a Prime Number.");
        return true;

    }

    public int GCD(int n1, int n2) {
        int number1 = n1;
        int number2 = n2;
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println("The Greatest Common Divisor between " + number1 + " and " + number2 + " is: " + gcd);
        return gcd;
    }

    public int LCM(int n1, int n2) {
        int number1 = n1;
        int number2 = n2;
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }

        int productOfTwo = n1 * n2;
        int Lcm = productOfTwo / gcd;
        System.out.println("The Least Common factor between " + number1 + " and " + number2 + " is: " + Lcm);
        return Lcm;
    }

}