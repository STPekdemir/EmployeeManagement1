package net.javaguides.emsbackend.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneratorClass  implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object){

        String prefix = "km";
        JdbcConnectionAccess con = session.getJdbcConnectionAccess();

        try {
            JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
            Connection connection = jdbcConnectionAccess.obtainConnection();
            Statement statement = connection.createStatement();
            String query = "select count(user_name) as Id from employees";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                Long id=resultSet.getLong(1)+101;
                String generatedId = prefix + Long.valueOf(id).toString();
                return generatedId;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }}

