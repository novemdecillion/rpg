pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		gradlePluginPortal()
	}
}
rootProject.name = "rpg"
include("backend:app", "backend:cqrs-es")
