import java.io.*;
import java.util.*;

class Team{
    int id;
    int members;
    TreeSet<Integer> tables;
    Team(int id, int members) {
        this.id = id;
        this.members = members;
        this.tables = new TreeSet<>();
    }
}

class Table implements Comparable<Table>{
    int id;
    int capacity;
    Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    @Override
    public int compareTo(Table o) {
        return o.capacity-this.capacity;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) {
                break;
            }
            Team[] teams = new Team[M];
            StringTokenizer m = new StringTokenizer(f.readLine());
            boolean valid = true;
            for(int i = 0; i < M; i++) {
                teams[i] = new Team(i,Integer.parseInt(m.nextToken()));
                if(teams[i].members > N) {
                    valid = false;
                }
            }
            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team team, Team t1) {
                    return t1.members-team.members;
                }
            });
            PriorityQueue<Table> tables = new PriorityQueue<>();
            StringTokenizer n = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++) {
                tables.add(new Table(j,Integer.parseInt(n.nextToken())));
            }
            if(!valid) {
                out.println(0);
                continue;
            }
            for(Team i: teams) {
                for(int j = 0; j < i.members; j++) {
                    for(Table k: tables) {
                        if (k.capacity == 0) {
                            continue;
                        }
                        if(!i.tables.contains(k.id)) {
                            tables.remove(k);
                            i.tables.add(k.id);
                            k.capacity--;
                            tables.add(k);
                            break;
                        }
                    }
                }
            }
            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team team, Team t1) {
                    return team.id-t1.id;
                }
            });
            for(Team i: teams) {
                if(i.tables.size() < i.members) {
                    valid = false;
                    break;
                }
            }
            if(!valid) {
                out.println(0);
                continue;
            }
            out.println(1);
            for(Team i: teams) {
                StringBuilder seatedTables = new StringBuilder();
                for(int j: i.tables) {
                    seatedTables.append(j+1).append(" ");
                }
                out.println(seatedTables.substring(0,seatedTables.length()-1));
            }
        }
        f.close();
        out.close();
    }
}
