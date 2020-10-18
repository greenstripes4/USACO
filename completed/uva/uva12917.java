import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int P = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int O = Integer.parseInt(st.nextToken());
            out.println(O-P < H ? "Hunters win!" : "Props win!");
        }
        f.close();
        out.close();
    }
}
