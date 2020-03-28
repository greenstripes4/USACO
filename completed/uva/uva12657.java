/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //long start = System.nanoTime();
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 1;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] left = new int[n+1];
            int[] right = new int[n+1];
            left[0] = -1;
            right[0] = -1;
            for(int i = 1; i <= n; i++){
                left[i] = i-1;
                right[i] = i+1 <= n ? i+1:0;
            }
            for(int i = 0; i < m; i++){
                StringTokenizer command = new StringTokenizer(f.readLine());
                int commandId = Integer.parseInt(command.nextToken());
                if(commandId == 1){
                    int X = Integer.parseInt(command.nextToken());
                    int Y = Integer.parseInt(command.nextToken());
                    int rightX = right[X];
                    int leftX = left[X];
                    int leftY = left[Y];
                    if(rightX == Y){
                        continue;
                    }
                    if(rightX > 0 && rightX <= n) {
                        left[rightX] = leftX;
                    }
                    if(leftX > 0 && leftX <= n) {
                        right[leftX] = rightX;
                    }
                    if(leftY > 0 && leftY <= n) {
                        right[leftY] = X;
                    }
                    left[X] = leftY;
                    right[X] = Y;
                    left[Y] = X;
                } else if(commandId == 2) {
                    int X = Integer.parseInt(command.nextToken());
                    int Y = Integer.parseInt(command.nextToken());
                    int rightX = right[X];
                    int rightY = right[Y];
                    int leftX = left[X];
                    if(leftX == Y){
                        continue;
                    }
                    if(rightX > 0 && rightX <= n) {
                        left[rightX] = leftX;
                    }
                    if(leftX > 0 && leftX <= n) {
                        right[leftX] = rightX;
                    }
                    if(rightY > 0 && rightY <= n) {
                        left[rightY] = X;
                    }
                    left[X] = Y;
                    right[X] = rightY;
                    right[Y] = X;
                } else if(commandId == 3){
                    int X = Integer.parseInt(command.nextToken());
                    int Y = Integer.parseInt(command.nextToken());
                    int rightX = right[X];
                    int rightY = right[Y];
                    int leftX = left[X];
                    int leftY = left[Y];
                    if(rightX == Y && leftY == X){
                        if(leftX > 0 && leftX <= n) {
                            right[leftX] = Y;
                        }
                        if(rightY > 0 && rightY <= n) {
                            left[rightY] = X;
                        }
                        left[X] = Y;
                        right[X] = rightY;
                        left[Y] = leftX;
                        right[Y] = X;
                    } else if(rightY == X && leftX == Y){
                        if(rightX > 0 && rightX <= n) {
                            left[rightX] = Y;
                        }
                        if(leftY > 0 && leftY <= n) {
                            right[leftY] = X;
                        }
                        right[X] = Y;
                        left[X] = leftY;
                        right[Y] = rightX;
                        left[Y] = X;
                    } else {
                        if (rightX > 0 && rightX <= n) {
                            left[rightX] = Y;
                        }
                        if (leftX > 0 && leftX <= n) {
                            right[leftX] = Y;
                        }
                        if (rightY > 0 && rightY <= n) {
                            left[rightY] = X;
                        }
                        if (leftY > 0 && leftY <= n) {
                            right[leftY] = X;
                        }
                        left[X] = leftY;
                        left[Y] = leftX;
                        right[X] = rightY;
                        right[Y] = rightX;
                    }
                } else {
                    int[] temp = right;
                    right = left;
                    left = temp;
                }
            }
            long total = 0;
            int ind = -1;
            for(int i = 1; i <= n; i++){
                if(left[i] == 0){
                    ind = i;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(i%2 == 0){
                    total += ind;
                }
                ind = right[ind];
            }
            out.println("Case " + testCase + ": " + total);
            testCase++;
        }
        f.close();
        out.close();
    }
}
