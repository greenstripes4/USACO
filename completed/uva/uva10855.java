import java.io.*;
import java.util.*;

public class Main{
    private static char[][] rotateNinetyDegrees(char[][] original){
        char[][] transformation = new char[original.length][original.length];
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original.length; j++){
                transformation[j][original.length-i-1] = original[i][j];
            }
        }
        return transformation;
    }
    private static int countOccurences(char[][] largeSquare, char[][] smallSquare){
        int count = 0;
        for(int i = 0; i <= largeSquare.length-smallSquare.length; i++){
            for(int j = 0; j <= largeSquare.length-smallSquare.length; j++){
                boolean valid = true;
                for(int k = 0; k < smallSquare.length; k++){
                    for(int l = 0; l < smallSquare.length; l++){
                        if(largeSquare[k+i][l+j] != smallSquare[k][l]){
                            valid = false;
                            break;
                        }
                    }
                }
                if(valid){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(N == 0 && n == 0){
                break;
            }
            char[][] largeSquare = new char[N][N];
            char[][] smallSquare = new char[n][n];
            for(int i = 0; i < N; i++){
                largeSquare[i] = f.readLine().toCharArray();
            }
            for(int i = 0; i < n; i++){
                smallSquare[i] = f.readLine().toCharArray();
            }
            int[] rotationCounts = new int[4];
            for(int i = 0; i < 4; i++){
                rotationCounts[i] = countOccurences(largeSquare,smallSquare);
                smallSquare = rotateNinetyDegrees(smallSquare);
            }
            out.println(rotationCounts[0] + " " + rotationCounts[1] + " " + rotationCounts[2] + " " + rotationCounts[3]);
        }
        f.close();
        out.close();
    }
}
