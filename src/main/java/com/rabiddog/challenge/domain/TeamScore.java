package com.rabiddog.challenge.domain;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class TeamScore {
    private Team team;
    private int score;

    private static final Pattern namePattern = Pattern.compile(".*\\s");
    private static final Pattern scorePattern = Pattern.compile("[0-9]+");

    /***
     *
     * @param team the team that the score applies to
     * @param score the score of the team in the match
     * @return a new instance of TeamScore
     */
    public static TeamScore createInstance(Team team, int score){
        var output = new TeamScore();
        output.team = team;
        output.score = score;

        return output;
    }

    /***
     *
     * @param formattedString - formatted string to create the team score ("team score") eg ("home team 3")
     * @return a new instance of TeamScore
     */
    public static TeamScore parse(String formattedString) {
        formattedString = formattedString.trim();

        Matcher nameMatcher = namePattern.matcher(formattedString);
        var name = "";

        if(nameMatcher.find()){
            name = nameMatcher.group(0).trim();
        }

        var score = -1;
        Matcher scoreMatcher = scorePattern.matcher(formattedString);

        if(scoreMatcher.find()){
            score = Integer.parseInt(scoreMatcher.group(0).trim());
        }

        return TeamScore.createInstance(Team.createInstance(name), score);
    }
}
