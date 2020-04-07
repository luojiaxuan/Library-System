package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 数据库操作封装类
 */
public class DBUtil {
	
	Connection conn = null;
	Statement stat = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	private static final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=stu_library";
	private static final String userName="sa"; 
	private static final String pwd="ljx991108";
	
	public DBUtil(){}
	
	//test
//	public static void main(String args[]) {
//		DBUtil db = new DBUtil();
//		db.getConn();
//		ResultSet rs;
//		try {
//			rs = db.query("select * from Students");
//			while(rs.next()) {
//				System.out.println(rs.getString("SPwd"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	//连接到数据库
	public Connection getConn(){
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(URL, userName, pwd);
			//System.out.println("加载驱动成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	//查询并返回查询结果
	public ResultSet query(String sql){
		try {
			conn = getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//ִ更新
		public void update(String sql){
			try {
				conn = getConn();
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//更新ִ
				public void update(String sql,String[] args){
					try {
						conn=getConn();
						pstat = conn.prepareStatement(sql);
						for (int i = 0; i < args.length; i++) {
							pstat.setString(i+1,args[i]);
						}
						pstat.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	
	//删除操作
	public void delete(String sql){
		try {
			conn = getConn();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭数据库
	public void close(){
		
			try {
				if (rs !=null) {rs.close();}
				if(stat!=null){stat.close();}
				if(pstat!=null){pstat.close();}
				if(conn!=null){conn.close();}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
