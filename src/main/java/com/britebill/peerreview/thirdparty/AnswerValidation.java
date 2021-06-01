package com.britebill.peerreview.thirdparty;

import java.io.IOException;

public class AnswerValidation {
    private final static int EXCELENT_GRADE = 8;
    private final static int MIN_GRADE = 5;

    public static int grade(Answer answer) throws IOException {
        return answer.getGrade();
    }

    public static boolean isFail(int grade) {
        return grade < MIN_GRADE;
    }

    public static boolean isOK(int grade) {
        return grade >= MIN_GRADE;
    }

    public static boolean isExcelent(int grade) {
        return grade > EXCELENT_GRADE;
    }
}
