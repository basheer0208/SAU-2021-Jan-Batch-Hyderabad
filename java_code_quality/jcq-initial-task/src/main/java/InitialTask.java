import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class InitialTask {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(InitialTask.class.getClassLoader().getResource("sample.html").toURI());

        String contents = new String(Files.readAllBytes(path));
        String co[]= contents.split("\n");
        String country= new String();
        // Now i am using substring we will get title in variable country.
        for(int i=0;i<co.length;i++)
        {
        	if(co[i].contains("<title>"))
        	{
        		 int start=co[i].indexOf("<title>")+7;
        		 int end=co[i].indexOf("</title>");
        		country=co[i].substring(start,end);
        	}
        
        }
        // comparing country with other countries.
        if((country.toLowerCase()).equals("india"))
        {
        	System.out.println("Five Countries in India :");
        	System.out.println("1.Mumbai");
        	System.out.println("2.chennai");
        	System.out.println("3.delhi");
        	System.out.println("4.hyderabad");
        	System.out.println("5.pune");
        }
        if((country.toLowerCase()).equals("nepal"))
        {
        	System.out.println("Five Countries in Nepal :");
        	System.out.println("1.Khatmandu");
        	System.out.println("2.janakpur");
        	System.out.println("3.lumbini");
        	System.out.println("4.Bharatpur");
        	System.out.println("5.Patan");
        }
        if((country.toLowerCase()).equals("south korea"))
        {
        	System.out.println("Five Countries in South korea :");
        	System.out.println("1.Seoul");
        	System.out.println("2.Incheon"); 
            System.out.println("3.Daejeon");
        	System.out.println("4.Daegu");
        	System.out.println("5.Gwangju");
        }
        if((country.toLowerCase()).equals("Vietnam"))
        {
        	System.out.println("Five Countries in Vietnam :");
        	System.out.println("1.Haiphong");
        	System.out.println("2.Hanoi"); 
            System.out.println("3.Da Nang");
        	System.out.println("4.Can Tho");
        	System.out.println("5.Ho Chi Minh City");
        }
        if((country.toLowerCase()).equals("somalia"))
        {
        	System.out.println("Five Countries in somalia :");
        	System.out.println("1.Guriel");
        	System.out.println("2.Abaareey"); 
            System.out.println("3.Abudwak");
        	System.out.println("4.Adado");
        	System.out.println("5.Afgooye");
        }

        
        
       
    }
        

    }