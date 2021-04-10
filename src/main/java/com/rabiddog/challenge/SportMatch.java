package com.rabiddog.challenge;


public class SportMatch {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    public static SportMatch createInstance(TeamScore teamAScore, TeamScore teamBScore){
        var output = new SportMatch();
        output.teamAScore = teamAScore;
        output.teamBScore = teamBScore;

        return output;
    }

    public static SportMatch parse(String matchString) {
        var split = matchString.split(",");
        var output = SportMatch.createInstance(
                TeamScore.parse(split[0]),
                TeamScore.parse(split[1])
        );

        return output;
    }

    public TeamScore getTeamAScore(){
        return this.teamAScore;
    }

    public TeamScore getTeamBScore(){
        return this.teamBScore;
    }
}
