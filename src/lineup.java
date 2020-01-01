/*
ID: strongh2
LANG: JAVA
PROG: lineup
TASK: lineup
 */

import java.io.*;
import java.util.*;

public class lineup {
    public static boolean isValid(String[] order, String[][] constraints){
        for(String[] i: constraints){
            int firstInd = -1;
            int secondInd = -1;
            for(int j = 0; j < 8; j++){
                if(order[j].equals(i[0])){
                    firstInd = j;
                } else if(order[j].equals(i[1])){
                    secondInd = j;
                }
            }
            if(Math.abs(firstInd-secondInd) != 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int N = Integer.parseInt(f.readLine());
        String[][] constraints = new String[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    constraints[i][0] = st.nextToken();
                } else if (j == 5) {
                    constraints[i][1] = st.nextToken();
                } else {
                    st.nextToken();
                }
            }
        }
        String[] cows = {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
        boolean shouldBreak = false;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i != j){
                    for(int k = 0; k < 8; k++){
                        if(i != k && j != k){
                            for(int l = 0; l < 8; l++){
                                if(i != l && j != l && k != l){
                                    for(int m = 0; m < 8; m++){
                                        if(i != m && j != m && k != m && l != m){
                                            for(int n = 0; n < 8; n++){
                                                if(i != n && j != n && k != n && l != n && m != n){
                                                    for(int o = 0; o < 8; o++){
                                                        if(i != o && j != o && k != o && l != o && m != o && n != o){
                                                            for(int p = 0; p < 8; p++){
                                                                if(i != p && j != p && k != p && l != p && m != p && n != p && o != p){
                                                                    String[] ordering = {cows[i],cows[j],cows[k],cows[l],cows[m],cows[n],cows[o],cows[p]};
                                                                    if(isValid(ordering,constraints)){
                                                                        for(String q: ordering){
                                                                            out.println(q);
                                                                        }
                                                                        shouldBreak = true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if(shouldBreak){
                                                            break;
                                                        }
                                                    }
                                                }
                                                if(shouldBreak){
                                                    break;
                                                }
                                            }
                                        }
                                        if(shouldBreak){
                                            break;
                                        }
                                    }
                                }
                                if(shouldBreak){
                                    break;
                                }
                            }
                        }
                        if(shouldBreak){
                            break;
                        }
                    }
                }
                if(shouldBreak){
                    break;
                }
            }
        }
        out.close();
        f.close();
    }
}
