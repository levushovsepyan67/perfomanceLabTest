import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        Map<String, String> values = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("\"id\":")) {
                String id = line.split(":")[1].replace(",", "").trim();
                String valueLine = br.readLine();
                String val = valueLine.split(":")[1].replace("\"", "").replace(",", "").trim();
                values.put(id, val);
            }
        }
        br.close();

        br = new BufferedReader(new FileReader(args[1]));
        PrintWriter pw = new PrintWriter(new FileWriter(args[2]));

        while ((line = br.readLine()) != null) {
            if (line.contains("\"id\":")) {
                String id = line.split(":")[1].replace(",", "").trim();
                pw.println(line);

                String nextLine = br.readLine();
                if (nextLine.contains("\"value\":\"\"")) {
                    if (values.containsKey(id)) {
                        pw.println("    \"value\": \"" + values.get(id) + "\",");
                    } else {
                        pw.println(nextLine);
                    }
                } else {
                    pw.println(nextLine);
                }
            } else {
                pw.println(line);
            }
        }

        br.close();
        pw.close();
    }
}