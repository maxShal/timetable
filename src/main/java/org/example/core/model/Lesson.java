package org.example.core.model;

import java.util.Objects;

public class Lesson {
    private final String subjectName;
    private final String groupName;
    private final String teacherName;
    private final String teacherSurname;
    private final String teacherPatronymic;

    public Lesson(String subjectName, String groupName, String teacherName, String teacherSurname, String teacherPatronymic) {
        this.subjectName = subjectName;
        this.groupName = groupName;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherPatronymic = teacherPatronymic;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public String getTeacherPatronymic() {
        return teacherPatronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(subjectName, lesson.subjectName) && Objects.equals(groupName, lesson.groupName) && Objects.equals(teacherName, lesson.teacherName) && Objects.equals(teacherSurname, lesson.teacherSurname) && Objects.equals(teacherPatronymic, lesson.teacherPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, groupName, teacherName, teacherSurname, teacherPatronymic);
    }
}
