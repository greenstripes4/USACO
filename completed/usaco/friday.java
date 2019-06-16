/*
ID: strongh2
LANG: JAVA
PROG: friday
TASK: friday
 */

import java.io.*;

public class friday {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        //
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        //PrintWriter out = new PrintWriter(System.out);
        int number_of_years = Integer.parseInt(f.readLine());
        f.close();
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] weekdays = new int[7];
        int currentday = 0;
        for(int i = 0; i < number_of_years; i++){
            for(int j = 0; j < 12; j++){
                if((((1900+i)%100 != 0) && ((1900+i)%4 == 0)) || ((1900+i)%400 == 0)){
                    days[1] = 29;
                } else {
                    days[1] = 28;
                }
                for(int k = 0; k < days[j]; k++){
                    if(k == 12){
                        weekdays[(currentday+2)%7]++;
                    }
                    currentday++;
                }
            }
        }
        String rep = "";
        for(int m: weekdays){
            rep += (m+" ");
        }
        out.println(rep.substring(0,rep.length()-1));
        out.close();
    }
}
