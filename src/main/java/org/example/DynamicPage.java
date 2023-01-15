package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DynamicPage {

    public void createPage (String filename) throws IOException, IncorrectCatWeightException, TemplateException {

        String pathToResources = "src/main/resources/templates";
        //String pathToResources = Objects.requireNonNull(App.class.getClassLoader().getResource("templates")).getPath();
        FileWriter fileWriter = new FileWriter("cats.html",false);

        //Конфигурация FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(pathToResources));
        configuration.setDefaultEncoding("UTF-8");

        //Создаем кота
        Cat catRad = new Cat("Рыжик", 7, false);

        //Кладем кота в мап
        Map root = new HashMap();
        root.put("cat",catRad);

        String catIsAngry = catRad.isAngry() ? "Подобреет найдя хозяина" : "Добрый кот";
        root.put("catIsAngry", catIsAngry);

        Template template = configuration.getTemplate("index.html");
        template.process(root,fileWriter);

        fileWriter.flush();
        fileWriter.close();

    }

}
