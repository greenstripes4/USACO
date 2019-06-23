import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()).charAt(0) != '0'){
            StringTokenizer st = new StringTokenizer(input);
            double height = Integer.parseInt(st.nextToken());
            double up_speed = Integer.parseInt(st.nextToken());
            double down_speed = Integer.parseInt(st.nextToken());
            double fatigue_factor = Integer.parseInt(st.nextToken());
            double current_hight = 0;
            int day = 1;
            double slow_rate = fatigue_factor/100*up_speed;
            while(current_hight < height && (current_hight > 0 || day == 1)){
                // System.out.println(day + " " + current_hight + " " + (current_hight+up_speed) + " " + (current_hight+up_speed-down_speed));
                current_hight += up_speed;
                if(current_hight > height){
                    break;
                }
                up_speed = Math.max(0,up_speed-slow_rate);
                current_hight = current_hight - down_speed;
                if(current_hight < 0){
                    break;
                }
                day++;
            }
            if(current_hight <= 0){
                System.out.println("failure on day " + day);
            }
            else{
                System.out.println("success on day " + day);
            }
        }
        f.close();
    }
}
