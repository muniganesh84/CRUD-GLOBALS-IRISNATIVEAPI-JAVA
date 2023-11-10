﻿# Example Native API Application

See https://docs.intersystems.com/iris20232/csp/docbook/DocBook.UI.Page.cls?KEY=BJAVNAT_about

## How to build this example

On Windows
```
javac -classpath "C:\InterSystems\IRIS\dev\java\lib\1.8\intersystems-gateway-3.7.1.jar;C:\InterSystems\IRIS\dev\java\lib\JDK18\intersystems-jdbc-3.7.1.jar" -d bin src\IRISNative\IRISNative.java
```

On UNIX


```
cd src/java

javac -classpath /usr/irissys/dev/java/lib/JDK18/intersystems-jdbc-3.7.1.jar -d bin src/IRISNative/IRISNative.java
```


## How to build and run this example in the container

```
cd bin
java IRISNative
```

