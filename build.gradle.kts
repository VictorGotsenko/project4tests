plugins {
    application
    checkstyle
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.github.ben-manes.versions") version "0.52.0"
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"
description = "Project Spring Boot for tests"

application {
    mainClass = "hexlet.code.AppApplication"
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    // DataBase section
    implementation("com.zaxxer:HikariCP:6.3.0")
    // for  driver class: org.postgresql.Driver
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.postgresql:postgresql:42.7.7")




    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

checkstyle {
    toolVersion = "10.26.1"
    configFile = file("config/checkstyle/checkstyle.xml")
}


tasks.withType<JavaCompile>() {
    // "--warning-mode all",
    options.compilerArgs.addAll(listOf("-Xlint:deprecation", "-Xlint:unchecked"))
}



tasks.withType<Test> {
    useJUnitPlatform()
}
