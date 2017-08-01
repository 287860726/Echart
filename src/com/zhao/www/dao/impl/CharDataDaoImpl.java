package com.zhao.www.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.zhao.www.dao.BaseDao;
import com.zhao.www.dao.ICharDataDao;


public class CharDataDaoImpl extends BaseDao implements ICharDataDao{

	@Override
	public int getData(int restype) throws Exception{
		
		String sql = "select count(*) from resource where restype = ? and status > 0";
		
		this.OpenConncetion();
		PreparedStatement ps = this.connection.prepareStatement(sql);
		ps.setInt(1, restype);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int s = rs.getInt(1);
		System.out.println("资源数量：" + s);
		return s;
	}

}
