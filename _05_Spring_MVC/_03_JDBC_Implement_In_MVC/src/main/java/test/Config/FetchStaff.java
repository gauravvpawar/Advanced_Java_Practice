package test.Config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import test.Model.Staff;

public class FetchStaff implements RowMapper<Staff>
{

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Staff s1 = new Staff();
		s1.setSid(rs.getInt(1));
		s1.setSname(rs.getString(2));
		s1.setSemail(rs.getString(3));
		s1.setSpassword(rs.getString(4));
		s1.setScnfPassword(rs.getString(5));
		return s1;
	}

}
