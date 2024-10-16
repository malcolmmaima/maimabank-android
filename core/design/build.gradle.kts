plugins {
    id("maimabank.library")
    id("maimabank.library.compose")
}

android {
    namespace = "com.maimabank.core.design"
}
dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:utils"))
}
