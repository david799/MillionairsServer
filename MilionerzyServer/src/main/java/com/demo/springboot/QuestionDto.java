package com.demo.springboot;

public class QuestionDto {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correct_Answer;


    public QuestionDto(String question,String answer1,String answer2,String answer3,String answer4,String correct_Answer){
        this.question=question;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.correct_Answer=correct_Answer;
    }

    public boolean checkIfCorrect(String answer){
        return answer.equals(this.correct_Answer);
    }
    public String getQuestion() {
        return this.question;
    }
    public String getAnswer1() {
        return this.answer1;
    }
    public String getAnswer2() {
        return this.answer2;
    }
    public String getAnswer3() {
        return this.answer3;
    }
    public String getAnswer4() {
        return this.answer4;
    }
    public String getCorrect_Answer() {
        return this.correct_Answer;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public void setAnswer1(String answer1){
        this.answer1 = answer1;
    }
    public void setAnswer2(String answer2){
        this.answer2 = answer2;
    }
    public void setAnswer3(String answer3){
        this.answer3 = answer3;
    }
    public void setAnswer4(String answer4){
        this.answer4 = answer4;
    }
    public void setCorrect_Answer(String correct_Answer){
        this.correct_Answer = correct_Answer;
    }
}

