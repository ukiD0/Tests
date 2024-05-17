@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

android {
    namespace = "com.example.saransk"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.saransk"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation("io.github.pilgr:paperdb:2.7.2")
    implementation ("io.ktor:ktor-client-cio:2.3.8")
    implementation("io.github.jan-tennert.supabase:postgrest-kt:2.3.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation ("com.github.barteksc:android-pdf-viewer:2.8.2")
    implementation ("com.github.dhaval2404:imagepicker-support:1.7.1")
    implementation("io.github.jan-tennert.supabase:storage-kt:2.3.0")
    implementation ("androidx.activity:activity-ktx:1.8.2")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("org.osmdroid:osmdroid-android:6.1.18")
    implementation("ru.egslava:MaskedEditText:1.0.5")
    implementation("com.google.android.gms:play-services-location:21.1.0")
    implementation ("com.yandex.android:maps.mobile:4.5.1-lite")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.yarolegovich:sliding-root-nav:1.1.1")
    implementation ("com.guolindev.permissionx:permissionx:1.7.1")
    //barcode
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    //testing
    androidTestImplementation ("com.androidx.support.test:rules:1.0.2")
    debugImplementation("androidx.fragment:fragment-testing:1.7.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.7")
    androidTestImplementation ("org.hamcrest:hamcrest-library:1.3")
    testImplementation ("org.mockito:mockito-core:3.11.2")

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}