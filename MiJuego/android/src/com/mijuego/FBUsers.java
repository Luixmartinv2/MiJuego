package com.mijuego;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by luixmartinv2 on 15/6/18.
 */

@IgnoreExtraProperties
public class FBUsers {
    public String name;
    public int record;
    public String userID;

    public FBUsers() {

    }

    public FBUsers(String name, int record, String userID) {
        this.name = name;
        this.record = record;
        this.userID = userID;
    }

}
