import org.jooq.meta.jaxb.ForcedType

apply {
  plugin("org.springframework.boot")
}

plugins {
  id("io.github.novemdecillion.jooq-generator")
}

sourceSets.main {
  java.srcDir("src/main/jooq")
}

dependencies {

  implementation(project(":backend:cqrs-es"))


  implementation("org.springframework.boot:spring-boot-starter-graphql")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.flywaydb:flyway-core")
  runtimeOnly("org.postgresql:postgresql")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
//  testImplementation("org.springframework:spring-webflux")
  testImplementation("org.springframework.graphql:spring-graphql-test")
  testImplementation("org.springframework.security:spring-security-test")
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("org.testcontainers:postgresql")
}

jooqGenerator {
  driver = "org.testcontainers.jdbc.ContainerDatabaseDriver"
  url = "jdbc:tc:postgresql:11:///build-test"
  user = "admin"
  password = "password123"
  packageName = "io.github.novemdecillion"
//  appendForcedTypes = listOf(
//    ForcedType()
//      .also {
//        it.isEnumConverter = true
//        it.includeExpression = """OPERATION_LOG\.OPERATION_TYPE"""
//        it.userType = "jp.co.supportas.domain.OperationType"
//      },
//
//    ForcedType()
//      .also {
//        it.isEnumConverter = true
//        it.includeExpression = """TEMPORARY_INPUT\.INPUT_TYPE"""
//        it.userType = "jp.co.supportas.domain.InputType"
//      },
//
//    ForcedType()
//      .also {
//        it.isEnumConverter = true
//        it.includeExpression = """MAIL\.MAIL_TYPE"""
//        it.userType = "jp.co.supportas.domain.MailType"
//      })
}