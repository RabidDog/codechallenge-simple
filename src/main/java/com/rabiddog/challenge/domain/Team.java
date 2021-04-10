package com.rabiddog.challenge.domain;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
public class Team implements Comparable<Team>{

    private String name;

    public Team(
            @NotNull final String name){

        Objects.requireNonNull(name, "Team Name cannot be null");

        this.name = name;
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
