package progress;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

public class testupdate {
    Scanner input = new Scanner(System.in);

    private static boolean userExists(String userId) {
        String checkQuery = "SELECT COUNT(*) FROM User WHERE id = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // User exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // User does not exist
    }

    private static boolean instanceExists(String instanceId) {
        String checkQuery = "SELECT COUNT(*) FROM Enrollment WHERE course_instance_id = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setString(1, instanceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Instance exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // Instance does not exist
    }

    private static boolean courseExists(String shortName) {
        String checkQuery = "SELECT COUNT(*) FROM Course WHERE short_name = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setString(1, shortName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Course exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // Course does not exist
    }

    private static boolean quizExists(int quizId) {
        String checkQuery = "SELECT COUNT(*) FROM Quizz WHERE id = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Quiz exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // Quiz does not exist
    }

    private static boolean assignmentExists(int assignmentId) {
        String checkQuery = "SELECT COUNT(*) FROM Assignment WHERE id = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setInt(1, assignmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Assignment exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // Assignment does not exist
    }

    private static boolean questionExists(int questionId, int quizzId) {
        String checkQuery = "SELECT COUNT(*) FROM Question WHERE id = ? AND quizz_id = ?;";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(checkQuery)) {
            stmt.setInt(1, questionId);
            stmt.setInt(2, quizzId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Question exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false; // Question does not exist
    }

    public int updateFirstName() throws SQLException {
        System.out.println("Enter the user id: ");
        String id = input.nextLine();

        if (userExists(id)) {
            System.out.println("User exists");
            System.out.println("Enter the new first name: ");
            String firstName = input.nextLine();

            String userQuery = "UPDATE User u SET u.first_name = ? WHERE u.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, firstName);
                stmt.setString(2, id);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("User does not exist");
            return 0;
        }
    }

    public int updatelastName() throws SQLException {
        System.out.println("Enter the user id: ");
        String id = input.nextLine();

        if (userExists(id)) {
            System.out.println("User exists");
            System.out.println("Enter the new last name: ");
            String lastName = input.nextLine();

            String userQuery = "UPDATE User u SET u.last_name = ? WHERE u.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, lastName);
                stmt.setString(2, id);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("User does not exist");
            return 0;
        }
    }

    public int updateAddress() throws SQLException {
        System.out.println("Enter the user id: ");
        String id = input.nextLine();

        if (userExists(id)) {
            System.out.println("User exists");
            System.out.println("Enter the new address: ");
            String address = input.nextLine();

            String userQuery = "UPDATE User u SET u.address = ? WHERE u.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, address);
                stmt.setString(2, id);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("User does not exist");
            return 0;
        }
    }

    public int updatePassword() throws SQLException {
        System.out.println("Enter the user id: ");
        String id = input.nextLine();

        if (userExists(id)) {
            System.out.println("User exists");
            System.out.println("Enter the new password: ");
            String password = input.nextLine();

            String userQuery = "UPDATE User u SET u.password = ? WHERE u.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, password);
                stmt.setString(2, id);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("User does not exist");
            return 0;
        }
    }

    public int updatePhoneNumber() throws SQLException {
        System.out.println("Enter the user id: ");
        String id = input.nextLine();

        if (userExists(id)) {
            System.out.println("User exists");
            System.out.println("Enter the new phone number: ");
            String phoneNumber = input.nextLine();

            String userQuery = "UPDATE User u SET u.phone_number = ? WHERE u.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, phoneNumber);
                stmt.setString(2, id);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("User does not exist");
            return 0;
        }
    }

    public int updateClassForAllStudent() throws SQLException {
        System.out.println("Enter the instance id: ");
        String instanceId = input.nextLine();

        if (instanceExists(instanceId)) {
            System.out.println("Instance exists");
            System.out.println("Enter the new class id: ");
            String classId = input.nextLine();

            String userQuery = "UPDATE Enrollment e SET e.class_id = ? WHERE e.instance_id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, classId);
                stmt.setString(2, instanceId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Instance does not exist");
            return 0;
        }
    }

    public int updateAStudenttoDifferentClass() throws SQLException {
        System.out.println("Enter the student id: ");
        String studentId = input.nextLine();

        System.out.println("Enter the new class id: ");
        String classId = input.nextLine();

        String userQuery = "UPDATE Enrollment e SET e.class_id = ? WHERE e.student_id = ?";
        try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
            stmt.setString(1, classId);
            stmt.setString(2, studentId);
            int row = stmt.executeUpdate();
            MySQLConnection.closeConnection();
            return row;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return 0;
        }
    }

    public int updateFeeInCourse() throws SQLException {
        System.out.println("Enter the course short name: ");
        String shortName = input.nextLine();

        if (courseExists(shortName)) {
            System.out.println("Course exists");
            System.out.println("Enter the new fee: ");
            int fee = Integer.parseInt(input.nextLine());

            String userQuery = "UPDATE Course c SET c.fee = ? WHERE c.short_name = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setInt(1, fee);
                stmt.setString(2, shortName);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Course does not exist");
            return 0;
        }
    }

    public int updateDescriptionInCourse() throws SQLException {
        System.out.println("Enter the course short name: ");
        String shortName = input.nextLine();

        if (courseExists(shortName)) {
            System.out.println("Course exists");
            System.out.println("Enter the new description: ");
            String description = input.nextLine();

            String userQuery = "UPDATE Course c SET c.description = ? WHERE c.short_name = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, description);
                stmt.setString(2, shortName);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Course does not exist");
            return 0;
        }
    }

    public int updateTimeLimitInQuizz() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizId = Integer.parseInt(input.nextLine());

        if (quizExists(quizId)) {
            System.out.println("Quiz exists");
            System.out.println("Enter the new time limit (HH:MM:SS): ");
            String timeLimitStr = input.nextLine();
            Time timeLimit = Time.valueOf(timeLimitStr);

            String userQuery = "UPDATE Quizz q SET q.time_limit = ? WHERE q.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setTime(1, timeLimit);
                stmt.setInt(2, quizId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Quiz does not exist");
            return 0;
        }
    }

    public int updateDescriptionInQuizz() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizId = Integer.parseInt(input.nextLine());

        if (quizExists(quizId)) {
            System.out.println("Quiz exists");
            System.out.println("Enter the new description: ");
            String description = input.nextLine();

            String userQuery = "UPDATE Quizz q SET q.description = ? WHERE q.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, description);
                stmt.setInt(2, quizId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Quiz does not exist");
            return 0;
        }
    }

    public int updateTitleInQuizz() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizId = Integer.parseInt(input.nextLine());

        if (quizExists(quizId)) {
            System.out.println("Quiz exists");
            System.out.println("Enter the new title: ");
            String title = input.nextLine();

            String userQuery = "UPDATE Quizz q SET q.title = ? WHERE q.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, title);
                stmt.setInt(2, quizId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Quiz does not exist");
            return 0;
        }
    }

    public int updateDueDateInQuizz() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizId = Integer.parseInt(input.nextLine());

        if (quizExists(quizId)) {
            System.out.println("Quiz exists");
            System.out.println("Enter the new due date (YYYY-MM-DD): ");
            String dueDateStr = input.nextLine();
            Date dueDate = Date.valueOf(dueDateStr);

            String userQuery = "UPDATE Quizz q SET q.due = ? WHERE q.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setDate(1, dueDate);
                stmt.setInt(2, quizId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Quiz does not exist");
            return 0;
        }
    }

    public int updateInstructionInAssignment() throws SQLException {
        System.out.println("Enter the assignment id: ");
        int assignmentId = Integer.parseInt(input.nextLine());

        if (assignmentExists(assignmentId)) {
            System.out.println("Assignment exists");
            System.out.println("Enter the new instruction: ");
            String instruction = input.nextLine();

            String userQuery = "UPDATE Assignment a SET a.instruction = ? WHERE a.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, instruction);
                stmt.setInt(2, assignmentId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Assignment does not exist");
            return 0;
        }
    }

    public int updateTitleInAssignment() throws SQLException {
        System.out.println("Enter the assignment id: ");
        int assignmentId = Integer.parseInt(input.nextLine());

        if (assignmentExists(assignmentId)) {
            System.out.println("Assignment exists");
            System.out.println("Enter the new title: ");
            String title = input.nextLine();

            String userQuery = "UPDATE Assignment a SET a.title = ? WHERE a.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, title);
                stmt.setInt(2, assignmentId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Assignment does not exist");
            return 0;
        }
    }

    public int updateDescriptionInAssignment() throws SQLException {
        System.out.println("Enter the assignment id: ");
        int assignmentId = Integer.parseInt(input.nextLine());

        if (assignmentExists(assignmentId)) {
            System.out.println("Assignment exists");
            System.out.println("Enter the new description: ");
            String description = input.nextLine();

            String userQuery = "UPDATE Assignment a SET a.description = ? WHERE a.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, description);
                stmt.setInt(2, assignmentId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Assignment does not exist");
            return 0;
        }
    }

    public int updateDueDateInAssignment() throws SQLException {
        System.out.println("Enter the assignment id: ");
        int assignmentId = Integer.parseInt(input.nextLine());

        if (assignmentExists(assignmentId)) {
            System.out.println("Assignment exists");
            System.out.println("Enter the new due date (YYYY-MM-DD): ");
            String dueDateStr = input.nextLine();
            Date dueDate = Date.valueOf(dueDateStr);

            String userQuery = "UPDATE Assignment a SET a.due = ? WHERE a.id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setDate(1, dueDate);
                stmt.setInt(2, assignmentId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Assignment does not exist");
            return 0;
        }
    }

    public int updateQuestion() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizzId = Integer.parseInt(input.nextLine());

        System.out.println("Enter the question id: ");
        int questionId = Integer.parseInt(input.nextLine());

        if (questionExists(questionId, quizzId)) {
            System.out.println("Question exists");
            System.out.println("Enter the new question: ");
            String question = input.nextLine();

            String userQuery = "UPDATE Question q SET q.question = ? WHERE q.id = ? AND q.quizz_id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, question);
                stmt.setInt(2, questionId);
                stmt.setInt(3, quizzId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Question does not exist");
            return 0;
        }
    }

    public int updateMarkInQuestion() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizzId = Integer.parseInt(input.nextLine());

        System.out.println("Enter the question id: ");
        int questionId = Integer.parseInt(input.nextLine());

        if (questionExists(questionId, quizzId)) {
            System.out.println("Question exists");
            System.out.println("Enter the new mark: ");
            int mark = Integer.parseInt(input.nextLine());

            String userQuery = "UPDATE Question q SET q.mark = ? WHERE q.id = ? AND q.quizz_id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setInt(1, mark);
                stmt.setInt(2, questionId);
                stmt.setInt(3, quizzId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Question does not exist");
            return 0;
        }
    }

    public int updateCorrectAnswerInQuestion() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizzId = Integer.parseInt(input.nextLine());

        System.out.println("Enter the question id: ");
        int questionId = Integer.parseInt(input.nextLine());

        if (questionExists(questionId, quizzId)) {
            System.out.println("Question exists");
            System.out.println("Enter the new correct answer: ");
            String correctAnswer = input.nextLine();

            String userQuery = "UPDATE Question q SET q.correct_ans = ? WHERE q.id = ? AND q.quizz_id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, correctAnswer);
                stmt.setInt(2, questionId);
                stmt.setInt(3, quizzId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Question does not exist");
            return 0;
        }
    }

    public int updateOptionsInQuestion() throws SQLException {
        System.out.println("Enter the quiz id: ");
        int quizzId = Integer.parseInt(input.nextLine());

        System.out.println("Enter the question id: ");
        int questionId = Integer.parseInt(input.nextLine());

        if (questionExists(questionId, quizzId)) {
            System.out.println("Question exists");
            System.out.println("Enter the new options (as a JSON array): ");
            String options = input.nextLine();

            String userQuery = "UPDATE Question q SET q.options = ? WHERE q.id = ? AND q.quizz_id = ?";
            try (PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(userQuery)) {
                stmt.setString(1, options);
                stmt.setInt(2, questionId);
                stmt.setInt(3, quizzId);
                int row = stmt.executeUpdate();
                MySQLConnection.closeConnection();
                return row;
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Question does not exist");
            return 0;
        }
    }
}
