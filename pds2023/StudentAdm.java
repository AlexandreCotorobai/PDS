import java.util.*;

public class StudentAdm {
    private Student student;
    private List<Monitor> gradeObservers = new ArrayList<Monitor>();
    private List<Monitor> overallGradeObeservers = new ArrayList<Monitor>();

    public StudentAdm(Student s) {
        this.student = s;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);
        String ProfessorName;
        for (Monitor prof : gradeObservers) {

            // NOTA
            // O codigo abaixo envia a notificacao apenas ao professor q da a nota
            // O mais abaixo, ativo, envia a todos
            // Nao tinha certeza de qual era o metodo suposto, mas por bem coloquei o que
            // envia a todos

            if(((Professor)prof).getClassName() == className){
                ProfessorName = ((Professor)prof).getName();
                prof.update("Professor " + ProfessorName + " of " + className + " class evaluated student " + student.getName() + " (" + student.getId() + ") with score: " + student.getScore(className));
            }

            // if (((Professor) prof).getClassName() == className) {
            //     ProfessorName = ((Professor) prof).getName();
            //     notifygradeObservers(
            //             "Professor " + ProfessorName + " of " + className + " class evaluated student "
            //                     + student.getName() + " (" + student.getId() + ") with score: "
            //                     + student.getScore(className));
            // }
        }

        // notifygradeObservers("Professor NAME of " + className + " class evaluated
        // student " + student.getName() + " (" + student.getId() + ") with score: " +
        // student.getScore(className));
        notifyOverallGradeObservers(student.getCourse() + " director reports that student " + student.getName() + " ("
                + student.getId() + ") has changed the overall grade: " + student.getOverallGrade());
    }

    public Student getStudent() {
        return student;
    }

    public Course getStudentCourse() {
        return student.getCourse();
    }

    public void addGradeObserver(Monitor m) {
        gradeObservers.add(m);
        // System.out.println("prof + " + m + "Added to gradeObs");
    }

    public void addOverallOveserver(Monitor m) {
        overallGradeObeservers.add(m);
    }

    public void removeObserver(Monitor m) {
        gradeObservers.remove(m);
    }

    public void notifygradeObservers(String msg) {
        for (Monitor m : gradeObservers) {
            // System.out.println("Estes sao todos" + ((Professor)m).getName());

            // if (prof != m) {
            // System.out.println("Estes sao diferentes" + ((Professor)m).getName());
            m.update(msg);
            // }
        }
    }

    public void notifyOverallGradeObservers(String msg) {
        for (Monitor m : overallGradeObeservers) {
            m.update(msg);
            // System.out.println("Prof Notificado: " + m);
        }
    }

}
