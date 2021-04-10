package com.rabiddog.challenge.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeamScore {
    private Team team;
    private int score;

    private static final Pattern namePattern = Pattern.compile(".*\\s");
    private static final Pattern scorePattern = Pattern.compile("[0-9]+");

    public static TeamScore createInstance(String name, int score){
        var output = new TeamScore();
        output.team = Team.createInstance(name);
        output.score = score;

        return output;
    }

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

        return TeamScore.createInstance(name, score);
    }

    public Team getTeam(){return this.team;}
    public int getScore(){return this.score;}
}
