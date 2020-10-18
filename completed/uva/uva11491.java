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
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            char[] number =  f.readLine().toCharArray();
            char[] winnings = new char[N-D];
            int index = 0;
            for(int i = 0; i < N; i++) {
                while(index > 0 && index+N-i > N-D && winnings[index-1] < number[i]) {
                    index--;
                }
                if(index < N-D) {
                    winnings[index++] = number[i];
                }
            }
            for(int i = 0; i < N-D; i++) {
                out.print(winnings[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
