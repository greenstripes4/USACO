import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] spotted = new char[N][M];
        char[][] unspotted = new char[N][M];
        for(int i = 0; i < N; i++){
            spotted[i] = f.readLine().toCharArray();
        }
        for(int j = 0; j < N; j++){
            unspotted[j] = f.readLine().toCharArray();
        }
        int possible = 0;
        for(int k = 0; k < M; k++){
            boolean[] spottedContains = new boolean[4];
            boolean[] noSpottedContains = new boolean[4];
            for(char[] l: spotted){
                if(l[k] == 'A'){
                    spottedContains[0] = true;
                } else if(l[k] == 'C'){
                    spottedContains[1] = true;
                } else if(l[k] == 'G'){
                    spottedContains[2] = true;
                } else{
                    spottedContains[3] = true;
                }
            }
            for(char[] m: unspotted){
                if(m[k] == 'A'){
                    noSpottedContains[0] = true;
                } else if(m[k] == 'C'){
                    noSpottedContains[1] = true;
                } else if(m[k] == 'G'){
                    noSpottedContains[2] = true;
                } else{
                    noSpottedContains[3] = true;
                }
            }
            boolean validPos = true;
            for(int n = 0; n < 4; n++){
                if(spottedContains[n] && noSpottedContains[n]){
                    validPos = false;
                }
            }
            if(validPos){
                possible++;
            }
        }
        out.println(possible);
        f.close();
        out.close();
    }
}
