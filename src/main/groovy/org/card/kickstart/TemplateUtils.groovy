package org.card.kickstart

import groovy.text.GStringTemplateEngine;

class TemplateUtils {
    protected static InputStream getResource(String templatePath) {
        return TemplateUtils.class.getResourceAsStream(templatePath)
    }

    protected static String render(String templatePath, Map model = [:]) {
        String template = getResource(templatePath).text
        return new GStringTemplateEngine().createTemplate(template).make(model).toString()
    }

    public static void generateFile(String filePath, String templatePath, Map model = [:]) {
        int pos = filePath.lastIndexOf('/')
        if (pos > 0) {
            String path = filePath.substring(0,pos)
            new File(path).mkdirs()
        }
        def f = new File(filePath)
        f << render(templatePath, model)
    }
}
