package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.StringParseException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class TeamScore {
    private Team team;
    private int score;

    private static final Pattern namePattern = Pattern.compile(".*\\s");
    private static final Pattern scorePattern = Pattern.compile("[0-9]+");

    public TeamScore(
            @NotNull final Team team,
            final int score){

        Objects.requireNonNull(team, "Team cannot be null");

        this.team = team;
        this.score = score;
    }

    /***
     *
     * @param formattedString - formatted string to create the team score ("team score") eg ("home team 3")
     * @return a new instance of TeamScore
     */
    public static TeamScore parse(
            @NotNull final String formattedString) throws StringParseException {

        Objects.requireNonNull(formattedString, "Team Score formatted String cannot be null");

        var stringToParse = formattedString.trim();

        Matcher nameMatcher = namePattern.matcher(stringToParse);
        var name = "";

        if(nameMatcher.find()){
            name = nameMatcher.group(0).trim();
        }else{
            throw new StringParseException("The formatted string does not contain a name");
        }

        var score = -1;
        Matcher scoreMatcher = scorePattern.matcher(stringToParse);

        if(scoreMatcher.find()){
            score = Integer.parseInt(scoreMatcher.group(0).trim());
        }else{
            throw new StringParseException("The formatted string does not contain a score");
        }

        return new TeamScore(new Team(name), score);
    }
}
