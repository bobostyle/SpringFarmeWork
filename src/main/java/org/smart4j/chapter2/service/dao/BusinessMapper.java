package org.smart4j.chapter2.service.dao;

import java.util.List;
import org.smart4j.chapter2.model.Business;

/**
 * BusinessMapper.java
 * 2017��5��13������10:52:19
 * @author cbb
 * TODO 
 */
public interface BusinessMapper {
	
	public void insertBusiness(Business business);
	public void insertBatchBusiness(List<Business> business);
	
	public Business selectBusinessByPrimKey(long id);
	
}
