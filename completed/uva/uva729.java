import java.io.*;
import java.util.*;

public class Main{
    private static void printAllStrings(int N, int H, String cur, PrintWriter out){
        if(cur.length() == N){
            int count = 0;
            for(char i: cur.toCharArray()){
                if(i == '1'){
                    count++;
                }
            }
            if(count == H){
                out.println(cur);
            }
            return;
        }
        printAllStrings(N,H,cur+"0",out);
        printAllStrings(N,H,cur+"1",out);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int dataSets = f.nextInt();
        for(int i = 0; i < dataSets; i++){
            if(i > 0){
                out.println();
            }
            int N = f.nextInt();
            int H = f.nextInt();
            printAllStrings(N,H,"",out);
        }
        f.close();
        out.close();
    }
}
