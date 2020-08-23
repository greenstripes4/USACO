import java.io.*;
import java.util.*;

class Player implements Comparable<Player>{
    String name;
    int attack;
    int defend;
    Player(String name, int attack, int defend) {
        this.name = name;
        this.attack = attack;
        this.defend = defend;
    }
    @Override
    public int compareTo(Player o) {
        return name.compareTo(o.name);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            Player[] players = new Player[10];
            int totalDefend = 0;
            for(int i = 0; i < 10; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                String name = st.nextToken();
                int attack = Integer.parseInt(st.nextToken());
                int defend = Integer.parseInt(st.nextToken());
                players[i] = new Player(name,attack,defend);
                totalDefend += defend;
            }
            Arrays.sort(players);
            int[] chosenAttackers = new int[5];
            int maxAttack = 0;
            int maxDefend = 0;
            for(int i = 0; i < 10; i++) {
                for(int j = i+1; j < 10; j++) {
                    for(int k = j+1; k < 10; k++) {
                        for(int l = k+1; l < 10; l++) {
                            for(int m = l+1; m < 10; m++) {
                                int currentAttack = players[i].attack+players[j].attack+players[k].attack+players[l].attack+players[m].attack;
                                int currentDefend = totalDefend-players[i].defend-players[j].defend-players[k].defend-players[l].defend-players[m].defend;
                                if(currentAttack > maxAttack || (currentAttack == maxAttack && currentDefend > maxDefend)) {
                                    chosenAttackers[0] = i;
                                    chosenAttackers[1] = j;
                                    chosenAttackers[2] = k;
                                    chosenAttackers[3] = l;
                                    chosenAttackers[4] = m;
                                    maxAttack = currentAttack;
                                    maxDefend = currentDefend;
                                }
                            }
                        }
                    }
                }
            }
            int[] chosenDefenders = new int[5];
            int index = 0;
            for(int i = 0; i < 10; i++) {
                boolean isDefending = true;
                for(int j: chosenAttackers) {
                    if(i == j) {
                        isDefending = false;
                        break;
                    }
                }
                if(isDefending) {
                    chosenDefenders[index] = i;
                    index++;
                }
            }
            out.println("Case " + t + ":");
            out.println("(" + players[chosenAttackers[0]].name + ", " + players[chosenAttackers[1]].name + ", " + players[chosenAttackers[2]].name + ", " + players[chosenAttackers[3]].name + ", " + players[chosenAttackers[4]].name + ")");
            out.println("(" + players[chosenDefenders[0]].name + ", " + players[chosenDefenders[1]].name + ", " + players[chosenDefenders[2]].name + ", " + players[chosenDefenders[3]].name + ", " + players[chosenDefenders[4]].name + ")");
        }
        f.close();
        out.close();
    }
}
