package com.ctci.isunique;

public class App {
    public static void main(String[] args) {
        System.out.println("abc -> " + isUniqueCharsLoops("abc"));
        System.out.println("abca -> " + isUniqueCharsLoops("abca"));
        System.out.println("abca -> " + isUniqueCharsSort("abca"));

        System.out.println("abc -> " + isUniqueCharsFlagArrayASCII("abc"));
        System.out.println("abca -> " + isUniqueCharsFlagArrayASCII("abca"));
        System.out.println("abca -> " + isUniqueCharsSort("abca"));
    }

    /**
     * Complexity: O(n^2)
     * Space     : O(1) we don't allocate any memory
     */
    private static boolean isUniqueCharsLoops(String abc) {
        char[] charList = abc.toCharArray();

        for (int i = 0; i < charList.length - 2; i++) {
            for (int j = i + 1; j < charList.length; j++) {
                if (charList[i] == charList[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Complexity: O(n), n - string length
     *             O(min(c, n)), c - character set length
     * Space     : O(1), the whole memory is allocated at beginning and is depended from size of character set.
     */
    private static boolean isUniqueCharsFlagArrayASCII(String abc) {
        if (abc.length() > 128) {
            // We can break if length is bigger then char set. It is impossible to build unique string. At least one of char needs to repeat.
            return false;
        }

        boolean[] flags = new boolean[128];
        char[] charList = abc.toCharArray();

        for (int i = 0; i < charList.length; i++) {
            if (flags[charList[i]]) return false;

            flags[charList[i]] = true;
        }

        return true;
    }

    /**
     * Complexity: O(n) + O(?) of sort - optimistic it can be O(n log(n))
     * Space     : O(1) + O(?) of sort - we don't know how the sort algorithm works
     */
    private static boolean isUniqueCharsSort(String abc) {
        int[] charList = abc.chars().sorted().toArray();

        for (int i = 0; i < charList.length - 1; i++) {
            if (charList[i] == charList[i + 1]) return false;
        }

        return true;
    }
}
