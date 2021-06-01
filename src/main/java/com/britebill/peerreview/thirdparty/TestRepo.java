package com.britebill.peerreview.thirdparty;

import java.util.List;

public class TestRepo {

    private static List<Test> tests;

    public static Test getTest(int id) {
        return tests.get(id);
    }
}
