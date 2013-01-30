package org.card.kickstart

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Base web project plugin exposing all project tasks .
 */
class WebProjectPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('create-project', description: 'Creates the skeleton for a new web project') << {
            def model = [:]
            model['groupId'] = ShellCommands.prompt("Group", "com.example")
            model['artifact'] = ShellCommands.prompt("Artifact Id", "myapp")
            model['version'] = ShellCommands.prompt("Version", "1.0.0")

            // TODO: validate and strip illegal characters
            model['basePackage'] = "${model['groupId']}.${model['artifact']}"

            TemplateUtils.generateFile( "src/main/resources/logback.xml", "/templates/logback/logback.tmpl.xml", model)
            TemplateUtils.generateClass(".web.WebConfig", "/templates/spring/WebConfig.tmpl.java", model)
        }
    }
}