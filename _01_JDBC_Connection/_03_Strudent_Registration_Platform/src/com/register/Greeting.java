package com.register;

public class Greeting {

	public static void intro(String message) {

		System.out.println();
		System.out.println("============================================================");
		System.out.println("                    " + message);
		System.out.println("============================================================");
		System.out.println();
	}

	public static void outro(String message) {

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("                 " + message);
		System.out.println("------------------------------------------------------------");
		System.out.println();
	}
}