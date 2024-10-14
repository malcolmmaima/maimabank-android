plugins {
    id("maimabank.library")
    id("maimabank.room")
    id("maimabank.hilt")
}

android {
    namespace = "com.maimabank.database"
}

dependencies {
    implementation(project(":core:networking"))
}
