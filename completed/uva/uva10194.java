import java.io.*;
import java.util.*;

public class Main{
    private static class Team implements Comparable<Team> {
        private int points;
        private int wins;
        private int ties;
        private int losses;
        private int goalsAgainst;
        private int goalsScored;
        private int gamesPlayed;
        private String teamName;
        private Team(int points, int wins, int ties, int losses, int goalsAgainst, int goalsScored, int gamesPlayed, String teamName) {
            this.points = points;
            this.wins = wins;
            this.losses = losses;
            this.ties = ties;
            this.goalsAgainst = goalsAgainst;
            this.goalsScored = goalsScored;
            this.gamesPlayed = gamesPlayed;
            this.teamName = teamName;
        }
        @Override
        public String toString(){
            return teamName + ' ' + points + "p, " + gamesPlayed + "g (" + wins + '-' + ties + '-' + losses + "), " + (goalsScored-goalsAgainst) + "gd (" + goalsScored + '-' + goalsAgainst + ')';
        }
        @Override
        public int compareTo(Team o){
            if(this.points == o.points) {
                if(this.wins == o.wins) {
                    if((this.goalsScored - this.goalsAgainst) == (o.goalsScored-o.goalsAgainst)) {
                        if(this.goalsScored == o.goalsScored) {
                            if(this.gamesPlayed == o.gamesPlayed) {
                                return (this.teamName.toLowerCase()).compareTo(o.teamName.toLowerCase());
                            }
                            return this.gamesPlayed < o.gamesPlayed ? -1 : 1;
                        }
                        return this.goalsScored > o.goalsScored ? -1 : 1;
                    }
                    return (this.goalsScored - this.goalsAgainst) > (o.goalsScored - o.goalsAgainst) ? -1 : 1;
                }
                return this.wins > o.wins ? -1 : 1;
            }
            return this.points > o.points ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1")));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            if(t > 0) {
                out.println();
            }
            String tournament = f.readLine();
            out.println(tournament);
            int T = Integer.parseInt(f.readLine());
            Team[] teams = new Team[T];
            for(int i = 0; i < T; i++) {
                String teamName = f.readLine();
                teams[i] = new Team(0,0,0,0,0,0,0, teamName);
            }
            int G = Integer.parseInt(f.readLine());
            for(int i = 0; i < G; i++) {
                String game = f.readLine();
                String[] ts = game.split("@");
                String[] t1 = ts[0].split("#");
                String[] t2 = ts[1].split("#");
                String teamName1 = t1[0];
                String teamName2 = t2[1];
                int goals1 = Integer.parseInt(t1[1]);
                int goals2 = Integer.parseInt(t2[0]);
                for(Team j: teams) {
                    if(j.teamName.equals(teamName1)) {
                        j.goalsScored += goals1;
                        j.goalsAgainst += goals2;
                        j.gamesPlayed++;
                        if(goals1 > goals2) {
                            j.wins++;
                            j.points += 3;
                        } else if(goals1 < goals2) {
                            j.losses++;
                        } else {
                            j.ties++;
                            j.points++;
                        }
                    } else if(j.teamName.equals(teamName2)) {
                        j.goalsScored += goals2;
                        j.goalsAgainst += goals1;
                        j.gamesPlayed++;
                        if(goals2 > goals1) {
                            j.wins++;
                            j.points += 3;
                        } else if(goals2 < goals1) {
                            j.losses++;
                        } else {
                            j.ties++;
                            j.points++;
                        }
                    }
                }
            }
            Arrays.sort(teams);
            for(int i = 1; i <= T; i++) {
                out.println(i + ") " + teams[i-1]);
            }
        }
        out.close();
        f.close();
    }
}
