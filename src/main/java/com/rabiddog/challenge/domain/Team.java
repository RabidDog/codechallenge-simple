package com.rabiddog.challenge.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Team implements Comparable<Team>{

    private String name;

    /***
     *
     * @param name the name of the team
     * @return a new instance of Team
     */
    public static Team createInstance(String name){
        var output = new Team();
        output.name = name;

        return output;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Team team) {
        return name.compareTo(team.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
