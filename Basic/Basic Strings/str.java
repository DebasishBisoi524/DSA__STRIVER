import java.util.*;

public class str {
    public static void main(String[] args) {
        String[] arr = { "internal", "interview", "internet", "interval" };
        string s1 = new string();
        s1.reverseString("12321");
        s1.palindromeCheck("12321");
        s1.largeOddNum("1232");
        s1.largestCommonPrefix(arr);
        s1.isomorphicString("egg", "add ");
        s1.rotatedString("abcd", "cdba");
        s1.validAnagram("listen", "silent");
        s1.frequencySort("tree");
    }
}

class string {
    public void reverseString(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            char ch = arr[start];
            arr[start] = arr[end];
            arr[end] = ch;

            start++;
            end--;
        }
        String revered = new String(arr);
        System.out.println("The Reverse of string " + s + " is: " + revered);
    }

    public boolean palindromeCheck(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                System.out.println("Not a palindrome");
                return false;
            }
            start++;
            end--;
        }
        System.out.println("It is a Palindrome");
        return true;
    }

    public String largeOddNum(String s) {
        int index = -1;
        int n = s.length() - 1;
        for (int i = n; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 != 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return " ";
        }

        int j = 0;
        while (j <= index && s.charAt(j) == '0') {
            j++;
        }
        System.out.println("The Largest Odd Number in the Stirng " + s + " is: " + s.substring(j, index + 1));
        return s.substring(j, index + 1);
    }

    public String largestCommonPrefix(String[] str) {
        Arrays.sort(str);
        String st1 = str[0];
        String st2 = str[str.length - 1];
        int index = 0;
        while (index < st1.length()) {
            if (st1.charAt(index) == st2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        String result = index == 0 ? "" : st1.substring(0, index);
        System.out.println("The Longest Common Prefix is: " + result);
        return result;
    }

    public boolean isomorphicString(String s, String t) {
        if (s.length() != t.length()) {
            System.out.println("The Length of the String must be equal.");
            return false;
        } else {
            int n = s.length();
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            for (int i = 0; i < n; i++) {
                if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                    System.out.println("Not Isomorphoic.");
                    return false;
                } else {
                    m1[s.charAt(i)] = i + 1;
                    m2[t.charAt(i)] = i + 1;
                }
            }
        }
        System.out.println("Two Strings are Isomorphic.");
        return true;
    }

    public boolean rotatedString(String str, String goal) {
        if (str.length() != goal.length()) {
            System.out.println("Both String must have equal length");
            return false;
        }
        String rotated = str + str;
        if (rotated.indexOf(goal) != -1) {
            System.out.println("The goal is the rotation of string");
            return true;
        }
        System.out.println("The goal is not rotation of string");
        return false;
    }

    public boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            System.out.println("The String length is not equal");
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println("Not a Valid Anagran");
                return false;
            }
        }
        System.out.println(s + " and " + t + " are anagram of each other");
        return true;
    }

    public List<Character> frequencySort(String s) {
        // Step 1: Initialize frequency array
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) ('a' + i));
        }

        // Step 2: Count character frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Print frequency array before sorting
        System.out.println("Frequencies before sorting:");
        for (Pair p : freq) {
            if (p.freq > 0) {
                System.out.println(p.ch + " -> " + p.freq);
            }
        }

        // Step 3: Sort based on frequency (desc) and alphabetically (asc)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Print frequency array after sorting
        System.out.println("\nFrequencies after sorting:");
        for (Pair p : freq) {
            if (p.freq > 0) {
                System.out.println(p.ch + " -> " + p.freq);
            }
        }

        // Step 4: Build result list
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0) {
                result.add(p.ch);
            }
        }

        // Print final sorted characters
        System.out.println("\nResult list:");
        System.out.println(result);

        return result;
    }

    class Pair {
        char ch;
        int freq;

        Pair(int freq, char ch) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}