package com.praharsha;
import java.lang.*;
import java.util.*;
public class ThreadClass implements Runnable {
	
	HashMap<String,Integer> hm1=new HashMap<String,Integer>();
	
	public ThreadClass(HashMap<String, Integer> hm1) {
		super();
		this.hm1 = hm1;
	}

	public void run()
	{
		
		System.out.println("WordCount");
		Iterator<String> itr = hm1.keySet().iterator();
		while (itr.hasNext()) {
			String a1=itr.next();
		    System.out.println(a1+" "+hm1.get(a1));
		 
		}
	}

}
