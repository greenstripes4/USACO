import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("photo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        int numCows = Integer.parseInt(f.readLine());
        Integer[][] cows = new Integer[5][numCows];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < numCows; j++){
                cows[i][j] = Integer.parseInt(f.readLine());
            }
        }
        Integer[] original = cows[0].clone();
        Arrays.sort(original, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count = 0;
                for(Integer[] i: cows){
                    int ind1 = -1, ind2 = -1;
                    for(int j = 0; j < i.length; j++){
                        //https://stackoverflow.com/questions/10002037/comparing-integer-values-in-java-strange-behavior
                        //https://stackoverflow.com/questions/1514910/how-to-properly-compare-two-integers-in-java
                        if(i[j].intValue() == o1.intValue()){
                            ind1 = j;
                        }
                        if(i[j].intValue() == o2.intValue()){
                            ind2 = j;
                        }
                    }
                    if(ind2 < ind1){
                        count++;
                    }
                }
                return count >= 3 ? 1:-1;
            }
        });
        for(int i: original){
            out.println(i);
        }
        out.close();
        f.close();
    }
}
