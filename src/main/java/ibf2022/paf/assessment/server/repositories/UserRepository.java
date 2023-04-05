package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.Utils;

// TODO: Task 3
@Repository 
public class UserRepository {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	public static final String SQL_FIND_CUSTOMER_BY_USERNAME = "select * from customer where username = ?";

	public static final String SQL_INSERT_USER = "insert into user(user_id, username, name,) values (?, ?, ?)";
	

    public Optional<User> findUserByUsername(String username) {
		

		SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_FIND_CUSTOMER_BY_USERNAME, username);
		if (rs.next())
			return Optional.empty();
        
		return Optional.of(Utils.toUser(rs));
	}

     public String insertUser(User user){
        
        String userId = UUID.randomUUID().toString().substring(0, 8);
        user.setUserId(userId);
        user.setUsername(user.getUsername());
		user.setName(user.getName());

        jdbcTemplate.update(SQL_INSERT_USER, user.getUserId(), user.getUsername(), user.getName());
        return userId;

        
                               
    }
}
