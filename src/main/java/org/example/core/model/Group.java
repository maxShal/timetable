package org.example.core.model;

public class Group
{
    private  long id;
    private  String groupName;


    public Group( long id, String groupName) {
        this.id = id;
        this.groupName = groupName;}

    public String getGroupName(){return  groupName;}

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.groupName = name;
    }
    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(String groupName) {
        return this.groupName.equals(groupName);
    }

    @Override
    public int hashCode() {
        return this.groupName.hashCode();
    }

    @Override
    public String toString() {
        return groupName;
    }
}
