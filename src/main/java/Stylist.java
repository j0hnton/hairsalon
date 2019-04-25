import org.sql2o.Connection;

import java.util.List;

public class Stylist {

    private int id;
    private String Gender;
    private String Name;


    public Stylist(String name, String gender) {

        Name = name;
        Gender = gender;


    }

    public String getgender() {
        return Gender;
    }

    public String getname() {
        return Name;
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object anotherStylist) {
        if (!(anotherStylist instanceof Stylist)) {
            return false;
        } else {
            Stylist newStylist = (Stylist) anotherStylist;
            return this.getname().equals(newStylist.getname()) &&
                    this.getgender() == newStylist.getgender();


        }
    }

    public static List<Stylist> all() {
        String sql = "SELECT * FROM stylist";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Stylist.class);
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO Stylist (name,gender) VALUES (:name, :gender)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", Name)
                    .addParameter("gender", Gender)


                    .executeUpdate()
                    .getKey();
        }
    }

    public void delete() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM stylist WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public static Stylist find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM stylist where id = :id;";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylist.class);
        }
    }
}
