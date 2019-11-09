import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int people = Integer.parseInt(st.nextToken());
            int[] frosh = new int[people];
            int sum = 0;
            for(int j = 0; j < people; j++){
                frosh[j] = Integer.parseInt(st.nextToken());
                sum += frosh[j];
            }
            int average = sum/people;
            int count = 0;
            for(int k: frosh){
                if(k > average){
                    count++;
                }
            }
            double aboveAverage = (double) count / (double) people * 100;
            String temp = Double.toString(roundAvoid(aboveAverage,3));
            String[] arr = temp.split("\\.");
            String afterDecimalPlace = arr[1];
            int padding = 4 - afterDecimalPlace.length();
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            for(int l = 0; l < padding-1; l++){
                sb.append("0");
            }
            out.println(sb + "%");
        }
        f.close();
        out.close();
    }
}
