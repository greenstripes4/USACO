import java.io.*;
import java.util.StringTokenizer;
/*
O(1)
1 5 3 5
23 59 0 34
21 33 21 10
23 59 23 59
1 1 1 1
23 0 0 23
23 1 23 1
0 1 0 1
0 0 0 0
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0 0 0 0"))){
            StringTokenizer st = new StringTokenizer(input);
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int h_diff = h2 - h1;
            int m_diff = m2 - m1;
            if(m_diff < 0){
                h_diff--;
                m_diff += 60;
            }
            if(h_diff < 0){
                h_diff += 24;
            }
            System.out.println(h_diff*60+m_diff);
        }
    }
}
