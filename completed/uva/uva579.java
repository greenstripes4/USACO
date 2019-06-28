import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0:00"))){
            String[] hm = input.split(":");
            int h = Integer.parseInt(hm[0]);
            char[] min = hm[1].toCharArray();
            int m = 0;
            if(min[0] == '0'){
                m = Integer.parseInt(Character.toString(min[1]));
            }
            else{
                m = Integer.parseInt(hm[1]);
            }
            double hour_angle = 0.5 * (h*60 + m);
            int minute_angle = 6*m;
            double angle = Math.abs(hour_angle - minute_angle);
            angle = Math.min(360-angle, angle);
            System.out.printf("%.3f", angle);
            System.out.println();
        }
        f.close();
    }
}
