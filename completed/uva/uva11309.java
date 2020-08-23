import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPalindrome(int hours, int minutes) {
        char[] time = Integer.toString(hours*100+minutes).toCharArray();
        for(int i = 0; i < time.length/2; i++) {
            if(time[i] != time[time.length-i-1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        for(int t = 0; t < n; t++) {
            String[] time = f.readLine().split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            minutes++;
            if(minutes == 60) {
                hours++;
                minutes = 0;
            }
            if(hours == 24) {
                hours = 0;
            }
            while(!isPalindrome(hours,minutes)) {
                minutes++;
                if(minutes == 60) {
                    hours++;
                    minutes = 0;
                }
                if(hours == 24) {
                    hours = 0;
                }
            }
            String hoursFormatted = String.format("%1$2s",hours).replaceAll(" ","0");
            String minutesFormatted = String.format("%1$2s",minutes).replaceAll(" ","0");
            out.println(hoursFormatted + ":" + minutesFormatted);
        }
        f.close();
        out.close();
    }
}
