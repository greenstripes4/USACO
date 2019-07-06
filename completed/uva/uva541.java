import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int side = Integer.parseInt(input);
            int[][] matrix = new int[side][side];
            for(int i = 0; i < side; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < side; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] rowSums = new int[matrix.length];
            int[] columnSums = new int[matrix.length];
            for(int i = 0; i < matrix.length; i++){
                int count = 0;
                int count2 = 0;
                for(int j = 0; j < matrix.length; j++){
                    count += matrix[i][j];
                    count2 += matrix[j][i];
                }
                rowSums[i] = count;
                columnSums[i] = count2;
            }
            int count = 0;
            int count2 = 0;
            int rowNum = -1;
            int colNum = -1;
            for(int k = 0; k < matrix.length; k++){
                if(rowSums[k] % 2 != 0){
                    count++;
                    rowNum = k;
                }
            }
            for(int l = 0; l < matrix.length; l++){
                if(columnSums[l] % 2 != 0){
                    count2++;
                    colNum = l;
                }
            }
            if(count == 0 && count2 == 0){
                System.out.println("OK");
            } else if(count > 1 || count2 > 1){
                System.out.println("Corrupt");
            } else {
                System.out.println("Change bit " + "(" + (rowNum+1) + "," + (colNum + 1) + ")");
            }
        }
    }
}
