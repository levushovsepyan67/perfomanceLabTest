import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);


        StringBuilder result = new StringBuilder();
        result.append(circularArray(n1, m1));
        result.append(circularArray(n2, m2));

        System.out.print(result.toString());
    }

    private static String circularArray(int n, int m) {
        StringBuilder element = new StringBuilder();
        int current = 0;

        do {
            element.append(current + 1);
            current = (current + m - 1) % n;
        } while (current != 0);

        return element.toString();
    }
}