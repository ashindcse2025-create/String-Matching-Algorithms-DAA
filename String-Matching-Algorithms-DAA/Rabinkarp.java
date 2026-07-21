import java.util.Scanner;

public class RabinKarp {

    static final int d = 256;
    static final int q = 101;

    public static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int p = 0;
        int t = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        boolean found = false;

        for (int i = 0; i <= n - m; i++) {

            if (p == t) {

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

            if (i < n - m) {

                t = (d * (t - text.charAt(i) * h)
                        + text.charAt(i + m)) % q;

                if (t < 0)
                    t += q;
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