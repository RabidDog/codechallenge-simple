package com.rabiddog.challenge;

import java.util.ArrayList;
import java.util.List;

public class SportLeague {
    private List<SportMatch> matches = new ArrayList<>();

    public static SportLeague parse(List<String> matchResults){
        var output = new SportLeague();

        matchResults.stream().forEach(matchResult -> {
            output.matches.add(SportMatch.parse(matchResult));
        });

        return output;
    }


    public int getMatchesCount() {
        return this.matches.size();
    }
}
