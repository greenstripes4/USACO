import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int c = 1;
        String input;
        while((input = f.readLine()) != null && !(input.equals("0 0"))){
            if(c != 1) {
                System.out.println();
            }
            StringTokenizer st = new StringTokenizer(input);
            int rows = Integer.parseInt(st.nextToken());
            int columns = Integer.parseInt(st.nextToken());
            String[][] minefield = new String[rows][columns];
            String[][] output = new String[rows][columns];
            for(int i = 0; i < rows; i++){
                String[] curr_row = f.readLine().split("");
                for(int j = 0; j < columns; j++){
                    minefield[i][j] = curr_row[j];
                }
            }
            for(int k = 0; k < rows; k++){
                for(int l = 0; l < columns; l++){
                    if(minefield[k][l].equals("*")){
                        output[k][l] = "*";
                    }
                    else{
                        int mine_count = 0;
                        if(k+1 < rows && minefield[k+1][l].equals("*")){
                            mine_count++;
                        }
                        if(k+1 < rows && l+1 < columns && minefield[k+1][l+1].equals("*")){
                            mine_count++;
                        }
                        if(k+1 < rows && l-1 >= 0 && minefield[k+1][l-1].equals("*")){
                            mine_count++;
                        }
                        if(l+1 < columns && minefield[k][l+1].equals("*")){
                            mine_count++;
                        }
                        if(l-1 >= 0 && minefield[k][l-1].equals("*")){
                            mine_count++;
                        }
                        if(k-1 >= 0 && minefield[k-1][l].equals("*")){
                            mine_count++;
                        }
                        if(k-1 >= 0 && l+1 < columns && minefield[k-1][l+1].equals("*")){
                            mine_count++;
                        }
                        if(k-1 >= 0 && l-1 >= 0 && minefield[k-1][l-1].equals("*")){
                            mine_count++;
                        }
                        output[k][l] = Integer.toString(mine_count);
                    }
                }
            }
            System.out.println("Field #" + c + ":");
            for(int m = 0; m < rows; m++){
                for(int n = 0; n < columns; n++){
                    System.out.print(output[m][n]);
                }
                System.out.println();
            }
            c++;
        }
        f.close();
    }
}
