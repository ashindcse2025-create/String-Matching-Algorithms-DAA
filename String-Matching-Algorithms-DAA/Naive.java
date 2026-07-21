import java.util.Scanner;

public class Naive {

    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        for (int i = 0; i <= n - m; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + i);
                found = true;
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