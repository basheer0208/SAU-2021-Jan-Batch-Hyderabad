package com.praharsha.CustomAnnotate;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Upper
{
	String name();
}

@Upper(name="python")
class Upperca
{
	String lan;
	public Upperca(String lan)
	{
		this.lan=lan;
	}
	
}
public class Annotate {
public static void main(String[] args) {
		
        Upperca u= new Upperca("java");
         Class c= u.getClass();
         Annotation an=c.getAnnotation(Upper.class);
         Upper up=(Upper)an;
         System.out.print(up.name().toUpperCase());
         
        
	}

}
