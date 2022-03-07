package io.github.novemdecillion

import io.github.novemdecillion.cqrs.*
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Command
data class CreateUserCommand (
  @AggregateID
  val userId: String,
  val firstName: String,
  val lastName: String
)

data class Address (
  val city: String,
  val state: String,
  val postcode: String
)

data class Contact (
  val type: String,
  val detail: String
)

@Command
data class UpdateUserCommand (
  @AggregateID
  val userId: String,
  val addresses: Set<Address>,
  val contacts: Set<Contact>
)

@Aggregate
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class UserAggregate(val userId: String,
                    val firstName: String,
                    val lastName: String) {

  @CommandHandler
  constructor(command: CreateUserCommand):
    this(command.userId, command.firstName, command.lastName)

  @CommandHandler
  fun handleCreateUserCommand(command: CreateUserCommand): CreateUserCommand {
    return command
  }

  @EventHandler
  fun handleCreatedUserEvent(command: CreateUserCommand) {

  }


/*
  @AggrerateID
  val userId: String

  fun handleCreateUserCommand(command: CreateUserCommand): List<Event?>? {
    val event = UserCreatedEvent(command.userId,
      command.firstName, command.lastName)
    writeRepository.addEvent(command.userId, event)
    return Arrays.asList(event)
  }

  fun handleUpdateUserCommand(command: UpdateUserCommand): List<Event>? {
    val user: User = UserUtility.recreateUserState(writeRepository, command.userId)
    val events: MutableList<Event> = ArrayList<Event>()
    val contactsToRemove: List<Contact> = user.getContacts().stream()
      .filter { c -> !command.contacts.contains(c) }
      .collect(Collectors.toList())
    for ((type, detail): Contact in contactsToRemove) {
      val contactRemovedEvent = UserContactRemovedEvent(type,
        detail)
      events.add(contactRemovedEvent)
      writeRepository.addEvent(command.userId, contactRemovedEvent)
    }
    val contactsToAdd: List<Contact> = command.contacts.stream()
      .filter { c: Contact? -> !user.getContacts().contains(c) }
      .collect(Collectors.toList())
    for ((type, detail): Contact in contactsToAdd) {
      val contactAddedEvent = UserContactAddedEvent(type,
        detail)
      events.add(contactAddedEvent)
      writeRepository.addEvent(command.userId, contactAddedEvent)
    }

    // similarly process addressesToRemove
    // similarly process addressesToAdd
    return events
  }
*/
}