plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.inspired.frog"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.inspired.frog"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.ktx)

    testImplementation(libs.junit)


    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.retrofit)
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")



    implementation ("com.squareup.moshi:moshi:1.15.1")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")


    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.51.1")

    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2")
    implementation("com.squareup:javapoet:1.13.0")

    // Location Services
    implementation ("com.google.android.gms:play-services-location:20.0.0")

}