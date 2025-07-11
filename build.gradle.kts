plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "tally"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // uuid v7
    implementation("com.github.f4b6a3:uuid-creator:6.1.1")

    // docker
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    // db
    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.redisson:redisson-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // p6spy
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.10.0")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
