import spark.ModelAndView;
 import spark.template.velocity.VelocityTemplateEngine;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map;

 import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        String layout = "/public/templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/index.vtl");
            model.put("salons", request.session().attribute("salons"));
            return new ModelAndView(model, layout);

        },
                new VelocityTemplateEngine());
        get("/Stylist", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/Stylist.vtl");
            model.put("salons", request.session().attribute("salons"));
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Squadsuccess", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", Stylist.all());
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", Stylist.all());
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/salons", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Client", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/Client.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/index", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //post//
        post("/salons", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String gender= request.queryParams("gender");
            String cname= request.queryParams("cname");
            Stylist newPerson = new Stylist(name,gender,cname);
            newPerson.save();
            model.put("template", "public/templates/Success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/delete-stylist", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
             Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("id")));
            stylist.delete();
            model.put("salons", stylist);
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}

