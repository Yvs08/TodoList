
package com.todolist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application {

    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
}
/**

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired 
	//private DataSourceRepository repository;
        //private DataSetRepository repositor;
       // private GrapheRepository graphetor;
        //private  RapportRepository rapptor; 
        //private GroupRapportRepository grouptor ;

	public static void main(String[] args) 
        {
		SpringApplication.run(Application.class, args);
	}
        

	@Override
	public void run(String... args) throws Exception 
                
        {
          
            GrapheRapport1 grapherap =  new GrapheRapport1("3000", "metallica", "3000");
            GrapheRapport1 grapherape = new GrapheRapport1("1000", "metallica", "3000");
            GrapheRapport1 grapherapo = new GrapheRapport1("2000", "metallica", "3000");
            
             List<GrapheRapport1> grapherapport = new ArrayList<GrapheRapport1>();
		grapherapport.add(grapherap);
                grapherapport.add(grapherape);
                grapherapport.add(grapherapo);
                
                
                for (GrapheRapport1 str : grapherapport)
              {
               System.out.println(str);
              }
                
                 rapptor.save(new Rapport("300", "10","101", "14","17","101","14","17","14","17", grapherapport));
                 //grouptor.save(new GroupRapport("300", "10"));
            
          /**
            Parametre parametre = new Parametre("3000", "metallica", "3000", "metallica", "metallica");
            
            List<Parametre> param = new ArrayList<Parametre>();
		param.add(parametre);
                for (Parametre str : param)
              {
               System.out.println(str);
              }
               
		//mongoOperation.insert(userList, User.class);
               repositor.save(new Dataset("300", "10","101", "14","17","101","14","17", param ));
               
               //graphetor.save(new Graphe ( "100","144","10","122"));
                       
              **/  
		//rapptor.deleteAll(); 

		// save a couple of customers
		//repository.save(new DataSource("300", "10","101", "14","17", "11" ));
		

	       // fetch all customers
		//System.out.println("rapport found with findAll():");
		//System.out.println("-------------------------------");
                
		//for (Rapport rapport : rapptor.findAll()) 
               // {
			//System.out.println(rapport);
		//}
		//System.out.println();

		// fetch an individual customer
		//System.out.println("rapport found with findByNom('Nom'):");
		//System.out.println("--------------------------------");
		//System.out.println(rapptor.findByNom("300"));
                

		//System.out.println("Rpport found with findByDescription('description'):");
		//System.out.println(rapptor.findByDescription("144"));
                
		//for (GroupRapport grouprapport : grouptor.findByDescription("144"))
                //{
		//	System.out.println(grouprapport );
		//}
                
              //  Iterator<Rapport> rapport = (Iterator<Rapport>) rapptor.findByDescription("144");
                
	 

	//while (rapport.hasNext()) 
       // {
	 //    System.out.println(rapport.next());
	//}
                
                
                

	//}

//}

 