package org.example.web.model.lesson;

import java.util.Objects;

public class GetLessonByIdResponse {
    private String date;
    private long numberInSchedule;
    private long subjectId;
    private long teacherId;

    public GetLessonByIdResponse( String date, long numberInSchedule, long subjectId, long teacherId) {
        this.date = date;
        this.numberInSchedule = numberInSchedule;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getNumberInSchedule() {
        return numberInSchedule;
    }

    public void setNumberInSchedule(long numberInSchedule) {
        this.numberInSchedule = numberInSchedule;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                ", date=" + date +
                ", numberInSchedule=" + numberInSchedule +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByIdResponse lesson = (GetLessonByIdResponse) o;
        return  numberInSchedule == lesson.numberInSchedule && subjectId == lesson.subjectId && teacherId == lesson.teacherId && Objects.equals(date, lesson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, numberInSchedule, subjectId, teacherId);
    }
}
