import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
O(n)
8
MF MF
FM FF MF MM
MM FF
MF MF MF MF FF
MF
MM
FF
MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF MF
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens()){
                sb.append(st.nextToken());
            }
            char[] chars = sb.toString().toCharArray();
            int mc = 0;
            int fc = 0;
            for(char j: chars){
                if(j == 'M'){
                    mc++;
                }
                else{
                    fc++;
                }
            }
            if(mc == fc && mc > 1){
                System.out.println("LOOP");
            }
            else{
                System.out.println("NO LOOP");
            }
        }
    }
}
