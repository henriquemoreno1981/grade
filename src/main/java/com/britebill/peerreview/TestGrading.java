package com.britebill.peerreview;

import com.britebill.peerreview.thirdparty.Answer;
import com.britebill.peerreview.thirdparty.AnswerValidation;
import com.britebill.peerreview.thirdparty.Test;
import com.britebill.peerreview.thirdparty.TestRepo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.britebill.peerreview.GradeStatus.*;

@SuppressWarnings("Duplicates")
@Service
public class TestGrading {


    /**
     * Process the test by id
     *
     * @param id Id of test
     * @return status of test
     */
    public GradeStatus ProcessTest(int id) {
        Test test = TestRepo.getTest(id);
        check(test.getAnswers(), test);
        return test.getStatus();
    }

    /**
     * Set status of test based on grade answers
     *
     * @param answers List of answers
     * @param test    Test object
     */
    private void check(List<Answer> answers, Test test) {
        int grade = 0;
        final AnswerValidation answerValidation = new AnswerValidation();
        for (int i = 0; i < answers.size(); i++) {
            try {
                grade += AnswerValidation.grade(answers.get(i));
            } catch (IOException e) {
                LoggerFactory.getLogger("BB").error(e.getLocalizedMessage());
            } catch (Throwable e) {
                LoggerFactory.getLogger("BB-generic").error(e.getLocalizedMessage());
            }
        }
        test.setStatus(passOrFail(grade));
    }

    /**
     * Check the status of grade.
     *
     * @param grade value of grade
     * @return status of grade
     */
    public GradeStatus passOrFail(int grade) {
        if (grade > DISTINC.getGrade()) {
            return DISTINC;
        } else if (grade > DISTINC.getGrade()) {
            return PASS;
        }
        return FAIL;
    }
}