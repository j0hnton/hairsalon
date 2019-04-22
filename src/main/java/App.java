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
            model.put("squads", request.session().attribute("squads"));
            return new ModelAndView(model, layout);

        },
                new VelocityTemplateEngine());
        get("/Squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/Squad.vtl");
            model.put("squads", request.session().attribute("squads"));
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Squadsuccess", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", request.session().attribute("squads"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", request.session().attribute("squads"));
            model.put("template", "public/templates/Hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", request.session().attribute("squads"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", request.session().attribute("squads"));
            model.put("template", "public/templates/display.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        //post//
        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squads = request.session().attribute("squads");

            if (squads == null) {
                squads = new ArrayList<Squad>();
                request.session().attribute("squads", squads);
            }


            String name = request.queryParams("name");
            String gender= request.queryParams("gender");

            Squad newHero = new Squad(name,gender);
            squads.add(newHero);

            model.put("template", "public/templates/Squadsuccess.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}