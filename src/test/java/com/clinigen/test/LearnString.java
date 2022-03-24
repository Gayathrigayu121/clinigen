package com.clinigen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnString {
 
	
	
	
	public static void main (String[] args) {
		
		String stringArray= "ALGS/PFIC";
		
		String stringArray1="Hispanic or Latino/ Not Hispanic or Latino/Unknown";
		String[] str=stringArray.split("/",2);
	    List<String> stringList=new ArrayList<String>();
		for(String a:str)
		{
			stringList.add(a);
		}
        String[] str1=stringArray1.split("/",3);
	
		for( String a1:str1)
		{
			stringList.add(a1);	
		}
		System.out.println("stringList ="+stringList);
		
		
		
		
		/*
		 * String delim = "-"; String res = String.join(delim, stringArray);
		 * System.out.println(res);
		 */
		
		
		
		
		
		/*
		 * System.out.println("stringArray = "+stringArray);
		 * 
		 * StringBuffer sb = new StringBuffer(); for(int i = 0; i < stringArray.length;
		 * i++) {
		 * 
		 * sb.append(stringArray[i]); }
		 * 
		 * String str1 = Arrays.toString(stringArray); String str = sb.toString();
		 * 
		 * 
		 * String delim = "-";
		 * 
		 * String res = String.join(delim, list); System.out.println("str1="+str1);
		 * System.out.println("str="+str);
		 * 
		 */	}
}
