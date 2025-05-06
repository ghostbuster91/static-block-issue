package com.example;


public sealed interface MyIssue {
    String schema = MyIssue.A.schema;

    //  commenting out below method fixes the issue
    default <T> T accept(String var1) {
            throw new RuntimeException("Unhandled union case");
    }

    final class A implements MyIssue {
        public static final String schema = new String("aa").trim(); //replacing this with inlined string also fixes the issue
    }
}
