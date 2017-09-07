import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentGroup implements GroupOperationService {

    private Student[] students;

    public StudentGroup(int length) {
        this.students = new Student[length];
    }

    @Override
    public Student[] getStudents() {
        return students;
    }

    @Override
    public void setStudents(Student[] students) {
        if (students == null) {
            throw new IllegalArgumentException();
        }

        this.students = students;
    }

    @Override
    public Student getStudent(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        return students[index];
    }

    @Override
    public void setStudent(Student student, int index) {
        if (student == null || index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        students[index] = student;
    }

    @Override
    public void addFirst(Student student) {
        add(student, 0);
    }

    @Override
    public void addLast(Student student) {
        add(student, students.length);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(index);
        students = list.toArray(students);

    }

    @Override
    public void remove(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(student);
        students = list.toArray(students);
    }

    @Override
    public void removeFromIndex(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(index);
        students = list.toArray(students);
    }

    @Override
    public void removeFromElement(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(student);
        students = list.toArray(students);
    }

    @Override
    public void removeToIndex(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(index);
        students = list.toArray(students);
    }

    @Override
    public void removeToElement(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.remove(student);
        students = list.toArray(students);
    }

    @Override
    public void bubbleSort() {
        Collections.sort(new ArrayList<>(Arrays.asList(students)));
    }

    @Override
    public Student[] getByBirthDate(Date date) {
        Student[] std = null;
        if (date == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = Arrays.stream(students).filter(s -> s.getBirthDate().equals(date)).collect(Collectors.toList());
        std = list.toArray(std);
        return std;
    }

    @Override
    public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
        Student[] std = null;
        if (firstDate == null || lastDate == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = Arrays.stream(students).filter(s ->
                s.getBirthDate().after(firstDate)
                        && s.getBirthDate().before(lastDate)
        ).collect(Collectors.toList());
        std = list.toArray(std);
        return std;
    }

    @Override
    public Student[] getNearBirthDate(Date date, int days) {
        Student[] std = null;
        if (date == null) {
            throw new IllegalArgumentException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);

        Date firstDate = calendar.getTime();

        calendar.setTime(date);
        calendar.add(Calendar.DATE, -days);

        Date lastDate = calendar.getTime();

        List<Student> list = Arrays.stream(students).filter(s ->
                s.getBirthDate().after(firstDate)
                        && s.getBirthDate().before(lastDate)
        ).collect(Collectors.toList());
        std = list.toArray(std);
        return std;
    }

    @Override
    public int getCurrentAgeByDate(int indexOfStudent) {
        if (indexOfStudent == 0) {
            throw new IllegalArgumentException();
        }
        Calendar birth = Calendar.getInstance();
        birth.setTime((students[indexOfStudent].getBirthDate()));

        Calendar today = Calendar.getInstance();;
        today.setTime(new Date());

        return today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
    }

    @Override
    public Student[] getStudentsByAge(int age) {
        Student[] std = null;

        List<Student> list = new ArrayList<>();
        for(int i = 0; i < students.length; i++){
            if(getCurrentAgeByDate(i) == age){
                list.add(students[i]);
            }
        }
        std = list.toArray(std);
        return std;
    }

    @Override
    public Student[] getStudentsWithMaxAvgMark() {
        Student[] std = null;
        Student max = students[0];

        List<Student> list = new ArrayList<>();
        for(int i = 0; i < students.length; i++){
            if(students[i].getAvgMark() > max.getAvgMark()){
                max = students[i];
            }
        }
        list.add(max);
        std = list.toArray(std);
        return std;
    }

    @Override
    public Student getNextStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        int st = list.indexOf(student);
        return students[st + 1];
    }

    @Override
    public void add(Student student, int index) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.add(index, student);
        students = list.toArray(students);
    }


}