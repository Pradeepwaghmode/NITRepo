package com.nt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("EmpDAO")
public class EmpDAO {

	private final String GET_EMP_COUNT="SELECT COUNT(*) FROM ACCOUNT";
	
	@Autowired
	private DataSource ds;
	
		public int getEmpCount() throws Exception{
			System.out.println(ds.getClass());
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_EMP_COUNT);
			ResultSet st=ps.executeQuery();
			
			st.next();
			int count =st.getInt(1);
		st.close();
		ps.close();
		con.close();
		
			
			return count;
		}
	
}
