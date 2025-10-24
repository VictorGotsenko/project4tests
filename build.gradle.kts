plugins {
    application
    checkstyle
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
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")


    //С помощью процессора аннотаций Spring Boot формирует предоставление метаданных
    //о конфигурации приложения.
    // Файл spring-configuration-metadata.json содержит информацию о доступных параметрах конфигурации,
    // их типах, значениях по умолчанию, описаниях и других атрибутах.
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")



    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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
