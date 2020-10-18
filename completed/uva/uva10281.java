import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int lastTimeSeconds = 0;
        double distanceTraveled = 0;
        int speed = 0;
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String[] time = st.nextToken().split(":");
            int seconds = Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60+Integer.parseInt(time[2]);
            distanceTraveled += (seconds-lastTimeSeconds)*speed/3600.0;
            if(st.hasMoreTokens()) {
                speed = Integer.parseInt(st.nextToken());
            } else {
                out.println(input + " " + String.format("%.2f",distanceTraveled) + " km");
            }
            lastTimeSeconds = seconds;
        }
        f.close();
        out.close();
    }
}
