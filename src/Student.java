import java.util.Date;

public class Student implements Comparable {

	private int id;
	private String fullName;
	private Date birthDate;
	private double avgMark;

	public Student(int id, String fullName, Date birthDate, double avgMark) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.avgMark = avgMark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;

		Student student = (Student) o;

		if (getId() != student.getId()) return false;
		if (Double.compare(student.getAvgMark(), getAvgMark()) != 0) return false;
		if (getFullName() != null ? !getFullName().equals(student.getFullName()) : student.getFullName() != null)
			return false;
		return getBirthDate() != null ? getBirthDate().equals(student.getBirthDate()) : student.getBirthDate() == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getId();
		result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
		result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
		temp = Double.doubleToLongBits(getAvgMark());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public int compareTo(Object o) {
		Student student = (Student) o;
		return this.getFullName().compareToIgnoreCase(student.getFullName());
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", birthDate=" + birthDate +
				", avgMark=" + avgMark +
				'}';
	}
}