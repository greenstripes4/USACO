/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    private static HashMap<Character,int[]> matrices;
    private static int totalMultiplications;
    private static int[] getTotalMultiplications(String expression){
        if(expression.length() == 1){
            return matrices.get(expression.charAt(0));
        }
        String stripped = expression.substring(1,expression.length()-1);
        while(stripped.charAt(0) == '(' && stripped.charAt(stripped.length()-1) == ')'){
            stripped = stripped.substring(1,stripped.length()-1);
        }
        char[] asArray = stripped.toCharArray();
        int[] matrix1;
        int[] matrix2;
        if(asArray[0] != '(' && asArray[asArray.length-1] != ')') {
            matrix1 = getTotalMultiplications(Character.toString(asArray[0]));
            matrix2 = getTotalMultiplications(Character.toString(asArray[asArray.length-1]));
        } else if(asArray[0] != '(') {
            matrix1 = getTotalMultiplications(Character.toString(asArray[0]));
            matrix2 = getTotalMultiplications(stripped.substring(1));
        } else if(asArray[asArray.length-1] != ')'){
            matrix1 = getTotalMultiplications(stripped.substring(0,stripped.length()-1));
            matrix2 = getTotalMultiplications(Character.toString(asArray[asArray.length-1]));
        } else {
            int ind = 0;
            for(int i = 0; i < asArray.length-1; i++){
                if(asArray[i] == ')' && asArray[i+1] == '('){
                    ind = i;
                    break;
                }
            }
            matrix1 = getTotalMultiplications(stripped.substring(0,ind+1));
            matrix2 = getTotalMultiplications(stripped.substring(ind+1));
        }
        if(matrix1[1] != matrix2[0] || matrix1[0] == -1 || matrix1[1] == -1 || matrix2[1] == -1){
            totalMultiplications = -1;
            return new int[]{-1,-1};
        }
        totalMultiplications += (matrix1[0]*matrix1[1]*matrix2[1]);
        return new int[]{matrix1[0],matrix2[1]};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        matrices = new HashMap<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            char name = st.nextToken().charAt(0);
            int[] dimensions = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            matrices.put(name,dimensions);
        }
        String input;
        while((input = f.readLine()) != null){
            totalMultiplications = 0;
            getTotalMultiplications(input);
            out.println(totalMultiplications < 0 ? "error" : totalMultiplications);
        }
        out.close();
        f.close();
    }
}
