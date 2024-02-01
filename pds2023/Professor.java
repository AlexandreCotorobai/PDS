public class Professor extends Monitor{
    private String className;
    private String name;

    public Professor(StudentAdm adm, String name, String className) {
        this.name = name;
        this.className = className;
        adm.addGradeObserver(this);
        
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }


}
