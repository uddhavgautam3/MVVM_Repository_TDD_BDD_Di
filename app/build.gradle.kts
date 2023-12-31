plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.mvvm.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
            isJniDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            res.srcDirs("src/main/res")
        }

        getByName("androidTest") {
            java.srcDirs("src/androidTest/java")
            res.srcDirs("src/androidTest/res")
        }

        getByName("debug") {
            java.srcDirs("src/debug/java")
            res.srcDirs("src/debug/res")
        }


        getByName("test") {
            java.srcDirs("src/test/java")
            resources.srcDirs("src/test/resources")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.8.2")
    implementation("com.squareup.retrofit2:converter-gson:2.8.2")

    //timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //provides viewModels
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.fragment:fragment-ktx:1.6.0")

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    //room
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.core:core-ktx:1.10.1")
    kapt("androidx.room:room-compiler:2.5.2")
    implementation("androidx.room:room-common:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-android-compiler:2.47")

    testImplementation("com.google.dagger:hilt-android-testing:2.47")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.47")

    kapt("com.google.dagger:hilt-compiler:2.47") //kotlin annotation processor for main sourceSet
    kaptTest("com.google.dagger:hilt-compiler:2.47") //kotlin annotation processor for test
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.47") //kotlin annotation processor for androidTest


    //Dagger
    implementation("com.google.dagger:dagger:2.47")
    implementation("com.google.dagger:dagger-android:2.47")
    implementation("com.google.dagger:dagger-android-support:2.47")

    kapt("com.google.dagger:dagger-compiler:2.47")
    annotationProcessor("com.google.dagger:dagger-compiler:2.47") //for java-based projects
    kapt("com.google.dagger:dagger-android-processor:2.47")
    annotationProcessor("com.google.dagger:dagger-android-processor:2.47")

    //JUnit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("junit:junit:4.13.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    //Espresso
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
    // To use the androidx.test.core APIs
    androidTestImplementation("androidx.test:core:1.5.0")
    // Kotlin extensions for androidx.test.core
    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    // To use the androidx.test.espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // To use the JUnit Extension APIs
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    // Kotlin extensions for androidx.test.ext.junit
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    // To use the Truth Extension APIs
    androidTestImplementation("androidx.test.ext:truth:1.5.0")
    // To use the androidx.test.runner APIs
    androidTestImplementation("androidx.test:runner:1.5.2")
    // To use android test orchestrator
    androidTestUtil("androidx.test:orchestrator:1.4.2")
    //for Activity and Fragment androidx.fragment.app.testing
    debugImplementation("androidx.fragment:fragment-testing:1.6.0")

    //mockk as mockito, powermock don't fully work with Kotlin
    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("io.mockk:mockk-android:1.13.5")
    testImplementation("io.mockk:mockk-agent:1.13.5")
    androidTestImplementation("io.mockk:mockk-android:1.13.5")
    androidTestImplementation("io.mockk:mockk-agent:1.13.5")

    //Cucumber
    testImplementation("io.cucumber:cucumber-java:7.13.0")
    testImplementation("io.cucumber:cucumber-junit:7.13.0")
    testImplementation("io.cucumber:cucumber-jvm:7.13.0")
    androidTestImplementation("io.cucumber:cucumber-java:7.13.0")
    androidTestImplementation("io.cucumber:cucumber-junit:7.13.0")
    androidTestImplementation("io.cucumber:cucumber-jvm:7.13.0")

}

kapt {
    correctErrorTypes = true
}

