package Interfaces;

import java.sql.Date;
import java.util.Scanner;

import Actors.*;
import Operations.*;

public class Customer_Interface {
	
	public void show_interface() {
		System.out.println("""
				1 - cerca vini per nome
				2 - cerca vini per anno
				3 - cerca vini per nome e anno
				4 - acquista vino
				5 - visualizza stato proposta di acquisto
				0 - esci
				""");
		}
	
	
public void select_op(final int uid) {
		
		Scanner s = new Scanner(System.in);
		
		int op;

		while(true) {
		show_interface();
		
		System.out.println("Inserisci operazione: ");
		
		op = s.nextInt();
		
		switch(op) {
		
		case 1:
			String winename;
			System.out.println("Inserisci nome vino: ");
			winename = s.next();
			new Wine_searchname().wine_name(winename);
			break;
			
		case 2:
			int wineyear;
			System.out.println("Inserisci anno vino: ");
			wineyear = s.nextInt();
			new Wine_searchyear().wine_year(wineyear);
			break;
			
		case 3: 
			String wine_name;
			int wine_year;
			System.out.println("Inserisci nome vino: ");
			wine_name = s.next();
			System.out.println("Inserisci anno vino: ");
			wine_year = s.nextInt();
			new Wine_generalsearch().wine_general(wine_name, wine_year);
			break;
			
		case 4:
			//acquista vino (ricerca nome e anno e poi aggiungi)
			Customer cus = new Customer_constructor().cutsm_con(uid);
			String wine_n,method;
			int wine_y;
			System.out.println("Inserisci nome vino: ");
			wine_n = s.next();
			System.out.println("Inserisci anno vino: ");
			wine_y = s.nextInt();
			Wine o = new Wine_generalsearch().wine_general(wine_n, wine_y);
			if(o.get_quantity() != 0) {
				//fai acquisto
				System.out.println("Scegli metodo di pagamento: \n 1. carta.\n 2.bonifico");
				int m = s.nextInt();
				switch (m) {
				case 1:
					method = "Carta di credito";
					new Buy_wine().buy(o, wine_y, cus,method);
					break;
				case 2:
					method = "Bonifico";
					new Buy_wine().buy(o, wine_y, cus,method);
					break;
				default:
					System.out.println("Errore.");
					break;
				}
			}
			else {
				new Compile_proposal().prop(o, wine_y, cus);
			}
			break;
			
		case 5:
			System.out.println("Inserisci id proposta: ");
			int p_id = s.nextInt();
			new Watch_prop_status().prop_src(p_id);
			break;
		
		default:
			System.out.println("Operazione sconosciuta");
			}
			
		}
	}
}