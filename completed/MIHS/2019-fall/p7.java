import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("fizzBuzzBloop.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fizzBuzzBloop.out")));
        int start = Integer.parseInt(f.readLine());
        int end = Integer.parseInt(f.readLine());
        int numRules = Integer.parseInt(f.readLine());
        int[] multiples = new int[numRules];
        String[] codes = new String[numRules];
        for(int i = 0; i < numRules; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int multiple = Integer.parseInt(st.nextToken());
            String code = st.nextToken();
            multiples[i] = multiple;
            codes[i] = code;
        }
        for(int i = start; i <= end; i++){
            boolean isMultiple = false;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < numRules; j++){
                if(i%multiples[j] == 0){
                    isMultiple = true;
                    sb.append(codes[j]);
                }
            }
            out.println(isMultiple ? sb : i);
        }
        f.close();
        out.close();
    }
}
