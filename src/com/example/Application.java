package com.example;


public class Application {
	public static void main(String[] args) {
		// uncommenting below line fixes the issue
//		 System.out.println(MyIssue.schema);
		System.out.println(MyIssue.A.schema);

		var schema =  MyIssue.schema;

		System.out.println(schema);
	}
}

