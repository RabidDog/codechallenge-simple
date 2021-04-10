package com.rabiddog.challenge.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SportLeague {
    private List<SportMatch> matches = new ArrayList<>();
    private LeagueTable leagueTable = new LeagueTable();

    public static SportLeague parse(List<String> matchResults){
        var output = new SportLeague();

        matchResults.forEach(matchResult ->
            output.addMatch(SportMatch.parse(matchResult))
        );

        output.leagueTable = LeagueTable.createInstance(output.matches);

        return output;
    }

    private void addMatch(SportMatch matchResult){
        this.matches.add(matchResult);
    }

    public int getMatchesCount() {
        return this.matches.size();
    }

}
