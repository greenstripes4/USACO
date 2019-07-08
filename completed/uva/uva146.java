import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("#"))){
            char[] code = input.toCharArray();
            int[] ascii = new int[code.length];
            for(int i = 0; i < code.length; i++){
                ascii[i] = (int) code[i];
            }
            for(int j = ascii.length - 1; j > 0; j--){
                if(ascii[j] > ascii[j-1]){
                    for(int k = ascii.length - 1; k > j-1; k--){
                        if(ascii[k] > ascii[j-1]){
                            int temp = ascii[j-1];
                            ascii[j-1] = ascii[k];
                            ascii[k] = temp;
                            Arrays.sort(ascii,j,ascii.length);
                            break;
                        }
                    }
                    break;
                }
            }
            StringBuilder returnString = new StringBuilder();
            for(int n: ascii){
                returnString.append((char) n);
            }
            if(returnString.toString().equals(input)){
                System.out.println("No Successor");
            } else {
                System.out.println(returnString.toString());
            }
        }
    }
}
