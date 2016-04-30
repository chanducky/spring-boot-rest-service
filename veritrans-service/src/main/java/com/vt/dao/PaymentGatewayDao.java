package com.vt.dao;

import java.util.List;

import com.vt.entity.VTServices;

public interface PaymentGatewayDao {

	/**
	 * @return List<VTServices>
	 */
	public List<VTServices> services( int page, String sortByRating);
	
	/**
	 * @param name
	 * @return List<VTServices>
	 */
	public List<VTServices> findByName(String name, int page, String sortByRating);

	/**
	 * @return Integer
	 */
	public Integer count();

}
