package io.github.novemdecillion

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.uuid.Generators
import io.github.novemdecillion.cqrs.AggrerateID
import io.github.novemdecillion.cqrs.CommandService
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.jooq.JooqTest
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.TestConstructor
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootApplication
@ComponentScan
class CQRSTestApplication



@JooqTest
@Testcontainers
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CQRSTest(val applicationContext: ConfigurableApplicationContext) {
  companion object {
    @JvmStatic
    @Container
    val container = PostgreSQLContainer<Nothing>("postgres:13")

    @DynamicPropertySource
    @JvmStatic
    fun changeProperty(registry: DynamicPropertyRegistry): Unit {
      registry.add("spring.datasource.url", container::getJdbcUrl)
      registry.add("spring.datasource.username", container::getUsername)
      registry.add("spring.datasource.password", container::getPassword)
    }
  }

	@Test
	fun contextLoads() {
//    EventStoreService()

    val user = applicationContext.getBean(UserAggregate::class.java, CreateUserCommand("", "", ""))
    println(user)

//    CommandService(ObjectMapper()).init(CQRSTest::class.java.packageName, applicationContext)
//
    val generator = Generators.timeBasedGenerator()
    val userId = generator.generate().toString()

/*
    var events: List<Event?>? = null
    val createUserCommand = CreateUserCommand(userId, "Kumar", "Chandrakant")
    events = userAggregate.handleCreateUserCommand(createUserCommand)

    projector.project(userId, events)

    var updateUserCommand: UpdateUserCommand? = UpdateUserCommand(
      userId, Stream.of(Address("New York", "NY", "10001"), Address("Los Angeles", "CA", "90001"))
        .collect(Collectors.toSet()),
      Stream.of(Contact("EMAIL", "tom.sawyer@gmail.com"), Contact("EMAIL", "tom.sawyer@rediff.com"))
        .collect(Collectors.toSet())
    )
    events = userAggregate.handleUpdateUserCommand(updateUserCommand)
    projector.project(userId, events)

    updateUserCommand = UpdateUserCommand(
      userId, Stream.of(Address("New York", "NY", "10001"), Address("Housten", "TX", "77001"))
        .collect(Collectors.toSet()),
      Stream.of(Contact("EMAIL", "tom.sawyer@gmail.com"), Contact("PHONE", "700-000-0001"))
        .collect(Collectors.toSet())
    )
    events = userAggregate.handleUpdateUserCommand(updateUserCommand)
    projector.project(userId, events)

    val contactByTypeQuery = ContactByTypeQuery(userId, "EMAIL")
    assertEquals(
      Stream.of(Contact("EMAIL", "tom.sawyer@gmail.com"))
        .collect(Collectors.toSet()), userProjection.handle(contactByTypeQuery)
    )
    val addressByRegionQuery = AddressByRegionQuery(userId, "NY")
    assertEquals(
      Stream.of(Address("New York", "NY", "10001"))
        .collect(Collectors.toSet()), userProjection.handle(addressByRegionQuery)
    )
*/
  }

}
