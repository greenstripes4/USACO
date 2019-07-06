import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int numLines = Integer.parseInt(input);
            int[] spaceArr = new int[numLines];
            int minSpaces = 26;
            for(int i = 0; i < numLines; i++){
                char[] line = f.readLine().toCharArray();
                int spaceCount = 0;
                for(char j: line){
                    if(j == ' '){
                        spaceCount++;
                    }
                }
                if(spaceCount < minSpaces){
                    minSpaces = spaceCount;
                }
                spaceArr[i] = spaceCount;
            }
            int numUnfilled = 0;
            for(int k: spaceArr){
                numUnfilled += k-minSpaces;
            }
            System.out.println(numUnfilled);
        }
        f.close();
    }
}
