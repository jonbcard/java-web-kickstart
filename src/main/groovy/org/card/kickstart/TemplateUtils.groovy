package org.card.kickstart

import groovy.text.GStringTemplateEngine;

class TemplateUtils {
    public static final JAVA_SRC = "src/main/java"

    protected static InputStream getResource(String templatePath) {
        return TemplateUtils.class.getResourceAsStream(templatePath)
    }

    protected static String render(String templatePath, Map model = [:]) {
        String template = getResource(templatePath).text
        return new GStringTemplateEngine().createTemplate(template).make(model).toString()
    }

    public static void generateStaticFile(String filePath, String src) {
        int pos = filePath.lastIndexOf('/')
        if (pos > 0) {
            String path = filePath.substring(0,pos)
            new File(path).mkdirs()
        }
        new File(filePath).text = getResource(filePath).text

        println "Wrote static file: ${filePath}"
    }

    public static void generateFile(String filePath, String templatePath, Map model = [:]) {
        int pos = filePath.lastIndexOf('/')
        if (pos > 0) {
            String path = filePath.substring(0,pos)
            new File(path).mkdirs()
        }
        new File(filePath).text = render(templatePath, model)

        println "Rendered file: ${filePath}"
    }

    public static void appendToFile(String filePath, String templatePath, Map model = [:]) {
        def f = new File(filePath)
        f.append(render(templatePath, model))

        println "Appended to: ${filePath}"
    }

   /**
    * @param className
    *   Name of the class to generate, including package (from the base package).
    *   Should always start with a '.' character.
    * @param templatePath
    *   Path of template on the classpath to generate from.
    * @param model
    *   Must at a minimum include 'basePackage'.
    */
    public static void generateClass(String className, String templatePath, Map model = [:]) {
        int pos = className.lastIndexOf('.')
        String fullPackage = (pos > 0 ) ? model['basePackage'] + className.substring(0, pos) : model['basePackage']
        model['classPackage'] = fullPackage
        model['className'] = (pos >= 0) ? className.substring(pos+1) : className

        String subpath = fullPackage.replaceAll("\\.", "/")
        String filePath = "${JAVA_SRC}/${subpath}/${model['className']}.java"
        generateFile(filePath, templatePath, model)
    }

}
