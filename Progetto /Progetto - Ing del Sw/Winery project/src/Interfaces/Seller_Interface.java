package Interfaces;

import java.util.Scanner;
import Operations.*;
import Actors.*;
import java.sql.Date;

public class Seller_Interface {
	
	public void show_interface() {
		System.out.println("""
				1 - ricerca clienti per cognome.
				2 - ricerca vini per nome.
				3 - ricerca vini per anno.
				4 - ricerca vini per nome e anno.
				5 - ricerca ordini di vendita per intervallo di date. (AGGIUSTARE)
				6 - ricerca ordini di acquisto per intervallo di date. (AGGIUSTARE)
				7 - ricerca proposte di acquisto per intervallo di date. (AGGIUSTARE)
				8 - compila ordine di acquisto.
				9 - esamina e compila proposta. 
				10 - compila proposta.
				11 - esci.
				""");
	}
	
	public void select_op(final int uid) {
		
		Scanner s = new Scanner(System.in);
		
		int op;
		String yyyy = "", mm = "", dd = "";
		Date start, end;

		while(true) {
		show_interface();
		
		System.out.println("Inserisci operazione: ");
		
		op = s.nextInt();
		
		switch(op) {
		
		case 1:
			String customer_s;
			System.out.println("Inserisci cognome cliente: ");
			customer_s = s.next();
			new Customer_searchbysurname().customer_srcbysurn(customer_s);
			break;
			
		case 2:
			String winename;
			System.out.println("Inserisci nome vino: ");
			winename = s.next();
			new Wine_searchname().wine_name(winename);
			break;
			
		case 3:
			int wineyear;
			System.out.println("Inserisci anno vino: ");
			wineyear = s.nextInt();
			new Wine_searchyear().wine_year(wineyear);
			break;
			
		case 4: 
			String wine_name;
			int wine_year;
			System.out.println("Inserisci nome vino: ");
			wine_name = s.next();
			System.out.println("Inserisci anno vino: ");
			wine_year = s.nextInt();
			new Wine_generalsearch().wine_general(wine_name, wine_year);
			break;
			
		case 5:
			System.out.println("Inserisci giorno data inizio: ");
			dd = s.next();
			System.out.println("Inserisci mese data inizio: ");
			mm = s.next();
			System.out.println("Inserisci anno data inizio: ");
			yyyy = s.next();
			
			start = Date.valueOf(dd+mm+yyyy);
			
			System.out.println("Inserisci giorno data fine: ");
			dd = s.next();
			System.out.println("Inserisci mese data fine: ");
			mm = s.next();
			System.out.println("Inserisci anno data fine: ");
			yyyy = s.next();
			
			end = Date.valueOf(dd+mm+yyyy);
			
			new Purchase_search().Purchase_src(start, end);
			break;
			
		case 6:
			System.out.println("Inserisci giorno data inizio: ");
			dd = s.next();
			System.out.println("Inserisci mese data inizio: ");
			mm = s.next();
			System.out.println("Inserisci anno data inizio: ");
			yyyy = s.next();
			
			start = Date.valueOf(dd+mm+yyyy);
			
			System.out.println("Inserisci giorno data fine: ");
			dd = s.next();
			System.out.println("Inserisci mese data fine: ");
			mm = s.next();
			System.out.println("Inserisci anno data fine: ");
			yyyy = s.next();
			
			end = Date.valueOf(dd+mm+yyyy);
			
			new Supply_search().Supply_src(start, end);
			break;
		
		case 7:
			System.out.println("Inserisci giorno data inizio: ");
			dd = s.next();
			System.out.println("Inserisci mese data inizio: ");
			mm = s.next();
			System.out.println("Inserisci anno data inizio: ");
			yyyy = s.next();
			
			start = Date.valueOf(dd+mm+yyyy);
			
			System.out.println("Inserisci giorno data fine: ");
			dd = s.next();
			System.out.println("Inserisci mese data fine: ");
			mm = s.next();
			System.out.println("Inserisci anno data fine: ");
			yyyy = s.next();
			
			end = Date.valueOf(dd+mm+yyyy);
			
			new Proposal_search().Purchase_src(start, end);
			break;
		
		case 8:
			System.out.println("Inserisci id vino: ");
			int id = s.nextInt();
			Wine wine = new Wine_searchID().wine_id(id);
			System.out.println("Inserisci id fornitore: ");
			int id_s = s.nextInt();
			Supplier sup = new Supplier_searchID().supplier_id(id_s);
			System.out.println("Inserisci quantità vino: ");
			int quant = s.nextInt();
			
			new Compile_supply().compile_supply(wine, sup, quant);
			break;
			
		case 9:
			new Watch_proposal().watch(uid);
			
		case 10:
			System.out.println("Inserisci id proposta: ");
			int idprop = s.nextInt();
			new Get_info().compile_supply(idprop);
			
		case 11:
			System.exit(1);
			
		default:
			System.out.println("Operazione sconosciuta");
		}
			
	}
	}
}
