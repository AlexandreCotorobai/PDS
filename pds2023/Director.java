public class Director extends Monitor {
    private Course degreeName;

    public Director(StudentAdm stud, Course degree) {
        this.degreeName = degree;
        if (stud.getStudentCourse() == degree) {
            stud.addOverallOveserver(this);
        }else{
            System.err.println("Error: Director's course must be the same as student's course");
        }
    }

    public Course getCourseName() {
        return degreeName;
    }

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }

}
