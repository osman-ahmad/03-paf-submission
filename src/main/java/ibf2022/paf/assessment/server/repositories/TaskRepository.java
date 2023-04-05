package ibf2022.paf.assessment.server.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;
// 

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
	private JdbcTemplate jdbcTemplate;

    public static final String SQL_INSERT_TASK = "insert into task(description, priority, due_date, user_id) values (?, ?, ?, ?)";

    

    
    public int insertTask(Task task){

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(SQL_INSERT_TASK, new String[] {"task_id"});
                ps.setString(1, task.getDescription());
                ps.setInt(2, task.getPriority());
                ps.setDate(3, Date.valueOf(task.getDueDate()));
                ps.setString(4, task.getUserId());
                return ps;
            }
           
        };
        jdbcTemplate.update(psc, generatedKeyHolder);

        Integer returnedId = generatedKeyHolder.getKey().intValue();


        return returnedId;
       
        
    }

    
       
}
