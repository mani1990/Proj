package in.co.sunrays.test;
//PAllavi
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.co.sunrays.Mobile;

public class TestMobile {
	public static void main(String[] args) {
		
		Mobile m = new Mobile();
		m.setId(5);
		m.setName("Red GIO");
		m.setColor("Blue");
		
		/*Mobile m1= new Mobile();
		m1.setId(4);
		m1.setName("BlackBerry");
		m1.setColor("Maroon");
		*/
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		//s.save(m);
		//s.merge(m1);
		//s.update(m1);  //NON-Unique Object Exception
		//s.update(m);
		tx.commit();
		s.close();
		s.update(m); //<------ dirty Checking-------->
	}

}
