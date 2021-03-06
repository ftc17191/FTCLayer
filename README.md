# FTC Layer

Welcome! FTC Layer is an open source project designed to provide abstractions over the base [FTC SDK](https://github.com/FIRST-Tech-Challenge/FtcRobotController)
FTC Layer is designed to make programming easier, less time consuming, and simpler.


## Check out [our website](http://ftclayer-docs.pages.dev)

## Install

### Want to install to Onbotjava?
[Click Here](https://youtu.be/Te94mwb3q4E)
***
### Want to create a repository with FTC Layer preinstalled?
[Click Here](https://github.com/ftc17191/FTCLayer-quickstart)
***
### Want to create a repository with FTC Layer and Road Runner preinstalled?
[Click Here](https://github.com/ftc17191/FTCLayer-road-runner-quickstart)
***
### Want to install to a pre-existing Repository?

Inside the Project root (The first build.gradle you see), open the build.gradle file.


![Root build.gradle](/Documentation/assets/img/root-build-gradle.png)



Find the lines that says:
```
allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

```

Then, change it to:
```
allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

Afterwards, open the _build.gradle_ file inside of _TeamCode_ folder.

![TeamCode build.gradle](/Documentation/assets/img/teamcode-build-gradle.png)

Find the lines that say:
```
dependencies {
    implementation project(':FtcRobotController')
    annotationProcessor files('lib/OpModeAnnotationProcessor.jar')

}
```

Change it to say:
```
dependencies {
    implementation project(':FtcRobotController')
    annotationProcessor files('lib/OpModeAnnotationProcessor.jar')

    implementation 'com.github.ftc17191:ftclayer:+'
}
```

Then preform a gradle sync by pressing the elephant in the top right.

![Gradle Sync](/Documentation/assets/img/gradle-sync.png)
