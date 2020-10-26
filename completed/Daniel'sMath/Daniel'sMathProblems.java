import java.io.*;
import java.util.*;

public class Main {
    private static int carriesAddition(int random1, int random2) {
        ArrayList<Integer> rand1 = new ArrayList<>();
        ArrayList<Integer> rand2 = new ArrayList<>();
        while(random1 > 0) {
            rand1.add(random1%10);
            random1 /= 10;
        }
        while(random2 > 0) {
            rand2.add(random2%10);
            random2 /= 10;
        }
        int carry = 0;
        int totalOverflow = 0;
        for(int i = 0; i < Math.max(rand1.size(),rand2.size()); i++) {
            int firstDigit = i < rand1.size() ? rand1.get(i) : 0;
            int secondDigit = i < rand2.size() ? rand2.get(i) : 0;
            if(firstDigit+secondDigit+carry > 9) {
                carry = 1;
                totalOverflow++;
            } else {
                carry = 0;
            }
        }
        return totalOverflow;
    }
    private static int carriesSubtraction(int random1, int random2) {
        ArrayList<Integer> rand1 = new ArrayList<>();
        ArrayList<Integer> rand2 = new ArrayList<>();
        while(random1 > 0) {
            rand1.add(random1%10);
            random1 /= 10;
        }
        while(random2 > 0) {
            rand2.add(random2%10);
            random2 /= 10;
        }
        int carry = 0;
        int totalOverflow = 0;
        for(int i = 0; i < rand1.size(); i++) {
            int firstDigit = rand1.get(i);
            int secondDigit = i < rand2.size() ? rand2.get(i) : 0;
            if(firstDigit-secondDigit+carry < 0) {
                carry = -1;
                totalOverflow++;
            } else {
                carry = 0;
            }
        }
        return totalOverflow;
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("Daniel'sMathProblems_Addition.txt")));
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("Daniel'sMathProblems_Subtraction.txt")));
        for(int i = 0; i < 4; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*9000+1000);
            if(carriesAddition(random1,random2) < 2 || random1+random2 >= 10000) {
                i--;
                continue;
            }
            out1.println(random1 + " + " + random2 + " = " + (random1+random2));
        }
        for(int i = 0; i < 6; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*9000+1000);
            if(random2 > random1) {
                int temp = random1;
                random1 = random2;
                random2 = temp;
            }
            if(carriesSubtraction(random1,random2) < 2) {
                i--;
                continue;
            }
            out2.println(random1 + " - " + random2 + " = " + (random1-random2));
        }
        for(int i = 0; i < 2; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*900+100);
            if(carriesAddition(random1,random2) < 1 || random1+random2 >= 10000) {
                i--;
                continue;
            }
            out1.println(random1 + " + " + random2 + " = " + (random1+random2));
        }
        for(int i = 0; i < 4; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*900+100);
            if(carriesSubtraction(random1,random2) < 2) {
                i--;
                continue;
            }
            out2.println(random1 + " - " + random2 + " = " + (random1-random2));
        }
        for(int i = 0; i < 2; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*90+10);
            if(carriesAddition(random1,random2) < 1 || random1+random2 >= 10000) {
                i--;
                continue;
            }
            out1.println(random1 + " + " + random2 + " = " + (random1+random2));
        }
        for(int i = 0; i < 4; i++) {
            int random1 = (int)(Math.random()*9000+1000);
            int random2 = (int)(Math.random()*90+10);
            if(carriesSubtraction(random1,random2) < 1) {
                i--;
                continue;
            }
            out2.println(random1 + " - " + random2 + " = " + (random1-random2));
        }
        for(int i = 0; i < 2; i++) {
            int random1 = (int)(Math.random()*900+100);
            int random2 = (int)(Math.random()*900+100);
            if(carriesAddition(random1,random2) < 1) {
                i--;
                continue;
            }
            out1.println(random1 + " + " + random2 + " = " + (random1+random2));
        }
        for(int i = 0; i < 2; i++) {
            int random1 = (int)(Math.random()*900+100);
            int random2 = (int)(Math.random()*900+100);
            if(random2 > random1) {
                int temp = random1;
                random1 = random2;
                random2 = temp;
            }
            if(carriesSubtraction(random1,random2) < 1) {
                i--;
                continue;
            }
            out2.println(random1 + " - " + random2 + " = " + (random1-random2));
        }
        out1.close();
        out2.close();
    }
}
