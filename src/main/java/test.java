import com.ndt.entity.AdministratorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
		AdministratorEntity admin = (AdministratorEntity) applicationContext.getBean("admin");
		System.out.println(admin.getAdminid()+" "+admin.getLoginname()+" "+admin.getSecret());

		Configuration configuration = new Configuration().configure("META-INF/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session s = sessionFactory.openSession();
		String hql = "from AdministratorEntity as admin";
		Query query = s.createQuery(hql);
		List list = query.list();
		for(Object a:list){
			admin = (AdministratorEntity)a;
			System.out.println(admin.getAdminid()+" "+admin.getLoginname()+" "+admin.getSecret());
		}
	}
}
