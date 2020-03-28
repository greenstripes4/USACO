/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class Player implements Comparable<Player>{
    String name;
    int[] rounds = new int[4];
    boolean isAmateur;
    int dqRound;
    public Player(String n, int r1, int r2, int r3, int r4){
        name = n;
        isAmateur = name.charAt(name.length()-1) == '*';
        if(r1 == -1){
            dqRound = 0;
        } else if(r2 == -1){
            dqRound = 1;
        } else if(r3 == -1){
            dqRound = 2;
        } else if(r4 == -1){
            dqRound = 3;
        } else {
            dqRound = 4;
        }
        rounds[0] = r1;
        rounds[1] = r2;
        rounds[2] = r3;
        rounds[3] = r4;
    }
    @Override
    public int compareTo(Player p){
        int t1 = 0;
        int t2 = 0;
        for(int i = 0; i < 4; i++){
            if(rounds[i] < 0 && p.rounds[i] < 0){
                return name.compareTo(p.name);
            } else if(rounds[i] < 0){
                return 1;
            } else if(p.rounds[i] < 0) {
                return -1;
            } else {
                t1 += rounds[i];
                t2 += p.rounds[i];
            }
        }
        return t1-t2 == 0 ? name.compareTo(p.name):t1-t2;
    }
    public int getTotal(){
        return rounds[0]+rounds[1]+rounds[2]+rounds[3];
    }
}
public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++) {
            f.readLine();
            double purse = Double.parseDouble(f.readLine());
            double[] percentages = new double[70];
            for (int j = 0; j < 70; j++) {
                percentages[j] = Double.parseDouble(f.readLine());
            }
            int players = Integer.parseInt(f.readLine());
            Player[] stats = new Player[players];
            for(int j = 0; j < players; j++){
                String line = String.format("%1$-" + 32 + "s", f.readLine());
                String name = line.substring(0,20).trim();
                String round1 = line.substring(20,23).trim();
                String round2 = line.substring(23,26).trim();
                String round3 = line.substring(26,29).trim();
                String round4 = line.substring(29,32).trim();
                int r1 = -1;
                int r2 = -1;
                int r3 = -1;
                int r4 = -1;
                if(!round1.equals("DQ") && !round1.equals("")){
                    r1 = Integer.parseInt(round1);
                }
                if(!round2.equals("DQ") && !round2.equals("")){
                    r2 = Integer.parseInt(round2);
                }
                if(!round3.equals("DQ") && !round3.equals("")){
                    r3 = Integer.parseInt(round3);
                }
                if(!round4.equals("DQ") && !round4.equals("")){
                    r4 = Integer.parseInt(round4);
                }
                Player player = new Player(name,r1,r2,r3,r4);
                stats[j] = player;
            }
            Arrays.sort(stats, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    int t1 = 0;
                    int t2 = 0;
                    for(int i = 0; i < 2; i++){
                        if(o1.rounds[i] < 0 && o2.rounds[i] < 0){
                            return o1.name.compareTo(o2.name);
                        } else if(o1.rounds[i] < 0){
                            return 1;
                        } else if(o2.rounds[i] < 0) {
                            return -1;
                        } else {
                            t1 += o1.rounds[i];
                            t2 += o2.rounds[i];
                        }
                    }
                    return t1-t2 == 0 ? o1.name.compareTo(o2.name):t1-t2;
                }
            });
            ArrayList<Player> finalists = new ArrayList<>();
            int ind = 0;
            boolean keepGoing = true;
            while(finalists.size() < 70 && ind < stats.length && keepGoing){
                keepGoing = false;
                int tiedWith = stats[ind].rounds[0] + stats[ind].rounds[1];
                while(ind < stats.length && stats[ind].rounds[0] + stats[ind].rounds[1] == tiedWith && stats[ind].rounds[0] >= 0 && stats[ind].rounds[1] >= 0){
                    keepGoing = true;
                    finalists.add(stats[ind]);
                    ind++;
                }
            }
            Collections.sort(finalists);
            ArrayList<ArrayList<Player>> ties = new ArrayList<>();
            ArrayList<Player> first = new ArrayList<>();
            first.add(finalists.get(0));
            ties.add(first);
            for(int j = 1; j < finalists.size(); j++){
                if(finalists.get(j).getTotal() == finalists.get(j-1).getTotal()){
                    ties.get(ties.size()-1).add(finalists.get(j));
                } else {
                    ArrayList<Player> place = new ArrayList<>();
                    place.add(finalists.get(j));
                    ties.add(place);
                }
            }
            out.println("Player Name          Place     RD1  RD2  RD3  RD4  TOTAL     Money Won");
            out.println("-----------------------------------------------------------------------");
            int placing = 0;
            int skips = 1;
            for(int j = 0; j < ties.size(); j++){
                ArrayList<Player> next = ties.get(j);
                int nonAmateurs = 0;
                for(Player k: next){
                    if(!k.isAmateur) {
                        nonAmateurs++;
                    }
                }
                boolean tie = nonAmateurs >= 2;
                for(Player p: next){
                    out.printf("%1$-" + 21 + "s", p.name);
                    if(p.dqRound == 4) {
                        String place = Integer.toString(skips);
                        if (tie && !p.isAmateur && placing < 70) {
                            place += "T";
                        }
                        out.printf("%1$-" + 10 + "s", place);
                    } else {
                        out.print("          ");
                    }
                    for(int k = 0; k < p.dqRound; k++){
                        String round = Integer.toString(p.rounds[k]);
                        out.printf("%1$-" + 5 + "s", round);
                    }
                    for(int k = p.dqRound; k < 4; k++){
                        out.print("     ");
                    }
                    if(p.dqRound < 4){
                        out.print("DQ                  ");
                    } else {
                        String total = Integer.toString(p.getTotal());
                        out.printf("%1$-" + 10 + "s", total);
                        double money = 0;
                        for (int k = placing; k < Math.min(placing + nonAmateurs,70); k++) {
                            money += percentages[k];
                        }
                        money /= 100;
                        money /= nonAmateurs;
                        if (!p.isAmateur && placing < 70) {
                            out.print("$");
                            String toString = String.format("%.2f", money * purse);
                            out.printf("%" + 10 + "s", toString);
                        }
                    }
                    out.println();
                }
                placing += nonAmateurs;
                skips += next.size();
            }
            if(i != testCases-1){
                out.println();
            }
        }
        out.close();
        f.close();
    }
}
