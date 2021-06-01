package com.britebill.peerreview.thirdparty;

import com.britebill.peerreview.GradeStatus;
import lombok.Data;

import java.util.List;

@Data
public class Test {
    private List<Answer> answers;
    private GradeStatus status;
}
