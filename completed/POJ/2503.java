import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<String, String> map = new HashMap<String, String>();
        String input;
        while((input = f.readLine()).length() > 0) {
            StringTokenizer st = new StringTokenizer(input);
            String a = st.nextToken();
            String b = st.nextToken();
            map.put(b, a);
        }
        while((input = f.readLine()) != null) {
            out.println(map.containsKey(input) ? map.get(input) : "eh");
        }
        f.close();
        out.close();
    }
}