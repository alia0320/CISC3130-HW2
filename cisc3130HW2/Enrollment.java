package cisc3130HW2;

public class Enrollment {
	
	private String enrollmentId;
	private String studentId;
	private String courseCode;
	private String grade = "C"; // not sure whether this should be a string // update: nvm it is since it can be A+ or C+
	private String semester;
	public static int enrollmentCount = 0; // will need to be set to public since if block does not prevent setEnrollmentId from
	// being executed
	
	public Enrollment(String studentId, String courseCode, String semester) {
		this.studentId = studentId;
		this.courseCode = courseCode;
		this.semester = semester;
		setEnrollmentId();
	}
	
	public String getEnrollmentId() {
		return this.enrollmentId;
	}
	
	/*
	 * unique identifier is automatically made by this method. concatenate the letter E with the number of enrollments at 
	 * the time of the enrollment being made. keep the ID at least 4 digits
	 */
	
	public void setEnrollmentId() {
		enrollmentCount++;
		if (enrollmentCount / 100 > 0) {
			this.enrollmentId = "E" + enrollmentCount;
		} else if (enrollmentCount/100 == 0 && enrollmentCount/10 > 0) {
			this.enrollmentId = "E0"  + enrollmentCount;
		}  else {
			this.enrollmentId = "E00" + enrollmentCount;
		}
		System.out.println("Enrollment created! ID: " + getEnrollmentId());
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	/*
	 * setGrade will utilize a switch so that the double conversion will be way easier to do
	 */
	
	public void setGrade(String grade) {
		switch(grade) {
		case "A":
			this.grade = grade;
			break;
		case "B":
			this.grade = grade;
			break;
		case "C":
			this.grade = grade;
			break;
		case "D":
			this.grade = grade;
			break;
		case "F":
			this.grade = grade;
			break;
		default:
			System.out.println("Not a valid grade!");
			this.grade = "C"; // let's be fair to the student
		}
	}
	
	public String getSemester() {
		return this.semester;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	@Override
	public String toString() {
		return "Enrollment ID: " + this.enrollmentId + "\tStudent ID: " + this.studentId + "\tCourse Code: " + this.courseCode +
				"\tGrade: " + this.grade + "\tSemester: " + this.semester;
	}
	
	public double getGradePoints() {
		double points = 0.0;
		switch (this.grade) {
		case "A":
			points = 4.0;
			break;
		case "B":
			points = 3.0;
			break;
		case "C":
			points = 2.0;
			break;
		case "D":
			points = 1.0;
			break;
		case "F":
			points = 0.0;
			break;
		}
		return points;
	}
	
	public boolean isPassing() {
		if (getGradePoints() >= 1.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * making the equals method to prevent the Manager from making duplicate enrollments. it checks equality of two
	 * Enrollments by seeing whether they share the same enrollmentId
	 */
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Enrollment)) {
			return false;
		}
		Enrollment obj2 = (Enrollment) other;
		if (this.enrollmentId.equals(obj2.getEnrollmentId())) {
			return true;
		} else {
			return false;
		}
	}
}
