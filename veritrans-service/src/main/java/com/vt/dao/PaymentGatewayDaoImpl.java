package com.vt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vt.entity.VTServices;


@Transactional
@Repository
public class PaymentGatewayDaoImpl implements PaymentGatewayDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @return Session
	 */
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.vt.dao.PaymentGatewayDao#services()
	 */
	@SuppressWarnings("unchecked")
	//@Transactional(readOnly=true)
	@Override
	public List<VTServices> services(int page,String sortByRating) {
		Criteria crt = getSession().createCriteria(VTServices.class);
		
		if("desc".equalsIgnoreCase(sortByRating)){
			crt.addOrder(Order.desc("rating"));
		}else{
			crt.addOrder(Order.asc("rating"));
		}
		if(page >0){
			crt.setFirstResult(3*(page-1));
		}
		crt.setMaxResults(3);

		return crt.list();
	}

	/* (non-Javadoc)
	 * @see com.vt.dao.PaymentGatewayDao#findByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<VTServices> findByName(String name, int page, String sortByRating) {
		
		Criteria crt = getSession().createCriteria(VTServices.class);
		crt.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		
		if("desc".equalsIgnoreCase(sortByRating)){
			crt.addOrder(Order.desc("rating"));
		}else{
			crt.addOrder(Order.asc("rating"));
		}
		if(page >0){
			crt.setFirstResult(3*(page-1));
		}
		crt.setMaxResults(3);
		return crt.list();
	}

	/* (non-Javadoc)
	 * @see com.vt.dao.PaymentGatewayDao#count()
	 */

	@Override
	@Transactional(readOnly=true)
	public Integer count() {
		Object countObj =  getSession().createCriteria(VTServices.class).setProjection(Projections.rowCount()).uniqueResult();

		if(countObj != null ){
			return	((Long)countObj).intValue();
		}
		return 0;
	}

}
