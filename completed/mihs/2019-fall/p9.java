import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("codedMessage.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("codedMessage.out")));
        HashMap<Integer,Character> map = new HashMap<>();
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','.',' '};
        for(int i = 0; i < 28; i++){
            map.put(Integer.parseInt(f.readLine()),letters[i]);
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(f.readLine());
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            sb.append(map.get(next));
        }
        out.println(sb);
        f.close();
        out.close();
    }
}
