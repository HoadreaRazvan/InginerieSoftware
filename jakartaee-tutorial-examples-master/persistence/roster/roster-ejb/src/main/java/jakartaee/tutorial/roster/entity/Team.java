/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakartaee.tutorial.roster.entity;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.*;


@Entity
@Table(name = "PERSISTENCE_ROSTER_TEAM")
public class Team implements Serializable {
    private static final long serialVersionUID = 4797864229333271809L;
    private String id;
    private String name;
    private String city;
    private Collection<Player> players;
    private League league;

    private int points;
    private String matchesPlayed="";

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }
    public void setMatchesPlayed(String matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void addMatch(String match)
    {
        matchesPlayed+=match+":";
    }



    private Collection<Team> matches;

    @OneToMany
    public Collection<Team> getMatches() {
        return matches;
    }

    public void setMatches(Collection<Team> matches) {
        this.matches = matches;
    }








    /** Creates a new instance of Team */
    public Team() {
    }
    
    public Team(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.points=0;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ManyToMany
    @JoinTable(
        name="PERSISTENCE_ROSTER_TEAM_PLAYER",
        joinColumns=
            @JoinColumn(name="TEAM_ID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="PLAYER_ID", referencedColumnName="ID")
    )
    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    @ManyToOne public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    
    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }
    
    public void dropPlayer(Player player) {
        this.getPlayers().remove(player);
    }

}
