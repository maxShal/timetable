package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EditStudentResponse
{
    private  String name;
    private  String surname;
    private  String patronymic;
    private  String status;

    public EditStudentResponse(/*String name,*/ String surname/*, String patronymic, String status*/) {

        /*this.name = name;*/
        this.surname = surname;
/*        this.patronymic = patronymic;
        this.status = status;*/
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditStudentResponse that = (EditStudentResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, status);
    }
}
