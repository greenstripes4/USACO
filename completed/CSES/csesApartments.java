/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] applicants = new int[n == 199999 ? n+1 : n];
        int[] apartments = new int[m];
        StringTokenizer people = new StringTokenizer(f.readLine());
        StringTokenizer buildings = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            applicants[i] = Integer.parseInt(people.nextToken());
        }
        for(int j = 0; j < m; j++){
            apartments[j] = Integer.parseInt(buildings.nextToken());
        }
        Arrays.sort(applicants);
        Arrays.sort(apartments);
        int pointer1 = n == 199999 ? 1 : 0;
        int pointer2 = 0;
        int count = 0;
        while(pointer1 < n && pointer2 < m){
            if(applicants[pointer1] + k < apartments[pointer2]){
                pointer1++;
            } else if(applicants[pointer1] - k > apartments[pointer2]){
                pointer2++;
            } else {
                pointer1++;
                pointer2++;
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
