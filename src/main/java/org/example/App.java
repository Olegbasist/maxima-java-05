package org.example;

// TODO: Установить Tomcat
//  Cделать генерацию страницы через обращение к сервлету и передачу ему параметров кота:
//  String name, int weight, boolean isAngry


import freemarker.template.TemplateException;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException, IncorrectCatWeightException, TemplateException {
        DynamicPage dynamicPage = new DynamicPage();
        dynamicPage.createPage("Cat");
    }
}
