package com.praharsha;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator; 
class Hi
{ 
public static void main(String[] args)throws Exception 
{ 

HashMap<String,Integer>hm=new HashMap<String,Integer>();
File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Multithreadassignment\\src\\com\\praharsha\\Book.txt"); 

BufferedReader br = new BufferedReader(new FileReader(file)); 
int cnt=0;
int wcnt=0;
String st; 
while ((st = br.readLine()) != null) {
	String a[]=st.split(" ");
	for(int i=0;i<a.length;i++)
	{
		if(hm.containsKey(a[i].toLowerCase()))
		{
			hm.put(a[i].toLowerCase(),hm.get(a[i].toLowerCase())+1);
		}
		else
		{
			hm.put(a[i].toLowerCase(), 1);
		}
	}
	cnt=cnt+1;
	wcnt=wcnt+a.length;
	
	
}
System.out.println("Total Words are "+wcnt);
System.out.println("total unique words present are "+hm.size());
System.out.println("sentences = "+ cnt);
ThreadClass t=new ThreadClass(hm);

Thread t1= new Thread(t);
System.out.println("The words frequency of each word is : ");
t1.start();


}
}
