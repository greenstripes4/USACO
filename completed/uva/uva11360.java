import java.io.*;
import java.util.*;

public class Main{
    private static void row(int[][] matrix, int a, int b){
        for(int i = 0; i < matrix.length; i++){
            int temp = matrix[a][i];
            matrix[a][i] = matrix[b][i];
            matrix[b][i] = temp;
        }
    }
    private static void col(int[][] matrix, int a, int b){
        for(int i = 0; i < matrix.length; i++){
            int temp = matrix[i][a];
            matrix[i][a] = matrix[i][b];
            matrix[i][b] = temp;
        }
    }
    private static void inc(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = matrix[i][j]+1 == 10 ? 0 : matrix[i][j]+1;
            }
        }
    }
    private static void dec(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = matrix[i][j]-1 == -1 ? 9 : matrix[i][j]-1;
            }
        }
    }
    private static void transpose(int[][] matrix){
        int[][] transposedMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = transposedMatrix[i].clone();
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(f.readLine());
            int[][] matrix = new int[N][N];
            for(int j = 0; j < N; j++){
                char[] temp = f.readLine().toCharArray();
                for(int k = 0; k < N; k++){
                    matrix[j][k] = Character.getNumericValue(temp[k]);
                }
            }
            int M = Integer.parseInt(f.readLine());
            for(int j = 0; j < M; j++){
                StringTokenizer operation = new StringTokenizer(f.readLine());
                String identifier = operation.nextToken();
                switch(identifier){
                    case "row":
                        row(matrix,Integer.parseInt(operation.nextToken())-1,Integer.parseInt(operation.nextToken())-1);
                        break;
                    case "col":
                        col(matrix,Integer.parseInt(operation.nextToken())-1,Integer.parseInt(operation.nextToken())-1);
                        break;
                    case "inc":
                        inc(matrix);
                        break;
                    case "dec":
                        dec(matrix);
                        break;
                    case "transpose":
                        transpose(matrix);
                        break;
                }
            }
            out.println("Case #" + (i+1));
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    out.print(matrix[j][k]);
                }
                out.println();
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
