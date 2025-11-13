import java.io.*;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws Exception {

        String ellips = args[0];
        String point = args[1];

        Scanner sc = new Scanner(new File(ellips));
        double centerX = sc.nextDouble();
        double centerY = sc.nextDouble();
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();

        sc = new Scanner(new File(point));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] parts = line.split(" ");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);

            double value = Math.pow(x - centerX, 2) / Math.pow(a, 2) +
                    Math.pow(y - centerY, 2) / Math.pow(b, 2);

            if (Math.abs(value - 1.0) < 1e-9) {
                System.out.println(0);
            } else if (value < 1.0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        sc.close();
    }
}
