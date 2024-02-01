import java.util.ArrayList;
import java.util.List;

// GradingSystem class
public class GradingSystem {
    List<StudentAdm> studentsAdm = new ArrayList<>();
    List<Professor> profes = new ArrayList<>();
    List<Director> directs = new ArrayList<>();


    // Add a student to the system
    // The director of student's course is added as Monitor
    public StudentAdm addStudent(Student student) {
        StudentAdm studentAdm = new StudentAdm(student);
        studentsAdm.add(studentAdm);
        return studentAdm;
    }   

    // Add a director to the system
    // The director is added as monitor of the students in the same course
    public void addDirector(Course course) {

        for(StudentAdm studentAdm : studentsAdm){
            if(studentAdm.getStudentCourse() == course){
                Director director = new Director(studentAdm, course);
                // studentAdm.addOverallOveserver(director);
                directs.add(director);
            }
        }
    } 

    public void addProfessor(Professor professor) {
        profes.add(professor);
    }


    public List<Director> getDirectors() {
        return directs;
    }

    public List<Professor> getProfessors() {
        return profes;
    }

    //does the work iguess
    public void Iterate(Course course) {
        for(StudentAdm studentAdm : studentsAdm){
            if(studentAdm.getStudentCourse() == course){
                System.out.println(studentAdm.getStudent().getName() + " of course " + course);
            }
        }
    }

}