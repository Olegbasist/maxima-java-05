package org.example;

import freemarker.template.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DynamicPage {

    public void createPage (String filename) throws IOException {

        String pathToResourses = Objects.requireNonNull(App.class.getClassLoader().getResource("templates")).getPath();
        FileWriter fileWriter = new FileWriter("cats.html",false);

        //Конфигурация FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(pathToResourses));
        configuration.setDefaultEncoding("UTF-8");

        Map root = new HashMap();
        root.put("title", "Наши коты");

        fileWriter.flush();
        fileWriter.close();

    }

}
