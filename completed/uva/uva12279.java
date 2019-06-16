import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int casenum = 0;
        while((input = f.readLine())!=null && !input.equals("0")){
            casenum++;
            int pos = 0;
            StringTokenizer st = new StringTokenizer(input);
            int numoftreats = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i<numoftreats;i++){
                if (Integer.parseInt(st.nextToken())>0) {
                    pos++;
                } else {
                    pos--;
                }
            }
            System.out.println("Case " + casenum + ": " + pos);
        }
    }
}
