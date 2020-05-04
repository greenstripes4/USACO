import java.io.*;
import java.util.*;

public class Main{
    private static void printKnuthPermutations(String letters, int ind, String permutation, PrintWriter out){
        if(ind == letters.length()){
            out.println(permutation);
            return;
        }
        for(int i = 0; i <= permutation.length(); i++){
            printKnuthPermutations(letters,ind+1,permutation.substring(0,i)+letters.charAt(ind)+permutation.substring(i),out);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 0;
        while((input = f.readLine()) != null){
            if(testCase > 0){
                out.println();
            }
            printKnuthPermutations(input,0,"",out);
            testCase++;
        }
        f.close();
        out.close();
    }
}
