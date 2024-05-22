package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.group.AddGroupRequest;

import java.util.Objects;

public class AddStudentRequest
{

    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("status")
    private String status;
    @JsonProperty("groupId")
    private long groupId;



    @JsonCreator
    public AddStudentRequest(@JsonProperty("surname")String surname, @JsonProperty("name")String name,@JsonProperty("patronymic") String patronymic,@JsonProperty("status") String status, @JsonProperty("groupId")long groupId) {
        this.surname = surname;
        this.name = name;
        this.patronymic=patronymic;
        this.status = status;
        this.groupId = groupId;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public long getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStudentRequest that = (AddStudentRequest) o;
        return groupId == that.groupId && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, status, groupId);
    }
}
