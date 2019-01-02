package com.demo.springboot;

import java.io.IOException;
import java.sql.SQLException;

public interface QuestionService {

    Question chooseQuestion(String a) throws IOException, ClassNotFoundException, SQLException;
    void addQuestion(Question question, int whichQuestionsSet) throws SQLException;

}
