package com.maimabank

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureNetworking(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        dependencies {
            add("implementation", (libs.findLibrary("retrofit").get()))
            add("implementation", (libs.findLibrary("retrofit.converter").get()))
            add("implementation", (libs.findLibrary("okhttp").get()))
            add("implementation", (libs.findLibrary("moshi").get()))
            add("implementation", (libs.findLibrary("moshi.retrofit").get()))
            add("implementation", (libs.findLibrary("okhttp.logging").get()))
            add("ksp", (libs.findLibrary("moshi.codegen").get()))
            add("implementation", (libs.findLibrary("kotlinx.serialization.json").get()))
            add("implementation", (libs.findLibrary("androidx.paging.common.android").get()))
            add("implementation", (libs.findLibrary("androidx.work.runtime.ktx").get()))
            add("implementation", (libs.findLibrary("ksprefs").get()))
            add("implementation", (libs.findLibrary("androidx.security").get()))
        }
    }
}