package org.example.web.model.subjects;

import org.example.core.model.Group;
import org.example.core.model.Subject;

import java.util.List;

public class GetSubjectsResponse {

    private List<Subject> subjectsName;

    public GetSubjectsResponse(List<Subject> subjectsName) {
        this.subjectsName = subjectsName;
    }

    public List<Subject> getSubjectsNameName() {
        return subjectsName;
    }
}
