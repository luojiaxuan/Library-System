package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.io.IOException;
import com.db.DBUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class do_delete_book extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//int res = JOptionPane.showConfirmDialog(null, "是否继续操作", "是否继续", JOptionPane.YES_NO_OPTION);
		//System.out.println("进来");
		String json = ReadRequestJson.readJSONString(request);
		JsonObject object = new JsonParser().parse(json).getAsJsonObject();
		String book_no = object.get("book_no").getAsString();
		
		DBUtil db = new DBUtil();
		String sql="select * from borrowed_book where book_no='"+book_no+"'";
		if(db.query(sql)!=null) {
			//说明有外借，不能直接删除
			sql="delete from borrowed_book where book_no='"+book_no+"'";
			db.delete(sql);//先删除在借表记录
			sql="delete from Book where book_no='"+book_no+"'";
			db.delete(sql);//再删book表
		}
		else {
			//直接删除book数据
			sql ="delete from Book where book_no='"+book_no+"'";
			db.delete(sql);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
