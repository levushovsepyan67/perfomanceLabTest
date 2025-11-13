import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        br.close();

        Collections.sort(numbers);

        int n = numbers.size();
        int minMov = 0;
        for (int i = 0; i < n / 2; i++) {
            minMov += numbers.get(n - 1 - i) - numbers.get(i);
        }

        if (minMov <= 20) {
            System.out.println(minMov);
        } else {
            System.out.println("20 ходов недостаточно");
        }
    }
}