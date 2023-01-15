package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DynamicPage {

    public void createPage (String filename) throws IOException, IncorrectCatWeightException, TemplateException {

        String pathToResources = "src/main/resources/templates";
        //String pathToResources = Objects.requireNonNull(App.class.getClassLoader().getResource("templates")).getPath();
        System.out.println(pathToResources);
        FileWriter fileWriter = new FileWriter("cats.html",false);

        //Конфигурация FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(pathToResources));
        configuration.setDefaultEncoding("UTF-8");

        Map root = new HashMap();
        root.put("title", "Наши Коты");

        //Создаем кота
        Cat catRad = new Cat("Рыжик", 7, false);
        System.out.println(catRad.toString());

        Template template = configuration.getTemplate("index.html");
        template.process(root,fileWriter);

        fileWriter.flush();
        fileWriter.close();

    }

}
