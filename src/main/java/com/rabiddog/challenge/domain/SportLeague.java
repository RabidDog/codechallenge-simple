package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.StringParseException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class SportLeague {

    private List<SportMatch> matches = new ArrayList<>();
    private LeagueTable leagueTable;

    public static SportLeague parse(
            @NotNull final List<String> matchResults) throws StringParseException {

        Objects.requireNonNull(matchResults, "Match Results String list cannot be null");

        var output = new SportLeague();

        for (var matchResult : matchResults) {
            output.addMatch(SportMatch.parse(matchResult));
        }

        output.leagueTable = new LeagueTable(output.matches);

        return output;
    }

    public int getMatchesCount() {
        return this.matches.size();
    }

    private void addMatch(
            @NotNull final SportMatch matchResult) {

        Objects.requireNonNull(matchResult, "Match result cannot be null");

        this.matches.add(matchResult);
    }
}
