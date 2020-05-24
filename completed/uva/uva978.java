import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        for(int i = 0; i < N; i++){
            if(i > 0){
                out.println();
            }
            int B = f.nextInt();
            int SG = f.nextInt();
            int SB = f.nextInt();
            PriorityQueue<Integer> greenArmy = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1-integer;
                }
            });
            PriorityQueue<Integer> blueArmy = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1-integer;
                }
            });
            for(int j = 0; j < SG; j++){
                greenArmy.offer(f.nextInt());
            }
            for(int j = 0; j < SB; j++){
                blueArmy.offer(f.nextInt());
            }
            while(!greenArmy.isEmpty() && !blueArmy.isEmpty()){
                LinkedList<Integer> greenSurvivors = new LinkedList<>();
                LinkedList<Integer> blueSurvivors = new LinkedList<>();
                int battles = Math.min(B,Math.min(greenArmy.size(),blueArmy.size()));
                for(int j = 0; j < battles; j++){
                    int greenSoldier = greenArmy.poll();
                    int blueSoldier = blueArmy.poll();
                    if(greenSoldier > blueSoldier){
                        greenSurvivors.offer(greenSoldier-blueSoldier);
                    } else if(blueSoldier > greenSoldier) {
                        blueSurvivors.offer(blueSoldier-greenSoldier);
                    }
                }
                for(int j: greenSurvivors){
                    greenArmy.offer(j);
                }
                for(int j: blueSurvivors){
                    blueArmy.offer(j);
                }
            }
            if(greenArmy.isEmpty() && blueArmy.isEmpty()){
                out.println("green and blue died");
            } else if(blueArmy.isEmpty()) {
                out.println("green wins");
                while(!greenArmy.isEmpty()){
                    out.println(greenArmy.poll());
                }
            } else {
                out.println("blue wins");
                while(!blueArmy.isEmpty()){
                    out.println(blueArmy.poll());
                }
            }
        }
        f.close();
        out.close();
    }
}
