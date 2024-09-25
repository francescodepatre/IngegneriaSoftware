package Communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import Actors.*;
import Operations.*;

public class logic_interface {
	
	
	public void execute(final int idcustomer, final request_operation req, final Socket s) throws IOException {
		String operation_name = req.getOperation();
		ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
		
		switch(operation_name) {
			
			case "winename":
				String name = (String) req.getData(0);
				ArrayList<Wine> output = new Wine_searchname().wine_name(name);
				os.writeObject(output);
				os.flush();
				break;
			
			case "wineyear":
				int year = (int) req.getData(0);
				ArrayList<Wine> output_year = new Wine_searchyear().wine_year(year);
				os.writeObject(output_year);
				os.flush();
				break;
			
			case "winegeneral":
				name = (String) req.getData(0);
				year = (int) req.getData(1);
				ArrayList<Wine> output_general = new Wine_generalsearch().wine_general(name, year);
				os.writeObject(output_general);
				os.flush();
				break;
			
			case "buywine":
				int id = (int) req.getData(1);
				int quantity = (int) req.getData(0);
				String method = (String) req.getData(2);
				Wine wine = new Wine_searchID().wine_id(id);
				Customer cus = new Customer_constructor().cutsm_con(idcustomer);
				new Buy_wine().buy(wine, quantity, cus, method);
				break;
				
			case "proposal":
				int id_wprop = (int) req.getData(0);
				int quant_wprop = (int) req.getData(1);
				int prop_id = (int) req.getData(2);
				Wine wineprop = new Wine_searchID().wine_id(id_wprop);
				Customer cus_wprop = new Customer_constructor().cutsm_con(idcustomer);
				new buy_proposal().prop(wineprop, quant_wprop, cus_wprop,prop_id);
				break;
				
			case "watchproposalstatus":
				int proposalid = (int) req.getData(0);
				ArrayList<proposal> prop = new Watch_prop_status().prop_src(proposalid);
				os.writeObject(prop);
				os.flush();
				break;
				
			case "searchproposal":
				String start = (String) req.getData(0);
				String end = (String) req.getData(1);
				ArrayList<proposal> listl = new Proposal_search().proposal_ser(start, end);
				os.writeObject(listl);
				os.flush();
				break;
				
			case "personalproposal":
				ArrayList<proposal> listpersonal = new searchproposalbyid().proposal_ser(idcustomer);
				os.writeObject(listpersonal);
				os.flush();
				break;
				
			case "searchcustomerbysurname":
				String surname = (String) req.getData(0);
				ArrayList<Customer> output_cus =new Customer_searchbysurname().customer_srcbysurn(surname);
				os.writeObject(output_cus);
				os.flush();
				break;
			
			case "compilesupply":
				int idsupplier = (int) req.getData(0);
				int idwine = (int) req.getData(1);
				quantity = (int) req.getData(2);
				new Compile_supply().compile_supply(idwine, idsupplier, quantity);
				break;
				
			case "examineproposal":
				int idproposal = (int) req.getData(0);
				ArrayList<proposal> propos = new Watch_prop_status().prop_src(idproposal);
				os.writeObject(propos);
				os.flush();
				break;
				
			case "compileproposal":
				idproposal = (int) req.getData(0);
				//int id_cus = new proposal_getcustomerid().res(idproposal);
				//Customer customer = new Customer_constructor().cutsm_con(id_cus);
				//Wine w = new Get_info().getProposalWine(idproposal);
				quantity = new Get_info().getProposalQuantity(idproposal);
				new  Remove_proposal().update(idproposal, idcustomer);
				//new Compile_proposal().prop(w, quantity, customer); aggiungere questa funzione al momento in cui la proposata viene accettata dal cliente.
				break;
				
			case "searchsupply":
				start = (String) req.getData(0);
				end = (String) req.getData(1);
				ArrayList<supply> lists = new Supply_search().Supply_src(start, end);
				os.writeObject(lists);
				os.flush();
				break;
				
			case "searchpurchase":
				String strt = (String) req.getData(0);
				String nd = (String) req.getData(1);
				ArrayList<purchase> list = new Purchase_search().Purchase_src(strt, nd);
				os.writeObject(list);
				os.flush();
				break;
				
			case "changepassword_admin":
				String newpassword = (String) req.getData(0);
				new Change_admin_password().change_password(newpassword, idcustomer);
				break;
			
			case "changeusername_admin":
				String newusername = (String) req.getData(0);
				new Change_admin_password().change_username(newusername, idcustomer);
				break;
				
			case "changepassword_seller":
				String newpass = (String) req.getData(0);
				new Change_seller().change_password(newpass, idcustomer);
				break;
			
			case "changeusername_seller":
				String newuser = (String) req.getData(0);
				new Change_seller().change_username(newuser, idcustomer);
				break;
				
			case "supplyint":
				ArrayList<supply> listsup = new supply_src().Supply_src(idcustomer);
				os.writeObject(listsup);
				os.flush();
				break;
				
			case "controlupdate":
				ArrayList<proposal> listupd = new proposal_update_cont().control(idcustomer);
				os.writeObject(listupd);
				os.flush();
				break;
				
			case "removeproposal":
				int id_remove =(int) req.getData(0);
				new Remove_proposal().remove(id_remove);
				break;
				
			case "confprop":
				int id_conf = (int) req.getData(0);
				new Remove_proposal().add_to_purchase(id_conf, idcustomer);
				break;
				
			case "addnewwine":
				Wine wn =(Wine) req.getData(0);
				new add_new_wine().wine_add(wn);
				break;
				
			case "addoffer":
				Offer of = (Offer) req.getData(0);
				new offers_pack().addOffer(of);
				break;
			
			case "rmoffer":
				int id_off = (int) req.getData(0);
				new offers_pack().deleteOffer(id_off);
				break;
			
			case "watchoffers":
				ArrayList<Offer> off_out = new offers_pack().getOffers();
				os.writeObject(off_out);
				os.flush();
				break;
				
			case "lastoffers":
				Offer last_off = new offers_pack().getLastOffer();
				os.writeObject(last_off);
				os.flush();
				break;
				
		}
	}
}
