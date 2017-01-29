package com.example.donista.newproject;

/**
 * Created by Donista on 28.01.2017.
 */
public class Grant {
    private String grantName;
    private String grantDescription;
    private String grantDeadline;

    public Grant() {
    }

    public Grant(String grantName, String grantDescription, String grantDedline) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.grantDeadline = grantDedline;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getGrantDescription() {
        return grantDescription;
    }

    public void setGrantDescription(String grantDescription) {
        this.grantDescription = grantDescription;
    }

    public String getGrantDeadline() {
        return grantDeadline;
    }

    public void setGrantDeadline(String grantDedline) {
        this.grantDeadline = grantDedline;
    }
}
