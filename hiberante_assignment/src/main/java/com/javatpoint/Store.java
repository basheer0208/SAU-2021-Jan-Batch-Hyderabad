package com.javatpoint;  

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class Store {  
public static void main(String[] args) {  
	
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
	
	SessionFactory factory=meta.getSessionFactoryBuilder().build();
	Session session=factory.openSession();
	
    Transaction t=session.beginTransaction();  
      
    Employee e1=new Employee();  
    e1.setName("Ravi Malik");  
    e1.setEmail("ravi@gmail.com");  
    
    Employee e2=new Employee();
    e2.setName("Anuj Verma");
    e2.setEmail("anuj@gmail.com");
      
    Address address1=new Address();  
    address1.setAddressLine1("G-13,Sector 3");  
    address1.setCity("Noida");  
    address1.setState("UP");  
    address1.setCountry("India");  
    address1.setPincode(201301);  
      
    e1.setAddress(address1);  
    e2.setAddress(address1);
      
    session.persist(e1);  
    session.persist(e2);
    
    t.commit();  
      
    session.close();  
    System.out.println("success");  
}  
}  