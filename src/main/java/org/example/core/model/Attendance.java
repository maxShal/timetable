package org.example.core.model;

import java.util.Objects;

public class Attendance {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String subjectName;

    public Attendance(String surname, String name, String patronymic, String subjectName) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.subjectName = subjectName;
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

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, subjectName);
    }
}
