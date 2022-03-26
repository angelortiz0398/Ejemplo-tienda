package entidades;
// Generated 27 feb 2022 12:31:33 by Hibernate Tools 5.6.3.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class DetalleVenta.
 * @see entidades.DetalleVenta
 * @author Hibernate Tools
 */
public class DetalleVentaHome {

	private static final Logger logger = Logger.getLogger(DetalleVentaHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DetalleVenta transientInstance) {
		logger.log(Level.INFO, "persisting DetalleVenta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DetalleVenta instance) {
		logger.log(Level.INFO, "attaching dirty DetalleVenta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(DetalleVenta instance) {
		logger.log(Level.INFO, "attaching clean DetalleVenta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(DetalleVenta persistentInstance) {
		logger.log(Level.INFO, "deleting DetalleVenta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public DetalleVenta merge(DetalleVenta detachedInstance) {
		logger.log(Level.INFO, "merging DetalleVenta instance");
		try {
			DetalleVenta result = (DetalleVenta) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public DetalleVenta findById(int id) {
		logger.log(Level.INFO, "getting DetalleVenta instance with id: " + id);
		try {
			DetalleVenta instance = (DetalleVenta) sessionFactory.getCurrentSession().get("entidades.DetalleVenta", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(DetalleVenta instance) {
		logger.log(Level.INFO, "finding DetalleVenta instance by example");
		try {
			@SuppressWarnings("deprecation")
			List<?> results = sessionFactory.getCurrentSession().createCriteria("entidades.DetalleVenta")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
