import java.util.Date;

/**
 * IEmployee
 */
public interface IEmployee {
    void start(Date date);
    void terminate(Date date);
    void work();
    String getnome();
}