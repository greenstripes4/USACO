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
        while(true) {
            int n = f.nextInt();
            if(n == 0) {
                break;
            }
            int[] tianJi = new int[n];
            int[] king = new int[n];
            for(int i = 0; i < n; i++) {
                tianJi[i] = f.nextInt();
            }
            for(int i = 0; i < n; i++) {
                king[i] = f.nextInt();
            }
            Arrays.sort(tianJi);
            Arrays.sort(king);
            int tianJiInd = n-1;
            int kingInd = n-1;
            int totalEarnings = 0;
            while(tianJiInd >= 0 && kingInd >= 0){
                if(tianJi[tianJiInd] > king[kingInd]){
                    totalEarnings += 200;
                    tianJiInd--;
                    kingInd--;
                } else if(tianJi[tianJiInd] == king[kingInd]) {
                    kingInd--;
                } else {
                    totalEarnings -= 200;
                    kingInd--;
                }
            }
            out.println(totalEarnings);
        }
        f.close();
        out.close();
    }
}
