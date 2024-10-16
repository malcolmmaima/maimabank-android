plugins {
    id("maimabank.library")
    id("maimabank.library.compose")
    id("maimabank.testing")
}

android {
    namespace = "com.maimabank.utils"
}

dependencies {
    implementation(project(":core:common"))
}
