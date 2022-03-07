package io.github.novemdecillion

import org.jooq.meta.jaxb.ForcedType

open class JooqGeneratorExtension(
  var driver: String = "",
  var url: String = "",
  var user: String = "",
  var password: String = "",

  var externalFlywayLocations: String? = null,

  var directory: String = "",
  var packageName: String = "",
  var includeTables: String? = null,
  var excludeTables: String? = null,
  var appendForcedTypes: Collection<ForcedType>? = null
)
