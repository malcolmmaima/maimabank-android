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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
