package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.InvalidStateException;
import lombok.Getter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class LeagueTable {

    private static final int POINTS_WIN = 3;
    private static final int POINTS_TIE = 1;
    private static final int POINTS_LOSS = 0;

    private HashMap<String, LeagueStanding> standings = new HashMap<>();
    private List<LeagueStanding> sortedLeagueStandings;

    public static LeagueTable createInstance(List<SportMatch> matches) {
        var output = new LeagueTable();
        output.processStandings(matches);
        return output;
    }

    private void processStandings(List<SportMatch> matches){
        matches.forEach(item -> {
            if(item.getResult().getOutcome() == ResultOutcome.TIE){
                addPoints(item.getTeamAScore(), POINTS_TIE);
                addPoints(item.getTeamBScore(), POINTS_TIE);
            } else {
                try {
                    addPoints(item.getWinner(), POINTS_WIN);
                    addPoints(item.getLoser(), POINTS_LOSS);
                } catch (InvalidStateException e) {
                    e.printStackTrace();
                }
            }
        });

       this.sortLeagueStandings();
    }

   private void sortLeagueStandings(){
       var list = new ArrayList<>(standings.values());

        Comparator<LeagueStanding> filter = Comparator
                .comparing(LeagueStanding::getPoints, (s1, s2) -> s2 - s1)
                .thenComparing(LeagueStanding::getTeam);

       sortedLeagueStandings = list
                .stream()
                .sorted(filter)
                .collect(Collectors.toList());
    }

    private void addPoints(TeamScore teamScore, int points) {
        var key = teamScore.getTeam().getName();

        if (this.standings.containsKey(key)){
            this.standings.get(key).addPoints(points);
        } else {
            var standing = LeagueStanding.createInstance(teamScore.getTeam(), points);
            standings.put(key, standing);
        }
    }


    public void printLeagueStandings(OutputStream out) throws IOException {
        for(int i = 0; i < this.sortedLeagueStandings.size(); i++){
            try {
                var position = i + 1;
                var item = this.sortedLeagueStandings.get(i);

                var outputString = String.format(
                        "%s. %s", position, item.printStanding()
                );

                out.write(outputString.getBytes(StandardCharsets.UTF_8));
                out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        out.close();
    }
}
