import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int N = f.nextInt();
            if(N == 0){
                break;
            }
            String[] cards = new String[N];
            String[] words = new String[N];
            for(int i = 0; i < N; i++){
                cards[i] = f.next();
                words[i] = f.next();
            }
            String[] res = new String[N];
            int pos = -1;
            for(int i = 0; i < N; i++){
                int jumps = words[i].length();
                while(jumps > 0){
                    pos = (pos+1)%N;
                    if(res[pos] == null){
                        jumps--;
                    }
                }
                res[pos] = cards[i];
            }
            out.print(res[0]);
            for(int i = 1; i < N; i++){
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
