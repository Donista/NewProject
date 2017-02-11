package com.example.donista.newproject;

/**
 * Created by Donista on 28.01.2017.
 */
public class Grant {
    private String grantName;
    private String grantDescription;
    private String grantDeadlineEdit;
    private String grantTagsEdit;
    private String id;
    private String linkTextView;

    public Grant(String grantName, String grantDescription, String grantDeadlineEdit, String grantTagsEdit, String linkTextView) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.grantDeadlineEdit = grantDeadlineEdit;
        this.grantTagsEdit=grantTagsEdit;
        this.linkTextView = linkTextView;
    }
    public Grant() {}

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

    public String getGrantDeadlineEdit() {
        return grantDeadlineEdit;
    }

    public void setGrantDeadlineEdit(String grantDeadlineEdit) {
        this.grantDeadlineEdit = grantDeadlineEdit;
    }

    public String getGrantTagsEdit() {
        return grantTagsEdit;
    }

    public void setGrantTagsEdit(String grantTagsEdit) {
        this.grantTagsEdit = grantTagsEdit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkTextView() {
        return linkTextView;
    }

    public void setLinkTextView(String linkTextView) {
        this.linkTextView = linkTextView;
    }


}
