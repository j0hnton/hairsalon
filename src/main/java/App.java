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
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/Hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/salons", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("salons", request.session().attribute("salons"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        //post//
        post("/salons", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Stylist> salons = request.session().attribute("salons");

            if (salons == null) {
                salons = new ArrayList<Stylist>();
                request.session().attribute("salons", salons);
            }


            String name = request.queryParams("name");
            String gender= request.queryParams("gender");

            Stylist newPerson = new Stylist(name,gender);
            salons.add(newPerson);

            model.put("template", "public/templates/Squadsuccess.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}