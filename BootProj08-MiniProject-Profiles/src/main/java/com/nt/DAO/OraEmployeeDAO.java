package com.nt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.modal.Employee;

@Repository("oraEmp")
@Profile({"uat","prod"})
public class OraEmployeeDAO implements IEmployeeDAO{
	private static final String GET_EMPLOYEES_BASED_ON_DESG = "SELECT  *  FROM REALTIMEDI_SPRING_EMPLOYEE WHERE DESG IN (?,?,?)";
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=======ORACLE========="+ds.getClass()+"============");
		System.out.println("EmployeeDAO.getEmpByDesg()");
		List<Employee> listEmps = new ArrayList();
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPLOYEES_BASED_ON_DESG);) {

			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					Employee emp = new Employee();

					emp.setEno(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setDesg(rs.getNString(3));
					emp.setNetSalary(rs.getFloat(6));

					listEmps.add(emp);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return listEmps;
	}

}
