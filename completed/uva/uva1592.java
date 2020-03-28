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
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            String[][] data = new String[rows][cols];
            for(int i = 0; i < rows; i++){
                data[i] = f.readLine().split(",");
            }
            HashMap<String,Integer> map = new HashMap<>();
            boolean found = false;
            for(int i = 0; i < rows; i++){
                for(int k = 0; k < cols; k++){
                    for(int l = k+1; l < cols; l++){
                        String key = data[i][k] + " " + data[i][l] + " " + k + " " + l;
                        if(map.containsKey(key)){
                            out.println("NO");
                            out.println((map.get(key)+1)+" "+(i+1));
                            out.println((k+1)+" "+(l+1));
                            found = true;
                            break;
                        } else {
                            map.put(key,i);
                        }
                    }
                    if(found){
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            if(!found){
                out.println("YES");
            }
        }
        out.close();
        f.close();
    }
}
