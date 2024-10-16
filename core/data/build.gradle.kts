plugins {
    id("maimabank.library")
    id("maimabank.room")
    id("maimabank.hilt")
    id("maimabank.library.network")
}

android {
    namespace = "com.maimabank.data"
}

dependencies {
    implementation(project(":core:networking"))
    implementation(project(":core:database"))
    implementation(project(":core:utils"))
    implementation(project(":core:design"))
    implementation(project(":core:common"))
}
