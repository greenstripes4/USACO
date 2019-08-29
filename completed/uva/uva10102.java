import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int side = Integer.parseInt(input);
            char[][] field = new char[side][side];
            for(int i = 0; i < side; i++){
                char[] temp = f.readLine().toCharArray();
                field[i] = temp;
            }
            ArrayList<int[]> ones = new ArrayList<>();
            ArrayList<int[]> threes = new ArrayList<>();
            for(int j = 0; j < side; j++){
                for(int k = 0; k < side; k++){
                    if(field[j][k] == '1'){
                        ones.add(new int[]{j,k});
                    } else if(field[j][k] == '3'){
                        threes.add(new int[]{j,k});
                    }
                }
            }
            int max = 1;
            for(int[] l: ones){
                int min =  -1;
                for(int[] m: threes){
                    int distance = Math.abs(l[0] - m[0]) + Math.abs(l[1] - m[1]);
                    if(min == -1 || distance < min){
                        min = distance;
                    }
                }
                if(min > max){
                    max = min;
                }
            }
            out.println(max);
        }
        out.close();
        f.close();
    }
}
