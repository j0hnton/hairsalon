public class Stylist{


    private String mgender;;
    private String mname;
    private String mcname;


    public Stylist(String name,String gender,String cname){

         mname=name;
         mgender=gender;
         mcname=cname;


    }

    public String getgender() {
        return mgender;
    }

    public String getname() {
        return mname;
    }

    public String getcname() {
        return mcname;
    }
}



