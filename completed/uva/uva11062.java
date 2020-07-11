import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();
        String line;
        while ((line = f.readLine()) != null) {
            if (line.length() == 0) {
                continue;
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '-' && i < line.length() - 1)) {
                    sb.append(c);
                } else if (sb.length() > 0 && c != '-') {
                    set.add(sb.toString().toLowerCase());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0 && line.charAt(line.length() - 1) != '-') {
                set.add(sb.toString().toLowerCase());
                sb = new StringBuilder();
            }
        }
        for (String s : set) {
            out.println(s);
        }
        f.close();
        out.close();
    }
}
