/*
ID: strongh2
LANG: JAVA
PROG: friday
TASK: friday
 */

import java.io.*;
import java.util.*;

public class friday {
    public static boolean isLeapYear(int year){
        return (year%100 != 0 && year%4 == 0) || year%400 == 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int N = Integer.parseInt(f.readLine());
        f.close();
        int[] daysOfEachMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysOfTheWeek = new int[7];
        int currentDay = 0;
        for(int i = 0; i < N; i++){
            if(isLeapYear((1900 + i))){
                daysOfEachMonth[1] = 29;
            } else {
                daysOfEachMonth[1] = 28;
            }
            for(int j = 0; j < 12; j++){
                for(int k = 0; k  < daysOfEachMonth[j]; k++){
                    if(k == 12){
                        daysOfTheWeek[(currentDay+2)%7]++;
                    }
                    currentDay++;
                }
            }
        }
        boolean start = true;
        for(int l: daysOfTheWeek) {
            if (!start) {
                out.print(" " + l);
            } else {
                start = false;
                out.print(l);
            }
        }
        out.println();
        out.close();
    }
}
