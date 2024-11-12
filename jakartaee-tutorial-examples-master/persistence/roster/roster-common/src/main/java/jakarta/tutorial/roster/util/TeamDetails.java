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
    private int matchesPlayed=-1;
    private int points=-1;

    public TeamDetails(String id, String name, String city) {

        this.id = id;
        this.name = name;
        this.city = city;
    }

    public TeamDetails(String id, int matchesPLayed, int points) {

        this.id = id;
        this.matchesPlayed = matchesPLayed;
        this.points = points;
    }

    public TeamDetails(String id, String name, String city,int points) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.points = points;
    }


    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getPoints() {
        return points;
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
        if(matchesPlayed!=-1)
            return id + " " + matchesPlayed + " " + points;
        else if(points!=-1)
            return id + " " + name + " " + city + " " + points;
        else
            return id + " " + name + " " + city;
    }

}
