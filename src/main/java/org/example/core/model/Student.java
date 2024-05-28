package org.example.core.model;

import java.util.Objects;

public class Student
{
    private  long id;
    private  String name;
    private  String surname;
    private  String patronymic;
    private  String status;
    private long groupId;

    public Student(long id, String name, String surname, String status, long groupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.groupId = groupId;
    }

    public String getPatronymic() {
        return patronymic;
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

    public String getStatus() {
        return status;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && groupId == student.groupId && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(status, student.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, status, groupId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status='" + status + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
