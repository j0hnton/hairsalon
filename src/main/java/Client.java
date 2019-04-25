import java.util.List;
import org.sql2o.*;
public class Client {

    private String Cname;

    public Client(String cname) {

        this.Cname = cname;
    }


    public String getcname() {
        return Cname;
    }
}
