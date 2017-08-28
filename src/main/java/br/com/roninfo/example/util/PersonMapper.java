package br.com.roninfo.example.util;

/**
 * Created by roninfo on 28/08/17.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper {
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setFirstName(rs.getString("firstName"));
        person.setLastName(rs.getString("lastName"));
        person.setSchool(rs.getString("school"));
        person.setRollNumber(rs.getInt("rollNumber"));
        return person;
    }
}
