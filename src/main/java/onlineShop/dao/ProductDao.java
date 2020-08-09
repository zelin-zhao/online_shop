package onlineShop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import onlineShop.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e)  {
			e.getStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteProduct(int productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Product product = (Product) session.get(Product.class, productId);
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e)  {
			e.getStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateProduct(Product product) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
		} catch (Exception e)  {
			e.getStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Product getProductById(int productId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Product product = session.get(Product.class, productId);
			return product;
		} catch (Exception e)  {
			e.getStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	
	public List<Product> getAllProducts() {
		Session session = null;
		List<Product> products = new ArrayList<Product>();
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
			Root<Product> root = criteriaQuery.from(Product.class);
			criteriaQuery.select(root);
			products = session.createQuery(criteriaQuery).getResultList();
		} catch (Exception e)  {
			e.getStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return products;
	}
}
