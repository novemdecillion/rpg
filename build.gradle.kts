import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  idea

	id("org.springframework.boot") version "2.7.0-M2" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
  kotlin("jvm") version "1.6.10" apply false
	kotlin("plugin.spring") version "1.6.10" apply false
}

subprojects {
  apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.spring")
  }

  group = "io.github.novemdecillion"
  version = "0.0.1-SNAPSHOT"
  java.sourceCompatibility = JavaVersion.VERSION_11

  configurations {
    compileOnly {
      extendsFrom(configurations.annotationProcessor.get())
    }
  }

  repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
  }

  extra["testcontainersVersion"] = "1.16.2"

  dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-graphql")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    runtimeOnly("org.postgresql:postgresql")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework:spring-webflux")
//    testImplementation("org.springframework.graphql:spring-graphql-test")
//    testImplementation("org.springframework.security:spring-security-test")
//    testImplementation("org.testcontainers:junit-jupiter")
//    testImplementation("org.testcontainers:postgresql")
  }

  the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
    imports {
      mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}

idea {
  module {
    isDownloadSources = true
  }
}
