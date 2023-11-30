

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sat.entity.ContractEmployee;
import com.sat.entity.Employee;
import com.sat.entity.RegularEmployee;

public class StoreData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
	    Session session = sf.openSession();
	    Transaction txn = session.beginTransaction();
	    
	    Employee e1= new Employee();
	    e1.setId(1);
	    e1.setFirstName("SATYANARAYANA");
	    e1.setLastName("NAVARA");
	    
	    RegularEmployee regEmp= new RegularEmployee();
	    regEmp.setId(1);
	    regEmp.setFirstName("SIRISHA");
	    regEmp.setLastName("DHARANALAKOTA");
	    regEmp.setSalary(38000.00);
	    regEmp.setBonus(500.00);
	    
	    ContractEmployee contractEmp= new ContractEmployee();
	    contractEmp.setId(1);
	    contractEmp.setFirstName("Rajesh");
	    contractEmp.setLastName("Navara");
	    contractEmp.setPayPerHour(500.00);
	    contractEmp.setContractDuration(1.5);
	    
	    session.save(e1);
	    session.save(regEmp);
	    session.save(contractEmp);
	    txn.commit();
	    
	    sf.close();
	    session.close();
	    System.out.println("Save Success");
	}
}
