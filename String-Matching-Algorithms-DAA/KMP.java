import java.util.Scanner;

public class KMP {

    static void computeLPS(String pattern, int[] lps) {

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int[] lps = new int[m];

        computeLPS(pattern, lps);

        int i = 0;
        int j = 0;
        boolean found = false;

        while (i < n) {

            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                found = true;
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        if (!found)
            System.out.println("Pattern not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        long start = System.nanoTime();

        search(text, pattern);

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}