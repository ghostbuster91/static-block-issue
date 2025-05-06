package com.example;

public interface MyIssue {
	String schema = MyIssue.A.schema;

	// commenting out below method fixes the issue
	default void accept(String var1) {
	}

	final class A implements MyIssue {
		public static final String schema = new String("aa").trim(); // replacing this with inlined string also fixes
																		// the issue
	}
}
