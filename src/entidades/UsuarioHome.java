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
 * Home object for domain model class Usuario.
 * @see entidades.Usuario
 * @author Hibernate Tools
 */
public class UsuarioHome {

	private static final Logger logger = Logger.getLogger(UsuarioHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Usuario transientInstance) {
		logger.log(Level.INFO, "persisting Usuario instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuario instance) {
		logger.log(Level.INFO, "attaching dirty Usuario instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuario instance) {
		logger.log(Level.INFO, "attaching clean Usuario instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Usuario persistentInstance) {
		logger.log(Level.INFO, "deleting Usuario instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Usuario merge(Usuario detachedInstance) {
		logger.log(Level.INFO, "merging Usuario instance");
		try {
			Usuario result = (Usuario) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Usuario findById(int id) {
		logger.log(Level.INFO, "getting Usuario instance with id: " + id);
		try {
			Usuario instance = (Usuario) sessionFactory.getCurrentSession().get("entidades.Usuario", id);
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

	public List<?> findByExample(Usuario instance) {
		logger.log(Level.INFO, "finding Usuario instance by example");
		try {
			@SuppressWarnings("deprecation")
			List<?> results = sessionFactory.getCurrentSession().createCriteria("entidades.Usuario")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
