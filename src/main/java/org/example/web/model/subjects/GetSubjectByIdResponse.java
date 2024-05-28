package org.example.web.model.subjects;

import org.example.core.model.Subject;

import java.util.Objects;

public class GetSubjectByIdResponse 
{
    private Subject subject;

    public GetSubjectByIdResponse(Subject Subject) {
        this.subject = Subject;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSubjectByIdResponse that = (GetSubjectByIdResponse) o;
        return Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(subject);
    }
}
