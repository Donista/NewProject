package com.example.donista.newproject;

/**
 * Created by Donista on 28.01.2017.
 */
public class Grant {
    private String grantName;
    private String grantDescription;
    private String grantDeadlineEdit;
    private String grantTagsEdit;
    private String checkBox;
    private String id;





    public Grant(String grantName, String grantDescription, String grantDeadlineEdit,String grantTagsEdit,String checkBox ) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.grantDeadlineEdit = grantDeadlineEdit;
        this.grantTagsEdit=grantTagsEdit;
        this.checkBox=checkBox;
    }

    public String getGrantName() {return grantName;}

    public void setGrantName(String grantName) { this.grantName = grantName;  }

    public String getGrantDescription() {
        return grantDescription;
    }

    public void setGrantDescription (String grantDescription) {this.grantDescription = grantDescription;}

    public String getGrantDeadline() {
        return grantDeadlineEdit;
    }

    public void setGrantDeadline(String grantDeadline) {
        this.grantDeadlineEdit = grantDeadline;
    }


    /*public String getTags() {return tags;}

    public void setTags(String tags) {
        this.tags = tags;
    }
    private String tags;*/

    public Grant() {}

    public String getcheckBox() {
        return checkBox;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrantTagsEdit() {
        return grantTagsEdit;
    }

    public void setGrantTagsEdit(String grantTagsEdit) {
        this.grantTagsEdit = grantTagsEdit;
    }

}
