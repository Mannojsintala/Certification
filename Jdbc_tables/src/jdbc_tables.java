import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	public class jdbc_tables {

		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/jdbc_certification";

		// Database credentials
		static final String USER = "manoj";
		static final String PASS = "manoj";

		public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");

				// STEP 4: Execute a query
				System.out.println("Creating table in given database...");
				stmt = conn.createStatement();

				// Set auto-commit to false
				conn.setAutoCommit(false);

				String sql = "CREATE TABLE user_role" + "(id INTEGER NOT NULL," + "role_name VARCHAR(30) DEFAULT NULL,"
						+ "PRIMARY KEY (id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE user" + "(id INTEGER NOT NULL, " + "role_id int(11) NOT NULL,"
						+ "status smallint(6) NOT NULL," + "email varchar(255) DEFAULT NULL,"
						+ "username varchar(255) DEFAULT NULL," + "password varchar(255) DEFAULT NULL,"
						+ "auth_key varchar(255) DEFAULT NULL," + "access_token varchar(255) DEFAULT NULL,"
						+ "logged_in_ip varchar(255) DEFAULT NULL," + "logged_in_at timestamp NULL DEFAULT NULL,"
						+ "created_ip varchar(45) DEFAULT NULL," + "created_at timestamp NULL DEFAULT NULL,"
						+ "updated_at timestamp NULL DEFAULT NULL," + "banned_at timestamp NULL DEFAULT NULL,"
						+ "banned_reason varchar(255) DEFAULT NULL," + "PRIMARY KEY (id),"
						+ "KEY user-role_id_idx (role_id),"
						+ "CONSTRAINT user_role_id FOREIGN KEY (role_id) REFERENCES user_role(id)) ";
				stmt.addBatch(sql);

				sql = "CREATE TABLE profile" + "(id int(11) NOT NULL," + "first_name varchar(45) DEFAULT NULL,"
						+ "last_name varchar(45) DEFAULT NULL," + "gender varchar(20) DEFAULT NULL,"
						+ "user_id int(11) DEFAULT NULL," + "PRIMARY KEY (id)," + "KEY profile_user_table_idx (user_id),"
						+ "CONSTRAINT profile_user_table FOREIGN KEY (user_id) REFERENCES user(id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE certification_technology" + "(id int(11) NOT NULL,"
						+ "certification_name varchar(200)  DEFAULT NULL,"
						+ "certification_description varchar(200) DEFAULT NULL,"
						+ "certification_category varchar(45) DEFAULT NULL," + "PRIMARY KEY (id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE user_scorecard" + "(id int(11) NOT NULL,"
						+ "certification_result varchar(45) DEFAULT NULL,"
						+ "certification_score decimal(10,0) DEFAULT NULL," + "certification_id int(11) DEFAULT NULL,"
						+ "user_id int(11) DEFAULT NULL," + "PRIMARY KEY (id),"
						+ "KEY user_scorecard_user_id_idx (user_id),"
						+ "KEY user_scorecard_certification_id_idx (certification_id),"
						+ "CONSTRAINT user_scorecard_certification_id FOREIGN KEY (certification_id) REFERENCES certification_technology (id),"
						+ "CONSTRAINT user_scorecard_user_id FOREIGN KEY (user_id) REFERENCES user(id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE examination_slot" + "(id int(11) NOT NULL," + "Slot_time datetime DEFAULT NULL,"
						+ "certification_id int(11) DEFAULT NULL," + "user_id int(11) DEFAULT NULL," + "PRIMARY KEY (id),"
						+ "KEY examination_slot_user_id_idx (user_id),"
						+ "KEY examination_slot_certification_id_idx (certification_id),"
						+ "CONSTRAINT examination_slot_certification_id FOREIGN KEY (certification_id) REFERENCES certification_technology (id) ON DELETE NO ACTION ON UPDATE NO ACTION,"
						+ "CONSTRAINT examination_slot_user_id FOREIGN KEY (user_id) REFERENCES user (id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE payment_details" + "(id int(11) NOT NULL," + "user_id int(11) DEFAULT NULL,"
						+ "examination_slot_id int(11) DEFAULT NULL," + "payment_amount float DEFAULT NULL,"
						+ "currency varchar(50) DEFAULT NULL," + "PRIMARY KEY (id),"
						+ "KEY payment_details_user_id_idx (user_id),"
						+ "KEY payment_details_examination_slot_id_idx (examination_slot_id),"
						+ "CONSTRAINT payment_details_examination_slot_id FOREIGN KEY (examination_slot_id) REFERENCES examination_slot (id),"
						+ "CONSTRAINT payment_details_user_id FOREIGN KEY (user_id) REFERENCES user(id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE social_auth" + "(id int(11) NOT NULL," + "provider_name varchar(45) DEFAULT NULL,"
						+ "provider_response blob," + "provider_id int(11) DEFAULT NULL," + "user_id int(11) DEFAULT NULL,"
						+ "PRIMARY KEY (id)," + "KEY social_auth_user_id_idx (user_id),"
						+ "CONSTRAINT social_auth_user_id FOREIGN KEY (user_id) REFERENCES user (id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE email_template" + "(id int(11) NOT NULL," + "template_slug varchar(45) DEFAULT NULL,"
						+ "template_content blob," + "PRIMARY KEY (id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE exam_questions" + "(id int(11) NOT NULL,"
						+ "certification_type varchar(50) DEFAULT NULL,"
						+ "certification_question varchar(400) DEFAULT NULL,"
						+ "certification_answer_Id int(11) DEFAULT NULL," + "PRIMARY KEY (id))";
				// "KEY exam_questions_answer-id_idx (certification_answer_Id),"+
				// "CONSTRAINT exam_questions_answer-id FOREIGN KEY
				// (certification_answer_Id) REFERENCES
				// exam_question_multiple_answers(id))";
				stmt.addBatch(sql);

				sql = "CREATE TABLE exam_question_multiple_answers" + "(id int(11) NOT NULL,"
						+ "examination_answers varchar(45) DEFAULT NULL," + "examination_questions_id int(11) DEFAULT NULL,"
						+ "PRIMARY KEY (id),"
						+ "KEY exam_question_multiple_answers_questions_id_idx (examination_questions_id),"
						+ "CONSTRAINT exam_question_multiple_answers_questions_id FOREIGN KEY (examination_questions_id) REFERENCES exam_questions(id))";
				stmt.addBatch(sql);

				sql = "ALTER TABLE exam_questions"
						+ "ADD CONSTRAINT exam_questions_answer-id FOREIGN KEY (certification_answer_Id) REFERENCES exam_question_multiple_answers(id))";

				// Create an int[] to hold returned values
				int[] count = stmt.executeBatch();

				// Explicitly commit statements to apply changes
				conn.commit();
				// Clean-up environment
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}// end main

	}
