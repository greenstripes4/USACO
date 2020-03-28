/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int t = 1;
        while((input = f.readLine()) != null){
            if(t > 1){
                out.println("\n**********************************\n");
            }
            out.println("Problem #" + t + "\n");
            int N = Integer.parseInt(input);
            int[][] connected = new int[N][N];
            int M = Integer.parseInt(f.readLine());
            for(int i = 0; i < M; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String dir = st.nextToken();
                int c1 = Integer.parseInt(st.nextToken())-1;
                int c2 = Integer.parseInt(st.nextToken())-1;
                if(dir.equals("H")){
                    connected[c1][c2] |= 1;
                } else {
                    connected[c2][c1] |= 2;
                }
            }
            boolean found = false;
            for(int i = 1; i <= N; i++){
                int count = 0;
                for(int j = 0; j < N-i; j++){
                    for(int k = 0; k < N-i; k++){
                        boolean valid = true;
                        for(int l = 0; l < i; l++){
                            if((connected[j][k+l] & 1) == 0){
                                valid = false;
                                break;
                            }
                            if((connected[j+i][k+l] & 1) == 0){
                                valid = false;
                                break;
                            }
                            if((connected[j+l][k] & 2) == 0){
                                valid = false;
                                break;
                            }
                            if((connected[j+l][k+i] & 2) == 0){
                                valid = false;
                                break;
                            }
                        }
                        if(valid){
                            found = true;
                            count++;
                        }
                    }
                }
                if(count > 0){
                    out.println(count + " square (s) of size " + i);
                }
            }
            if(!found){
                out.println("No completed squares can be found.");
            }
            t++;
        }
        out.close();
        f.close();
    }
}
