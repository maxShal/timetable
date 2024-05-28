package org.example.web.model.teacher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.core.model.Teacher;

import java.util.Objects;

public class EditTeacherRequest
{
    @JsonProperty("id")
    private long id;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("position")
    private String position;

    @JsonCreator
    public EditTeacherRequest(@JsonProperty("id") long id,@JsonProperty("surname")String surname,@JsonProperty("name") String name, @JsonProperty("patronymic") String patronymic, @JsonProperty("position") String position) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public long getId() {
        return id;
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
        EditTeacherRequest teacher = (EditTeacherRequest) o;
        return Objects.equals(surname, teacher.surname) && Objects.equals(name, teacher.name) && Objects.equals(patronymic, teacher.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }

}
