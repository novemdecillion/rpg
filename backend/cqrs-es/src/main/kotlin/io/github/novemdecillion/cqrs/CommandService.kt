package io.github.novemdecillion.cqrs

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter


class CommandService(private val objectMapper: ObjectMapper) {
  fun init(basePackage: String, applicationContext: ConfigurableApplicationContext) {
    val scanner = ClassPathScanningCandidateComponentProvider(false)
    scanner.addIncludeFilter(AnnotationTypeFilter(Aggregate::class.java))
    val definitions = scanner.findCandidateComponents(basePackage)

    for (definition in definitions) {

      if(definition.constructorArgumentValues.argumentCount == 1) {

      }

    }

/*
    applicationContext.beanDefinitionNames
      .forEach { beanDefinitionName ->
        val beanDefinition = applicationContext.beanFactory.getBeanDefinition(beanDefinitionName)

        println(beanDefinition.beanClassName)

//        if (beanDefinition.beanClass.packageName.startsWith("io.github.novemdecillion")) {
//          println(beanDefinition)
//        }
      }
*/
  }





  fun dispatch() {

  }
}
