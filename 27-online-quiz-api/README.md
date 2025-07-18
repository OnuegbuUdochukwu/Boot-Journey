# 🧠 Online Quiz API

A simple Spring Boot REST API that allows users to create quizzes, submit answers, and receive results with detailed feedback.

---

## ✅ Features

- Create and manage quizzes with multiple questions
- Submit answers and get score result
- Detailed analysis of each submitted answer (correct/incorrect)
- In-memory data storage (no database)

---

## 🚀 API Endpoints

### 📌 Create a Quiz

```http
POST /api/quizzes
{
  "title": "Basic Math Quiz",
  "questions": [
    {
      "text": "What is 5 + 3?",
      "options": ["6", "7", "8", "9"],
      "correctOption": 2
    },
    {
      "text": "What is 10 - 4?",
      "options": ["6", "7", "5", "4"],
      "correctOption": 0
    }
  ]
}
```
And Others >>>

# 🛠 Technologies Used
- Java 17+
- Spring Boot
- RESTful API
- Postman (for testing)
- In-memory storage (List<>)

# 🧪 Sample Postman Tests
- ✅ Create quiz
- 📥 Submit answers to quiz ID
- 🧾 Get result analysis for quiz ID
- ❌ Submit with fewer/more options (expect 400/empty response)
- 🗑️ Delete quiz and verify retrieval fails

# 📁 Project Structure
```
└── src
    └── main
        └── java
            └── com.codewithudo.onlinequizapi
                ├── controller
                ├── model
                └── service
```

# 📄 What Each Class Does
| File                     | Type       | Description                                                                          |
|--------------------------|------------|--------------------------------------------------------------------------------------|
| QuizController.java      | Controller | Handles HTTP requests and delegates to service                                       |
| QuizService.java         | Service    | Core business logic: create, submit, score, analyze, delete                        |
| Quiz.java                | Model      | Represents a quiz with ID, title, and list of questions                             |
| Question.java            | Model      | Represents a quiz question, its options, and the correct option                     |
| AnswerSubmission.java    | Model      | Represents a user submission (list of selected option indices)                      |
| QuizResult.java          | Model      | Encapsulates result of a quiz: total, correct, score                                |

# 🧠 Logic Flow Summary
1. Client sends a quiz with questions and correct options.
2. Quiz is stored in memory with auto-generated IDs.
3. User submits answer indices for a quiz.
4. System checks correctness, computes score, and returns a result object.
5. Optionally, a breakdown of each answer is provided via result-analysis.

# ✨ Future Enhancements
- Store quizzes and submissions in a database (e.g. PostgreSQL, MySQL)
- Add user authentication and result history
- Support for timed quizzes
- Pagination and search features

# 🧑‍💻 Author
**CodeWithUdo**