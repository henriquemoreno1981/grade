package com.britebill.peerreview;

public enum GradeStatus {
    DISTINC(8),
    PASS(5),
    FAIL(4);

    private final int grade;

    GradeStatus(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}
