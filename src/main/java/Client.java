import java.util.List;
import org.sql2o.*;
public class Client {

    private int id;
    private String Gender;
    private String Name;
    private String Cname;


    public Client(String name, String gender, String cname) {

       Name = name;
        Gender = gender;
        Cname = cname;


    }

    public String getgender() {
        return Gender;
    }

    public String getname() {
        return Name;
    }

    public String getcname() {
        return Cname;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object anotherClient) {
        if (!(anotherClient instanceof Client)) {
            return false;
        } else {
            Client newClient = (Client) anotherClient;
            return this.getname().equals(newClient.getname()) &&
                    this.getgender() == newClient.getgender() &&
                    this.getcname() == newClient.getcname();


        }
    }

    public static List<Client> all() {
        String sql = "SELECT * FROM client";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO client (name ,gender,cname) VALUES (:name, :gender , :cname)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", Name)
                    .addParameter("gender", Gender)
                    .addParameter("cname", Cname)
                    .executeUpdate()
                    .getKey();
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM client WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
    public static Client find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM client where id = :id;";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
        }
    }
}

