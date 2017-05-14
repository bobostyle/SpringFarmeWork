package org.smart4j.chapter2.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.smart4j.chapter2.model.Business;

/**
 * BusinessMapper.java
 * 2017年5月13日上午10:52:19
 * @author cbb
 * TODO 
 */
public interface BusinessMapper {
	
	public void insert(Business business);
	public void insertBatch(List<Business> business);
	
	@Select("SELECT * FROM business WHERE id = #{id}")
	public Business selectById(long id);
	
	@Select("SELECT * FROM business WHERE key = #{key}")
	public Business selectByPrimKey(String key);
}
