package org.cupcake.dao;

import java.util.List;

import org.cupcake.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 根据用户id查询
	 */
	public User getUserById(int id) {

		String hql = "from User u where u.user_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, Integer.toString(id));
		return (User) query.uniqueResult();
	}

	/**
	 * 根据用户名查询
	 */
	public User getUserByName(String name) {

		String hql = "from User u where u.login_name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		return (User) query.uniqueResult();
	}

	/**
	 * 查询所有user
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 添加
	 */
	public boolean addUser(User user) {
		if (getUserByName(user.getLogin_name()) != null)
			return false;
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	/**
	 * 删除
	 */
	public boolean delUser(String id) {

		String hql = "delete User u where u.user_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	/**
	 * 更新
	 */
	public boolean updateUser(User user) {
		String hql = "update User u set u.login_name = ?,u.password=? where u.user_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getLogin_name());
		query.setString(1, user.getPassword());
		query.setString(2, Integer.toString(user.getUser_id()));
		return (query.executeUpdate() > 0);
	}
}
