package org.cupcake.dao;

import java.util.List;

import org.cupcake.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
	 * �����û�id��ѯ�û�
	 */
	public User getUserById(int id) {

		String hql = "from User u where u.user_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, Integer.toString(id));

		return (User) query.uniqueResult();
	}

	/**
	 * �����û���½����ѯ�û�
	 */
	public User getUserByName(String name) {

		String hql = "from User u where u.login_name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);

		return (User) query.uniqueResult();
	}

	/**
	 * ��ѯ�����û�
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	/**
	 * ����û�
	 */
	public boolean addUser(User user) {
		try{
		sessionFactory.getCurrentSession().save(user);
		
		}
		catch(Exception e){
			System.out.println("user name already existed");
			return false;
		}
		return true;
	}

	/**
	 * �����û�idɾ���û�
	 */
	public boolean delUser(String id) {

		String hql = "delete User u where u.user_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);

		return (query.executeUpdate() > 0);
	}

	/**
	 * �༭�û�
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
