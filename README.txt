== Tools Used ==

GWT: http://www.gwtproject.org/
GWT Maven Plugin: https://tbroyer.github.io/gwt-maven-plugin/
GWTP Framework: http://dev.arcbees.com/gwtp/
RESTEasy: http://resteasy.jboss.org/
Guice: https://github.com/google/guice/wiki

== To Run Development Mode ==

In one terminal window: mvn gwt:codeserver -pl *-client -am
In another terminal window: mvn tomcat7:run -pl *-server -am -Denv=dev

