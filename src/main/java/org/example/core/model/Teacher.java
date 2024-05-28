package org.example.core.model;

import java.util.Objects;

public class Teacher {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String position;


    public Teacher(long id,String surname, String name, String patronymic, String position) {
        this.id=id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position=position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(surname, teacher.surname) && Objects.equals(name, teacher.name) && Objects.equals(patronymic, teacher.patronymic) && Objects.equals(position, teacher.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, position);
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

    public String getPosition() {
        return position;
    }
}
