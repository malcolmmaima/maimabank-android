pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Maima Bank"
include(":app")
include(":features")
include(":features:home")
include(":core")
include(":core:networking")
include(":core:design")
include(":core:utils")
include(":core:database")
