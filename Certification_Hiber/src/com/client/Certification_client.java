package com.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.reverse.CertificationTechnology;
import com.reverse.EmailTemplate;
import com.reverse.ExamQuestionMultipleAnswers;
import com.reverse.ExamQuestions;
import com.reverse.ExaminationSlot;
import com.reverse.PaymentDetails;
import com.reverse.Profile;
import com.reverse.SocialAuth;
import com.reverse.User;
import com.reverse.UserRole;
import com.reverse.UserScorecard;

public class Certification_client { 

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		 /*Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<CertificationTechnology> query = builder.createQuery(CertificationTechnology.class);
		Root<CertificationTechnology> root = query.from(CertificationTechnology.class);
		query.select(root);
		Query<CertificationTechnology> q = session.createQuery(query);
		List<CertificationTechnology> list = q.getResultList();*/
		//Displaying the tables data
		System.out.println("If there are values in DB they will be displayed here");
		System.out.println("Certification Technology");
		List<CertificationTechnology> li = session.createCriteria(CertificationTechnology.class).list();
		for (CertificationTechnology CT : li) {
			System.out.println(CT);
		}
		System.out.println("EmailTemplate");
		List<EmailTemplate> li1 = session.createCriteria(EmailTemplate.class).list();
		for (EmailTemplate CT : li1) {
			System.out.println(CT);
		}
		System.out.println("ExaminationSlot");
		List<ExaminationSlot> li2 = session.createCriteria(ExaminationSlot.class).list();
		for (ExaminationSlot CT : li2) {
			System.out.println(CT);
		}
		System.out.println("ExamQuestionMultipleAnswers");
		List<ExamQuestionMultipleAnswers> li3 = session.createCriteria(ExamQuestionMultipleAnswers.class).list();
		for (ExamQuestionMultipleAnswers CT : li3) {
			System.out.println(CT);
		}
		System.out.println("ExamQuestions");
		List<ExamQuestions> li4 = session.createCriteria(ExamQuestions.class).list();
		for (ExamQuestions CT : li4) {
			System.out.println(CT);
		}
		System.out.println("PaymentDetails");
		List<PaymentDetails> li5 = session.createCriteria(PaymentDetails.class).list();
		for (PaymentDetails CT : li5) {
			System.out.println(CT);
		}
		System.out.println("Profile");
		List<Profile> li6 = session.createCriteria(Profile.class).list();
		for (Profile CT : li6) {
			System.out.println(CT);
		}
		System.out.println("SocialAuth");
		List<SocialAuth> li7 = session.createCriteria(SocialAuth.class).list();
		for (SocialAuth CT : li7) {
			System.out.println(CT);
		}
		System.out.println("User");
		List<User> li8 = session.createCriteria(User.class).list();
		for (User CT : li8) {
			System.out.println(CT);
		}
		System.out.println("UserRole");
		List<UserRole> li9 = session.createCriteria(UserRole.class).list();
		for (UserRole CT : li9) {
			System.out.println(CT);
		}
		System.out.println("UserScorecard");
		List<UserScorecard> li10 = session.createCriteria(UserScorecard.class).list();
		for (UserScorecard CT : li10) {
			System.out.println(CT);
		}
	}

}
