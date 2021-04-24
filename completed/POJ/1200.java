import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NC = Integer.parseInt(st.nextToken());
        char[] text = f.readLine().toCharArray();
        StringBuilder curSubstring = new StringBuilder();
        for(int i = 0; i < N; i++) {
            curSubstring.append(text[i]);
        }
        HashSet<String> distinctSubstrings = new HashSet<String>();
        distinctSubstrings.add(curSubstring.toString());
        for(int i = N; i < text.length; i++) {
            curSubstring.delete(0,1);
            curSubstring.append(text[i]);
            distinctSubstrings.add(curSubstring.toString());
        }
        out.println(distinctSubstrings.size());
        f.close();
        out.close();
    }
}
