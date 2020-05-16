import java.io.*;
import java.util.*;

public class Main{
    private static boolean isRotatedNinetyDegrees(char[][] original, char[][] transformation){
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original.length; j++){
                if(original[i][j] != transformation[j][original.length-i-1]){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isRotatedOneHundredEightyDegrees(char[][] original, char[][] transformation){
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original.length; j++){
                if(original[i][j] != transformation[original.length-i-1][original.length-j-1]){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isRotatedTwoHundredSeventyDegrees(char[][] original, char[][] transformation) {
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original.length; j++){
                if(original[i][j] != transformation[original.length-j-1][i]){
                    return false;
                }
            }
        }
        return true;
    }
    private static char[][] reflectVertically(char[][] original){
        char[][] transformed = new char[original.length][original.length];
        for(int i = 0; i < original.length; i++){
            for(int j = 0; j < original.length; j++){
                transformed[original.length-i-1][j] = original[i][j];
            }
        }
        return transformed;
    }
    private static boolean isPreserved(char[][] original, char[][] transformed){
        for(int i = 0; i < original.length; i++){
            if(!Arrays.equals(original[i],transformed[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 1;
        while((input = f.readLine()) != null){
            int N = Integer.parseInt(input);
            char[][] original = new char[N][N];
            char[][] transformed = new char[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                original[i] = st.nextToken().toCharArray();
                transformed[i] = st.nextToken().toCharArray();
            }
            if(isPreserved(original,transformed)){
                out.println("Pattern " + testCase +" was preserved.");
            } else if(isRotatedNinetyDegrees(original,transformed)) {
                out.println("Pattern " + testCase +" was rotated 90 degrees.");
            } else if(isRotatedOneHundredEightyDegrees(original,transformed)) {
                out.println("Pattern " + testCase +" was rotated 180 degrees.");
            } else if(isRotatedTwoHundredSeventyDegrees(original,transformed)) {
                out.println("Pattern " + testCase +" was rotated 270 degrees.");
            } else {
                char[][] reflected = reflectVertically(original);
                if(isPreserved(reflected,transformed)){
                    out.println("Pattern " + testCase +" was reflected vertically.");
                } else if(isRotatedNinetyDegrees(reflected,transformed)){
                    out.println("Pattern " + testCase +" was reflected vertically and rotated 90 degrees.");
                } else if(isRotatedOneHundredEightyDegrees(reflected,transformed)) {
                    out.println("Pattern " + testCase +" was reflected vertically and rotated 180 degrees.");
                } else if(isRotatedTwoHundredSeventyDegrees(reflected,transformed)) {
                    out.println("Pattern " + testCase + " was reflected vertically and rotated 270 degrees.");
                } else {
                    out.println("Pattern " + testCase + " was improperly transformed.");
                }
            }
            testCase++;
        }
        f.close();
        out.close();
    }
}
