package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import java.util.ArrayList;
import java.util.Arrays;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		ArrayList<Student> student =  new ArrayList();
		int i = 0;
		
		for (int j=0; j<lines.length; j++) {
			Student newstudent = new Student(lines[j].split(",")[1].trim());
			if(studentExist(student,newstudent)) continue;
			student.add(newstudent);
			if(++i>=numOfStudents) break;
		}

		return student;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param student2
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> student2, Student student) {
		for(Student  student0 : student2) {
			if(student0 == null) break;
			if(student0.getName().equals(student.getName())) return true;
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		ArrayList<Course> course = new ArrayList();
		int i = 0;
		
		for (int j=0; j<lines.length; j++) {
			Course newcourse = new Course(lines[j].split(",")[2].trim());
			if(courseExist(course,newcourse)) continue;
			course.add(newcourse);
			if(++i>=numOfCourses) break;
		}

		return course;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param course2
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> course2, Course course) {
		
		for(Course  course0 : course2) {
			if(course0 == null) break;
			if(course0.getCourseName().equals(course.getCourseName())) return true;
		}
		return false;
	}

}
