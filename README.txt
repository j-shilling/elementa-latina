== Tools Used ==

GWT: http://www.gwtproject.org/
GWT Maven Plugin: https://tbroyer.github.io/gwt-maven-plugin/
GWTP Framework: http://dev.arcbees.com/gwtp/
RESTEasy: http://resteasy.jboss.org/
Guice: https://github.com/google/guice/wiki

== To Run Development Mode ==

In one terminal window: mvn gwt:codeserver -pl *-client -am
In another terminal window: mvn tomcat7:run -pl *-server -am -Denv=dev

== Current Status ==

I've switch jobs and no longer need the fully featured education management platform that this was meant to be. This project, however, has inspired me to write a more focused REST Api to serve as a monolingual Latin dictionary: https://gitlab.com/shilling.jake/elementa-latina-api
