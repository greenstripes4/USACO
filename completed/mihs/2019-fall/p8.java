import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("noteSorting.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("noteSorting.out")));
        int N = Integer.parseInt(f.readLine());
        int[] frequencies = new int[N];
        HashMap<String,Integer> map = new HashMap<>();
        map.put("C",1);
        map.put("C#",2);
        map.put("D",3);
        map.put("D#",4);
        map.put("E",5);
        map.put("F",6);
        map.put("F#",7);
        map.put("G",8);
        map.put("G#",9);
        map.put("A",10);
        map.put("A#",11);
        map.put("B",12);
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int octave = Integer.parseInt(st.nextToken());
            String note = st.nextToken();
            frequencies[i] = (int) Math.round(440*Math.pow(1.05946,(octave-5)*12+map.get(note)+2));
        }
        Arrays.sort(frequencies);
        for(int i: frequencies){
            out.println(i);
        }
        f.close();
        out.close();
    }
}
