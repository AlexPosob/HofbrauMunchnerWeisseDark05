pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.2.0"
        id("io.spring.dependency-management") version "1.1.4"
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.springframework.boot" ->
                    useModule("org.springframework.boot:spring-boot-gradle-plugin:3.2.0")
                "io.spring.dependency-management" ->
                    useModule("io.spring.gradle:dependency-management-plugin:1.1.4")
            }
        }
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Labs"
