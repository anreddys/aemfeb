package com.aem.aemtraining.core.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemtraining.core.bean.Employees;
import com.aem.aemtraining.core.bean.Student;
import com.aem.aemtraining.core.dbutil.DatabaseConnectionHelper;
import com.aem.aemtraining.core.service.StudentIface;

@Component(immediate=true,service=StudentIface.class)	
public class StdImpl implements StudentIface {
	
	private static Logger log = LoggerFactory.getLogger(StdImpl.class);
	//1 accesing connection osgi service
	@Reference
	private DatabaseConnectionHelper connetionHelper;
	Connection con = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public boolean Stdregi(String name, String Address, String email, String Password, String Telephone) {
		// TODO Auto-generated method stub
		log.info("---registerstudentDetails Invoked----");
		String sqlQuery = "insert into student values(?,?,?,?,?)";
		log.info("---registerstudentDetails after sql ----");
		boolean flag = false;
		try {
			//2 by using refernce variable we r calling connection method(getDataBaseConnection) datasource name(student)
			con = connetionHelper.getDataBaseConnection("student");
			//3  exectue method(sqlQuery)by using prepareStatement object we r setting our data
			pstmt = con.prepareStatement(sqlQuery);
			log.info("---registerstudentDetails after preparestatement----");
			pstmt.setString(1,name );
			pstmt.setString(2, Address);
			pstmt.setString(3, email);
			pstmt.setString(4, Password);
			pstmt.setString(5, Telephone);
			
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;

				log.info("Record Inserted Sucessfully");
			} else {
				flag = false;

				log.info("OOPs !! Try Again ");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		log.info("---registerstudentDetails End----");

		return flag;




	}


	@Override
	public boolean Stdupate(String name, String Address, String email, String Password, String Telephone) {
		// TODO Auto-generated method stub
		log.info("---updatestudentDetails started----");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "update student set Address=?,email=?,Password=?,Telephone=? where name=?";
		log.info("---updatestudentDetails after sqlquery----");
		boolean b = false;
		
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);
			log.info("---updateEmployeeDetails after preparestatement----");
			pstmt.setString(1,name );
			pstmt.setString(2, Address);
			pstmt.setString(3, email);
			pstmt.setString(4, Password);
			pstmt.setString(5, Telephone);

			int i = pstmt.executeUpdate();
			log.info("---updatestudentDetails after execute method----");
			if (i == 1) {
				b = true;

				log.info("Record Updated Sucessfully");
			} else {
				b = false;

				log.info("Form Update Method -------OOPs !! Try Again ");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		log.info("---updateEmployeeDetails End----");
		return b;
		//return false;
	}


	@Override
	public boolean StuDelete(String name) {
		// TODO Auto-generated method stub

		log.info("---updatestudentDetails started----");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "delete from student where name=?";
		log.info("---deletestudentDetails after sqlquery----");
		boolean b = false;
		
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);
			log.info("---deletestudentDetails after preparestatement----");
			pstmt.setString(1,name );
			

			int i = pstmt.executeUpdate();
			log.info("---deletestudentDetails after execute method----");
			if (i == 1) {
				b = true;

				log.info("Record deleted Sucessfully");
			} else {
				b = false;

				log.info("Form delete Method -------OOPs !! Try Again ");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		log.info("---updateEmployeeDetails End----");
		return b;
		//return false;

	}


	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		log.info("---getAllstudent Invoked----");
		String sqlQuery = "select * from Student";
		boolean flag = false;
		ResultSet rs = null;
		List<Student> list = null;
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);

			rs = pstmt.executeQuery();
			//array list obj creation
			list = new ArrayList<Student>();

			while (rs.next()) {
//bean obj creation
				Student stu = new Student();
				stu.setName(rs.getString(1));
				stu.setAddress(rs.getString(2));
				stu.setEmail(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setTelephone(rs.getString(5));
				//adding bean obj to list
				list.add(stu);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		log.info("---getAllStudent Method End----");
		return list;	
	}


	

}
