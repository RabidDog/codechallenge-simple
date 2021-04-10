package com.rabiddog.challenge;

public class TeamScore {
    private Team team;
    private int score;
    public static TeamScore createInstance(String name, int score){
        var output = new TeamScore();
        output.team = Team.createInstance(name);
        output.score = score;

        return output;
    }

    public static TeamScore parse(String formattedString) {
        // deal with empty string
        // deal with string that has no whitespace
        // deal with string containing special characters

        formattedString = formattedString.trim();
        var split = formattedString.split("[A-Za-z | \\s]+\\s", 2);
        var name= split[0].trim();
        var stringScore= split[1].trim();

        return TeamScore.createInstance(name, Integer.parseInt(stringScore));
    }

    public Team getTeam(){return this.team;}
    public int getScore(){return this.score;}
}
