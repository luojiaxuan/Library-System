package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.StudentsBean;
import com.db.DBUtil;

/*
 * StudentDAO类
 * 通过此类将Students数据表与web的Student类联系起来
 */
public class StudentDAO {
	//通过借书卡号获得学生实例
	public StudentsBean getStudentByScardNo(String Scard_no){
		DBUtil db=new DBUtil();
		String sql="select * from Students where Scard_no like '%"+Scard_no+"%'";
		ResultSet rs=db.query(sql);
		try {
			if(rs.next()){
				StudentsBean stu=new StudentsBean();
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setGrade(rs.getString("grade"));
				stu.setSpwd(rs.getString("Spwd"));
				return stu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
