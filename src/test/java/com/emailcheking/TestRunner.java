package com.emailcheking;

import org.testng.TestNG;




public class TestRunner {

	public static void main(String[] args) {

		TestNG testng = new TestNG();
	    Class[] classes = new Class[]{MailTest.class};
	    testng.setTestClasses(classes);
	    testng.run();

	}
}
