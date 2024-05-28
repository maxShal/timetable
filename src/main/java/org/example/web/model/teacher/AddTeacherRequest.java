package org.example.web.model.teacher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AddTeacherRequest
{
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("position")
    private String position;

    @JsonCreator
    public AddTeacherRequest(@JsonProperty("surname")String surname,@JsonProperty("name") String name, @JsonProperty("patronymic")String patronymic, @JsonProperty("position") String position) {

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position=position;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {

        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTeacherRequest that = (AddTeacherRequest) o;
        return Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }
}
