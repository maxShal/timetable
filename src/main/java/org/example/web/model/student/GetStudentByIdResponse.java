package org.example.web.model.student;

import java.util.Objects;

public class GetStudentByIdResponse
{
    private  String name;
    private  String surname;
    private  String patronymic;
    private  String status;

    public GetStudentByIdResponse(String name, String surname, String patronymic, String status) {

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
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
        GetStudentByIdResponse that = (GetStudentByIdResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, status);
    }
}
