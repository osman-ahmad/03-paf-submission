package ibf2022.paf.assessment.server;

import java.io.StringReader;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import ibf2022.paf.assessment.server.models.User;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    
    public static User toUser(SqlRowSet rs) {
		User user = new User();
		user.setUserId(rs.getString("user_id"));
		user.setUsername(rs.getString("username"));
		user.setName(rs.getString("name"));
		return user;
	}

    public static JsonObject toJson(String str) {
		JsonReader reader = Json.createReader(new StringReader(str));
		return reader.readObject();
	}

    public static JsonObject createError(String message) {
		return Json.createObjectBuilder()
			.add("error", message)
			.build();
	}
}
