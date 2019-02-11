# Intorduction

This is a minimal project aiming to reproduce https://issues.apache.org/jira/projects/MYFACES/issues/MYFACES-4282.

# Build instructions

Build with Maven:

To build with MyFaces (affected by the bug) use:
```
mvn clean package -Pmyfaces
```

To build with Mojarra (NOT affected by the bug) use:
```
mvn clean package -Pmojarra
```

In either case you end up with a `myfaces-4282.war` located at `target`. This WAR is ready to be deployed on Tomcat 9
(I used 9.0.14 while testing).

# Reproduce the bug

1. Deploy `myfaces-4282.war` built with `-Pmyfaces` to Tomcat
1. Navigate to http://localhost:8080/myfaces-4282/viewScopeTest.xhtml?key=12345 (assuming your Tomcat runs at port 8080)
1. See the following appearing twice in the logs:
```
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel ### PostConstruct
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
```

# Expected behavior

1. Undeploy
1. Deploy `myfaces-4282.war` built with `-Pmojarra` to Tomcat
1. Navigate to http://localhost:8080/myfaces-4282/viewScopeTest.xhtml?key=12345 (assuming your Tomcat runs at port 8080)
1. See the following appearing only once in the logs:
```
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel ### PostConstruct
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
ERROR myfaces_4282.ViewScopeModel #######################################
```
