package org.example.web.model.group;

import java.util.Objects;

public class AddGroupResponse {
    //private String name;
    private int id;

    public AddGroupResponse( int id) {
        //this.name = name;
        this.id = id;
    }

    /*public String getName() {
        return name;
    }*/

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddGroupResponse that = (AddGroupResponse) o;
        return /*Objects.equals(name, that.name) && */Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*name,*/ id);
    }
}
