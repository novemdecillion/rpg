package io.github.novemdecillion.cqrs

import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
annotation class Aggregate

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
annotation class Command

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
annotation class Event


annotation class AggregateID()


annotation class CommandHandler()


annotation class EventHandler()
