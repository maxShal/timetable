package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EditStudentRequest
{
    @JsonProperty("id")
    private  long id;
    @JsonProperty("name")
    private  String name;
    @JsonProperty("surname")
    private  String surname;
    @JsonProperty("patronymic")
    private  String patronymic;
    @JsonProperty("status")
    private  String status;
    @JsonProperty("groupId")
    private long groupId;

    public EditStudentRequest(@JsonProperty("id") long id, @JsonProperty("name")String name,
                              @JsonProperty("surname") String surname, @JsonProperty("patronymic")String patronymic,
                              @JsonProperty("status")String status,@JsonProperty("groupId") long groupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
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
        EditStudentRequest that = (EditStudentRequest) o;
        return id == that.id && groupId == that.groupId && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, status, groupId);
    }
}
