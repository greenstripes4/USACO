import java.io.*;
/*
O(1)
12:00
11:55
10:09
*/

public class Main {
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            String[] hm = f.readLine().split(":");
            int hours = Integer.parseInt(hm[0]);
            int minutes = Integer.parseInt(hm[1]);
            int min_diff = 60 - minutes;
            int hr_diff = 12 - hours;
            if(hr_diff == 0){
                hr_diff = 12;
            }
            if(min_diff != 60){
                hr_diff--;
            }
            else{
                min_diff = 0;
            }
            String hr_st;
            String min_st;
            if(hr_diff < 10){
                hr_st = "0" + hr_diff;
            }
            else{
                hr_st = Integer.toString(hr_diff);
            }
            if(min_diff < 10){
                min_st = "0" + min_diff;
            }
            else{
                min_st = Integer.toString(min_diff);
            }
            if(hr_st.equals("00")){
                hr_st = "12";
            }
            System.out.println(hr_st + ":" + min_st);
        }
    }
}
