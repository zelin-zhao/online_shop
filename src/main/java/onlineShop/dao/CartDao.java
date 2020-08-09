package onlineShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import onlineShop.model.Cart;

@Repository
public class CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Cart getCartById(int cartId) {
		Cart cart = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			cart = (Cart) session.get(Cart.class, cartId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return cart;
	}
}

