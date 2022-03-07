package io.github.novemdecillion.cqrs

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


/**
 * 作成コマンドは、Aggregateのval変数の初期化が可能にするため、
 * まず存在するならAggregateのコンストラクタを呼び出し、
 * 次にハンドラを呼び出す。
 *
 * コマンドとイベントを明確には別けない。
 *
 * コマンドに対応するコマンドハンドラがなく、
 * コマンドを引数とするイベントハンドラが存在するなら、
 * コマンドはイベントとして扱う。
 */
class CommandService(
//  private val objectMapper: ObjectMapper,
  private val aggregateDefinition: AggregateDefinition
) {

  data class AggregateDefinition(
//    val defaultConstructor: Constructor<*>,
    val createCommandToConstructorMap: Map<Class<*>, Constructor<*>>,
    val commandToHandlerMap: Map<Class<*>, Method> = mapOf(),
    val eventToHandlerMap: Map<Class<*>, Method> = mapOf(),
  )


  companion object {
    fun scan(basePackage: String): AggregateDefinition {
      val scanner = ClassPathScanningCandidateComponentProvider(false)
      scanner.addIncludeFilter(AnnotationTypeFilter(Aggregate::class.java))
      val definitions = scanner.findCandidateComponents(basePackage)

      val createCommandToConstructorMap = mutableMapOf<Class<*>, Constructor<*>>()
      val commandToHandlerMap: Map<Class<*>, Method> = mapOf()
      val eventToHandlerMap: Map<Class<*>, Method> = mapOf()

      for (definition in definitions) {
        val aggregateClass = Class.forName(definition.beanClassName)

//        var defaultConstructor: Constructor<*>? = null

        for (constructor in aggregateClass.constructors) {

          constructor.isAnnotationPresent(CommandHandler::class.java)

          when (constructor.parameterCount) {
//            0 -> defaultConstructor = constructor
            1 -> if (constructor.parameterTypes[0].isAnnotationPresent(Command::class.java)) {
              createCommandToConstructorMap[constructor.parameterTypes[0]] = constructor
            }
          }
        }

//        if (createCommandToConstructorMap.isNotEmpty()) {
//
//          aggregateDefinitions.add(
//            AggregateDefinition(
//              createCommandToConstructorMap,
//            )
//          )
//        }

      }
      return AggregateDefinition(createCommandToConstructorMap)
    }
  }

  fun dispatch(command: Any) {

    aggregateDefinition.createCommandToConstructorMap[command.javaClass]
      ?.also {
        val instance = it.newInstance(command)


        val mapper = jacksonObjectMapper()
        val serialized = mapper.writeValueAsString(instance)
        println(serialized)

        val deserialized = mapper.readValue(serialized, it.declaringClass)
        println(deserialized)
      }
  }
}
