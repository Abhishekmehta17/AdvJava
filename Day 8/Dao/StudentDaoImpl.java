package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String insertStudentDetails(Student stud) {
		// stud: transient
		String msg = "Adding student details failed";
		// get session from session factory
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(stud);
			tx.commit();
			msg = "Added Student details with ID= " + stud.getPid();
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
		}
		return msg;
	}

	@Override
	public String studentLogin(String email, String pwd) {
		String msg = "Student login Failed!!!!";
		Student student = null;
		String jpql = "select s from Student s where s.email=:em and s.password=:pass";
		// 1. get session from sf
		Session session = getFactory().getCurrentSession();
		// 2.begin tx
		Transaction tx = session.beginTransaction();
		try {
			student = session.createQuery(jpql, Student.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
			msg = "Student has logged in succesfully :" + student.getFirstName() + " " + student.getLastName();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<String> getNameOfStudentByType(Course studentType) {
		List<String> name = null;
		String jpql = "select s.firstName from Student s where s.enrolledCourse=:ty";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2.begin a tx
		Transaction tx = session.beginTransaction();
		try {
			name = session.createQuery(jpql, String.class).setParameter("ty", studentType).getResultList();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return name;
	}

	@Override
	public Student updateStudentCourse(Integer pid, Course course) {
		//msg
		String msg = "student Course updataion Failed!!!!!";
		
		//null
		Student std = null;
		//session
		Session session = getFactory().getCurrentSession();
		
		//Transaction
		Transaction tx = session.beginTransaction();
		
		//try-catch
		try {
			//std=sess
			std=session.get(Student.class, pid);
			std.setCourse(course);
			tx.commit();
			System.out.println("Course is update successfully");
			
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
			throw e;
		}
		//return 
		return std;
	}
	
}
