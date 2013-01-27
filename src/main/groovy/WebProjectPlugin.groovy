import org.gradle.api.Plugin
import org.gradle.api.Project

class WebProjectPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('create-project', description: 'Creates the skeleton for a new web project') << {
            println "Creating project..."
        }
    }
}