/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int N = Integer.parseInt(input);
            int[] books = new int[N];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++){
                books[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(f.readLine());
            Arrays.sort(books);
            int book1 = -1;
            int book2 = -1;
            for(int i = 0; i < N; i++){
                int ind = Arrays.binarySearch(books,M-books[i]);
                if((book1 == -1 || Math.abs((M-books[i])-books[i]) < Math.abs(book1-book2)) && ind != i && ind >= 0){
                    book1 = books[i];
                    book2 = M-books[i];
                }
            }
            out.println("Peter should buy books whose prices are " + Math.min(book1,book2) + " and " + Math.max(book1,book2) + ".\n");
            f.readLine();
        }
        out.close();
        f.close();
    }
}
