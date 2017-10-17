package com.hatofa.tools;

import com.mifmif.common.regex.Generex;

public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generex generex = new Generex("[6-9]\\d{9}");
		System.out.println(generex.random());
		Generex generex1 = new Generex("[^\\]+$");
		System.out.println(generex1.random());
	}

}
