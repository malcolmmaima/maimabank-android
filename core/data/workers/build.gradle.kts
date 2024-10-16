plugins {
    id("maimabank.library")
    id("maimabank.room")
    id("maimabank.hilt")
    id("maimabank.library.network")
}

android {
    namespace = "com.maimabank.data.workers"

}

dependencies {

    implementation(project(":core:database"))
    implementation(project(":core:data"))
    implementation(project(":app"))
    implementation(project(":core:utils"))
    implementation(libs.firebase.dataconnect)
    implementation(project(":core:networking"))
    implementation(project(":core:common"))
}