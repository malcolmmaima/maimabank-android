plugins {
    id("maimabank.library")
    id("maimabank.hilt")
    id("maimabank.library.network")
}

android {
    namespace = "com.maimabank.core.features.networking"
}

dependencies {
    implementation(project(":core:utils"))
}
