Hello.

Today, I'd like to introduce App using [POML](https://github.com/mamorum/poml).

[kaze-sample-rdb](https://github.com/mamorum/kaze-sample/tree/master/rdb) is a web application and packaged as fatjar.  
Its [pom.poml](https://github.com/mamorum/kaze-sample/blob/master/rdb/pom.poml) (POML File) is very simple. Only 13 lines.

    pkg=com.github.mamorum:kaze-sample-rdb:0.0.1:jar
    depends=
      com.github.mamorum:kaze:0.1.1-SNAPSHOT,
      ch.qos.logback:logback-classic:1.1.7,
      org.postgresql:postgresql:9.4.1209,
      com.zaxxer:HikariCP:2.4.7,
      org.sql2o:sql2o:1.5.4,
      org.flywaydb:flyway-core:4.0.3
    property=
      project.build.sourceEncoding:UTF-8
    compiler=source:1.8, target:1.8
    fatjar=mainClass:kaze.sample.rdb.Main
    exec=mainClass:kaze.sample.rdb.Main

POML generates [pom.xml](https://github.com/mamorum/kaze-sample/blob/master/rdb/pom.xml) from above.  
It has 92 lines.

Thank you for reading.

_mamorum_