package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// INSERT...........................................

	public boolean insertUser(User user) {

		boolean status = false;

		try {

			String query = "insert into users(name,email,gender,city) values(?,?,?,?)";

			int count = jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getGender(), user.getCity());

			if (count > 0) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	// UPDATE......................................

	public boolean updateUser(User user) {

		boolean status = false;

		try {

			String query = "update users set name = ?, gender = ?, city = ? where email = ?";
			int count = jdbcTemplate.update(query, user.getName(), user.getGender(), user.getCity(), user.getEmail());

			if (count > 0) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {

			status = false;
			e.printStackTrace();
		}

		return status;

	}

	// DELETE...........................................

	public boolean deleteUserByEmail(User user) {

		boolean status = false;

		try {

			String query = "delete from users where email = ?";

			int count = jdbcTemplate.update(query, user.getEmail());

			if (count > 0) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {

			status = false;
			e.printStackTrace();
		}

		return status;

	}

	// GET ONE USER.........................
	
	
	public User getUserByEmail(String email) {

		String query = "select * from users where email = ?"; 

		return jdbcTemplate.queryForObject(query, new UserRowMapper(),email);

	}
	
	// GET ALL USER.........................

	public List<User> getAllUsers(){
		
		String query = "select * from users";
		
		return jdbcTemplate.query(query, new UserRowMapper());
		
	}

	public static final class UserRowMapper implements RowMapper<User>

	{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));

			return user;
		}

	}
}
