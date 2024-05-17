package org.example.core.model;

public class Student
{
    private final String name;
    private final String surname;
    private final String patronymic;

    public enum Status{
        STUDYING, VACATION, DISMISSED
    }

    private Status status;
    private Group group;

    public Student(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Group getGroup() {
        return group;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public boolean equals(Student student) {
        return this.surname.equals(student.getSurname()) && this.name.equals(student.getName()) && this.patronymic.equals(student.getPatronymic()) && this.status == student.status;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode() + this.patronymic.hashCode() + this.status.hashCode();
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", status=" + status +
                ", group=" + group;
    }
}
