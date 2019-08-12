import java.io.*;
import java.util.*;
/*
O(nm + n log n)
3
World Cup 1998 - Group A
4
Brazil
Norway
Morocco
Scotland
6
Brazil#2@1#Scotland
Norway#2@2#Morocco
Scotland#1@1#Norway
Brazil#3@0#Morocco
Morocco#3@0#Scotland
Brazil#1@2#Norway
Some strange tournament
5
Team A
Team B
Team C
Team D
Team E
5
Team A#1@1#Team B
Team A#2@2#Team C
Team A#0@0#Team D
Team E#2@1#Team C
Team E#1@2#Team D
X
2
bad
Bed
0
Y
5

*/
class Team implements Comparable<Team>{
    public int points;
    public int wins;
    public int ties;
    public int losses;
    public int goals_against;
    public int goals_scored;
    public int games_played;
    public String team_name;
    public Team(int points, int wins, int ties, int losses, int goals_against,
                int goals_scored, int games_played, String team_name){
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.goals_against = goals_against;
        this.goals_scored = goals_scored;
        this.games_played = games_played;
        this.team_name = team_name;
    }
    @Override
    public String toString(){
        return team_name + ' ' + points + "p, " + games_played + "g (" + wins + '-'
                + ties + '-' + losses + "), " + (goals_scored-goals_against)
                + "gd (" + goals_scored + '-' + goals_against + ')';
    }
    @Override
    public int compareTo(Team t){
        if(this.points == t.points){
            if(this.wins == t.wins){
                if((this.goals_scored - this.goals_against) == (t.goals_scored-t.goals_against)){
                    if(this.goals_scored == t.goals_scored) {
                        if (this.games_played == t.games_played) {
                            return (this.team_name.toLowerCase()).compareTo(t.team_name.toLowerCase());
                        } else {
                            return this.games_played < t.games_played ? -1 : 1;
                        }
                    } else {
                        return this.goals_scored > t.goals_scored ? -1:1;
                    }
                } else {
                    return (this.goals_scored - this.goals_against) > (t.goals_scored - t.goals_against) ? -1:1;
                }
            } else {
                return this.wins > t.wins ? -1:1;
            }
        } else {
            return this.points > t.points ? -1:1;
        }
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));;
        int numTestCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTestCases; i++){
            String tournament = f.readLine();
            out.println(tournament);
            int numTeams = Integer.parseInt(f.readLine());
            Team[] teams = new Team[numTeams];
            for(int j = 0; j < numTeams; j++){
                String team_name = f.readLine();
                teams[j] = new Team(0,0,0,0,0,0,0,team_name);
            }
            int numMatches = Integer.parseInt(f.readLine());
            for(int k = 0; k < numMatches; k++){
                String match = f.readLine();
                String[] ts = match.split("@");
                String[] team1stats = ts[0].split("#");
                String[] team2stats = ts[1].split("#");
                String team1 = team1stats[0];
                String team2 = team2stats[1];
                int team1score = Integer.parseInt(team1stats[1]);
                int team2score = Integer.parseInt(team2stats[0]);
                for(Team t: teams){
                    if(t.team_name.equals(team1)){
                        t.goals_scored += team1score;
                        t.goals_against += team2score;
                        t.games_played++;
                        if(team1score > team2score){
                            t.wins++;
                            t.points += 3;
                        } else if(team1score < team2score){
                            t.losses++;
                        } else {
                            t.ties++;
                            t.points++;
                        }
                    } else if(t.team_name.equals(team2)) {
                        t.goals_scored += team2score;
                        t.goals_against += team1score;
                        t.games_played++;
                        if(team2score > team1score){
                            t.wins++;
                            t.points += 3;
                        } else if(team2score < team1score){
                            t.losses++;
                        } else {
                            t.ties++;
                            t.points++;
                        }
                    }
                }
            }
            Arrays.sort(teams);
            for(int t = 1; t <= numTeams; t++){
                out.println(t + ") " + teams[t-1]);
            }
            if( i < numTestCases - 1) {
                out.println();
            }
        }
        out.close();
        f.close();
        /*
        Team[] a = new Team[2];
        a[0] = new Team(0,0,0,0,0,0,0,"a");
        a[1] = new Team(0,0,0,0,0,0,0,"b");
        Arrays.sort(a);
        for(Team x: a){
            System.out.println(x);
        }
        */
    }
}
