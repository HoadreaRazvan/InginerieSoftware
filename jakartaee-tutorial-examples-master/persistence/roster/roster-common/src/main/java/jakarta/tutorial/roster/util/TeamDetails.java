/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.tutorial.roster.util;

import java.io.Serializable;


public class TeamDetails implements Serializable {
    private static final long serialVersionUID = -1618941013515364318L;
    private String id;
    private String name;
    private String city;
    private String opponent;
    private int matchesPlayed;
    private int points;
    private int scoreTeam1;
    private int scoreTeam2;

    public TeamDetails(String id, String name, String city) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.matchesPlayed=-1;
        this.points=-1;
        this.scoreTeam1=-1;
    }

    public TeamDetails(String name, int matchesPlayed, int points) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.points = points;
        this.scoreTeam1=-1;
    }
    public TeamDetails(String team1,String team2, int scoreTeam1, int scoreTeam2) {
        this.name = team1;
        this.opponent = team2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.matchesPlayed=-1;
        this.points=-1;
    }

    public String getOpponent() {
        return opponent;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        if(matchesPlayed!=-1 && points!=-1)
            return name + " " + matchesPlayed + " " + points;
        else if(scoreTeam1!=-1)
            return name + " " + opponent + " -> " + scoreTeam1 + ":" + scoreTeam2;
        else
        return id + " " + name + " " + city;
    }

}
