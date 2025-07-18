package com.codewithudo.onlinequizapi.service;

import com.codewithudo.onlinequizapi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    private final List<Quiz> quizzes = new ArrayList<>();
    private int quizIdCounter = 1;
    private int questionIdCounter = 1;

    public Quiz createQuiz(Quiz quiz) {
        quiz.setId(quizIdCounter++);
        quiz.getQuestions().forEach(q -> q.setId(questionIdCounter++));
        quizzes.add(quiz);
        return quiz;
    }

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Optional<Quiz> getQuizById(int id) {
        return quizzes.stream().filter(q -> q.getId() == id).findFirst();
    }

    public Optional<QuizResult> submitAnswers(int quizId, AnswerSubmission submission) {
        Optional<Quiz> quizOpt = getQuizById(quizId);
        if (quizOpt.isEmpty()) return Optional.empty();

        Quiz quiz = quizOpt.get();
        List<Question> questions = quiz.getQuestions();
        List<Integer> submitted = submission.getSelectedOptionIndices();

        if (submitted.size() != questions.size()) return Optional.empty();

        int correct = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (Objects.equals(questions.get(i).getCorrectOptionIndex(), submitted.get(i))) {
                correct++;
            }
        }

        double score = (correct * 100.0) / questions.size();
        return Optional.of(new QuizResult(questions.size(), correct, score));
    }

    public boolean deleteQuiz(int id) {
        return quizzes.removeIf(q -> q.getId() == id);
    }
}
