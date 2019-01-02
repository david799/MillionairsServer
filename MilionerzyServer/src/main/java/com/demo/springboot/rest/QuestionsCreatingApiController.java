package com.demo.springboot.rest;

import com.demo.springboot.Question;
import com.demo.springboot.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dawidstec on 26.11.2017.
 */

@Controller
@RequestMapping("/api")
public class QuestionsCreatingApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionsCreatingApiController.class);

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/question/{number}", method = RequestMethod.GET)
    public ResponseEntity<Question> chooseQuestion(@PathVariable("number") String number) throws IOException, NullPointerException, SQLException, ClassNotFoundException {

        //LOGGER.info("wywołane");

        return new ResponseEntity<>(questionService.chooseQuestion(number), HttpStatus.CREATED);
    }

}
