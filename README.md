Enterprise: meet the modern web. I think you two will get along just fine.

# java-web-kickstart

The apparent attitude that building 'enterprise' applications should dictate using draconian tools and
producing unusable interfaces is disturbing. Complexity and scale of a project are not am excuse for making both
developers and users miserable. Nor is historical precedent a reason to continue using archaic practices.

The purpose of this tool is to help kick-start big Java-based projects that **don't suck** using blueprints
that work. Think of the [Rails command-line](http://guides.rubyonrails.org/command_line.html) or projects like
[Yeoman](http://yeoman.io/), but targeting the comforts of statically-typed and business friendly Java on the
back-end.

Project goals:

* Provide the most productive development environment possible right out of the gates. Cut out time
  associated with boot-strapping a project.
* Help start projects on solid footing by providing the right frameworks and tools to build something awesome. Cut
  Sharepoint and Oracle ADF out of the vocabulary before they even come up.

## Setting it up

Create a directory for your project and create a `build.gradle` file with the following contents:

    buildscript {
        dependencies {
            classpath fileTree(dir: 'path/to/java-kickstart', includes: ['*.jar'])
        }
    }
    apply plugin: 'kickstart'

Now run the `create-project` command to generate your project stub:

    $ gradle create-project

The project is ready to run.

    $ gradle war
    $ gradle jettyRun