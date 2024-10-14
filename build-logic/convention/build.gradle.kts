plugins {
    `kotlin-dsl`
}
group = "com.maimabank.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    dependencies {
        compileOnly(libs.android.gradle)
        compileOnly(libs.kotlin.gradle)
        compileOnly(libs.ksp.gradlePlugin)
    }

}

gradlePlugin {
    plugins {
        register("androidApp"){
            id = "maimabank.app"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary"){
            id = "maimabank.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "maimabank.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "maimabank.app.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidApplicationNetwork") {
            id = "maimabank.app.network"
            implementationClass = "AndroidApplicationNetworkConventionPlugin"
        }

        register("androidLibraryNetwork") {
            id = "maimabank.library.network"
            implementationClass = "AndroidLibraryNetworkConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "maimabank.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidTesting") {
            id = "maimabank.testing"
            implementationClass = "TestingConventionPlugin"
        }
        register("androidRoom") {
            id = "maimabank.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

    }
}