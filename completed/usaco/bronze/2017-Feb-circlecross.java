import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        char[] cowsCrossingPoints = f.readLine().toCharArray();
        int crosses = 0;
        for(int i = 0; i < cowsCrossingPoints.length; i++){
            for(int j = i + 1; j < cowsCrossingPoints.length; j++){
                for(int k = j + 1; k < cowsCrossingPoints.length; k++){
                    for(int l = k + 1; l < cowsCrossingPoints.length; l++){
                        char[] subArray = new char[4];
                        subArray[0] = cowsCrossingPoints[i];
                        subArray[1] = cowsCrossingPoints[j];
                        subArray[2] = cowsCrossingPoints[k];
                        subArray[3] = cowsCrossingPoints[l];
                        if(subArray[0] == subArray[2] && subArray[1] == subArray[3]){
                            crosses++;
                        }
                    }
                }
            }
        }
        out.println(crosses);
        f.close();
        out.close();
    }
}
