package com.praharsha;

import java.util.HashMap;

public class WordCount implements Runnable {
	HashMap<String,Integer> hm2=new HashMap<String,Integer>();

	public WordCount(HashMap<String, Integer> hm2) {
		super();
		this.hm2 = hm2;
	}
	public void run()
	{
		System.out.println("total Unique words are "+hm2.size());
	}

}
