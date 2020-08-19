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
import com.aem.aemtraining.core.dbutil.DatabaseConnectionHelper;
import com.aem.aemtraining.core.service.EmployI;
import com.aem.aemtraining.core.service.SightlySerivceInterface;

@Component(immediate = true, service = EmployI.class)
public class EmployImpl implements EmployI {

	private static Logger log = LoggerFactory.getLogger(EmployImpl.class);

	@Reference
	private DatabaseConnectionHelper connetionHelper;

	Connection con = null;
	PreparedStatement pstmt = null;

	@Override
	public boolean registerEmployeeDetails(Employees emps) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		log.info("---registerEmployeeDetails Invoked----");
		String sqlQuery = "insert into employ values(?,?,?,?)";
		boolean flag = false;
		try {
			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, emps.getName());
			pstmt.setString(2, emps.getAge());
			pstmt.setString(3, emps.getEmail());
			pstmt.setString(4, emps.getWeight());

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

		log.info("---registerEmployeeDetails End----");

		return flag;

	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub

		log.info("---getAllEmployees Invoked----");
		String sqlQuery = "select * from employ";
		boolean flag = false;
		ResultSet rs = null;
		List<Employees> list = null;
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);

			rs = pstmt.executeQuery();

			list = new ArrayList<Employees>();

			while (rs.next()) {

				Employees emps = new Employees();
				emps.setName(rs.getString(1));
				emps.setAge(rs.getString(2));
				emps.setEmail(rs.getString(3));
				emps.setWeight(rs.getString(4));
				list.add(emps);

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
		log.info("---getAllEmployees Method End----");
		return list;

	}

	@Override
	public boolean loginEmploye() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(String name,String age, String email, String weight) {
		log.info("---updateEmployeeDetails started----");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "update employ set age=?,email=?,weight=? where name=?";
		log.info("---updateEmployeeDetails after sqlquery----");
		boolean b = false;
		
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);
			log.info("---updateEmployeeDetails after preparestatement----");
			pstmt.setString(1, age);
			pstmt.setString(2, email);
			pstmt.setString(3, weight);
			pstmt.setString(4, name);

			int i = pstmt.executeUpdate();
			log.info("---updateEmployeeDetails after execute method----");
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

	}

	@Override
	public boolean deleteEmployee(String name) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "delete from employ where name=?";
		boolean b = false;
		try {

			con = connetionHelper.getDataBaseConnection("student");
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, name);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				b = true;

				log.info("Record Deleted Sucessfully");
			} else {
				b = false;

				log.info("From Delet Method-----OOPs !! Try Again ");
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

		return b;

	}

}
