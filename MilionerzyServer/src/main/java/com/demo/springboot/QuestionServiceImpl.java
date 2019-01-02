package com.demo.springboot;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.*;

@Service
public class QuestionServiceImpl implements QuestionService{



    public Question chooseQuestion(String number) throws IOException, ClassNotFoundException, SQLException {

        Question question=new Question();

        Connection conn = null;
        Statement stmt = null;

        Class.forName("org.sqlite.JDBC");

        // stworzenie obiektu łączenia
        conn = DriverManager.getConnection("jdbc:sqlite:/" + System.getProperty("user.dir") + "/src/main/resources/" + number + ".db");
        stmt = conn.createStatement();
        String sqlData = "SELECT COUNT(*) FROM questions";
        ResultSet rss = stmt.executeQuery(sqlData);

        int howManyLines = 0;
        while (rss.next()) {
            //Retrieve by column name
            howManyLines = rss.getInt(1);
        }
        System.out.println(howManyLines);
        int randomNum = (int)(Math.random() * howManyLines + 1);

        sqlData = "SELECT * FROM questions where id = " + randomNum;
        ResultSet rs = stmt.executeQuery(sqlData);
        while (rs.next()) {
            question.setQuestion( rs.getString("question"));
            question.setAnswer1( rs.getString("answA"));
            question.setAnswer2( rs.getString("answB"));
            question.setAnswer3( rs.getString("answC"));
            question.setAnswer4( rs.getString("answD"));
            question.setCorrect_Answer( rs.getString("correct"));
        }

        rs.close();
        stmt.close();
        conn.close();

        return question;

    }

    @Override
    public void addQuestion(Question question, int whichQuestionsSet) throws SQLException {
        String url = "jdbc:sqlite:/" + System.getProperty("user.dir") + "/src/main/resources/" + whichQuestionsSet + ".db";
        Connection conn = DriverManager.getConnection(url);
        String sql = "INSERT INTO questions (question, answA, answB, answC, answD, correct) VALUES (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, question.getQuestion());
        preparedStmt.setString(2, question.getAnswer1());
        preparedStmt.setString(3, question.getAnswer2());
        preparedStmt.setString(4, question.getAnswer3());
        preparedStmt.setString(5, question.getAnswer4());
        preparedStmt.setString(6, question.getCorrect_Answer());
        // execute the preparedstatement
        preparedStmt.execute();
        preparedStmt.close();
        conn.close();
    }

}
