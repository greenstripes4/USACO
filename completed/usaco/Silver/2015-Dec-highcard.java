import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        int N = Integer.parseInt(f.readLine());
        boolean[] e = new boolean[2*N+1];
        for(int i = 0; i < N; i++){
            e[Integer.parseInt(f.readLine())] = true;
        }
        int[] elsie = new int[N];
        int[] bessie = new int[N];
        int ind1 = 0;
        int ind2 = 0;
        for(int i = 1; i <= 2*N; i++){
            if(!e[i]){
                bessie[ind1] = i;
                ind1++;
            } else {
                elsie[ind2] = i;
                ind2++;
            }
        }
        int points = 0;
        int p1 = 0;
        int p2 = 0;
        while(p1 < N && p2 < N){
            if(bessie[p1] < elsie[p2]){
                p1++;
            } else {
                points++;
                p1++;
                p2++;
            }
        }
        out.println(points);
        f.close();
        out.close();
    }
}
