import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // consume newline
        while (t-- > 0) {
            String str = scanner.nextLine();
            printPattern(str);
        }
    }

    private static void printPattern(String str) {
        int[] freq = new int[256]; // support full ASCII
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            char upper = Character.toUpperCase(ch);
            if (freq[upper] == 0 || freq[upper] % 2 == 0) {
                result.append(ch);
            }
            freq[upper]++;
        }
        System.out.println(result);
    }
}
