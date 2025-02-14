package repository;

import database.DatabaseConnection;
import models.FAQ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FAQRepository {
    private Connection connection;

    public FAQRepository() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<FAQ> getFAQs() {
        List<FAQ> faqs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faq");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                faqs.add(new FAQ(resultSet.getInt("id"), resultSet.getString("question"), resultSet.getString("answer")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faqs;
    }
}
