plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "br.com.ivan.loginfirebaseexempler"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.ivan.loginfirebaseexempler"
        minSdk = 28
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
    viewBinding {
        enable = true
    }
}

dependencies {

    val coroutinesVersion = "1.7.3"
    val retrofitVersion = "2.9.0"
    val lifeCycleVersion = "2.6.2"
    val daggerHiltVersion = "2.48"
    val hiltLifeCycleVersion = "1.1.0"
    val coilVersion = "1.2.2"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")
    // implementation ("androidx.lifecycle:lifecycle-extensions:$lifeCycleVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion")

    implementation ("androidx.activity:activity-ktx:1.8.2")

    //Hilt for di
    implementation ("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")

    //Navigation
    val nav_version = "2.7.6"
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    kapt ("com.github.bumptech.glide:compiler:4.11.0")



    //firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-storage")
    //implementation ("com.firebaseui:firebase-ui-storage")
    implementation("com.google.firebase:firebase-firestore")

}