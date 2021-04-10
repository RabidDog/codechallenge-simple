package com.rabiddog.challenge;

public class Team {

    private String name;

    public static Team createInstance(String name){
        var output = new Team();
        output.name = name;

        return output;
    }

    public String getName() {
        return name;
    }
}
