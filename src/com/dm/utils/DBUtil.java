package com.dm.utils;

/**
 * 工具类
 */
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil<T> {
	private static ComboPooledDataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource();
	}

	/**
	 * 更新操作（增、删、改）
	 * @param sql（sql语句）
	 * @param arr（sql参数）
	 * @return
	 */
	public int executeUpdate(String sql, Object... arr) {
		QueryRunner qr = new QueryRunner(dataSource);
		int row = 0;
		try {
			row = qr.update(sql, arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	/**
	 * 获取单个对象
	 * @param <T>
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getOneObject(String sql, Object... arr) {
		QueryRunner qr = new QueryRunner(dataSource);
		T t = null;
		Type t1 = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		@SuppressWarnings("unchecked")
		Class<T> tClass = (Class<T>) t1;
		try {
			t = qr.query(sql, new BeanHandler<T>(tClass), arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	
	/**
	 * 查询多个对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getObjects(String sql, Object... params) {
		QueryRunner qr = new QueryRunner(dataSource);
		Type t = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		@SuppressWarnings("unchecked")
		Class<T> tClass = (Class<T>) t;
		List<T> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<T>(tClass), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
