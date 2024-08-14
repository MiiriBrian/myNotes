plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
   id("androidx.navigation.safeargs")
}



android {
    namespace = "com.example.mynotes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mynotes"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
          packagingOptions {
        exclude ("META-INF/gradle/incremental.annotation.processors")
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
        dataBinding = true
    }
}
configurations.all {
    resolutionStrategy {
        force("org.jetbrains:annotations:23.0.0")
    }


    dependencies {

        implementation(libs.androidx.core.ktx) {
            exclude(group = "com.intellij", module = "annotations")
        }
        implementation(libs.androidx.appcompat)
        {
            exclude(group = "com.intellij", module = "annotations")
        }
        implementation(libs.material)
        {
            exclude(group = "com.intellij", module = "annotations")
        }
        implementation(libs.androidx.activity)
        {
            exclude(group = "com.intellij", module = "annotations")
        }
        implementation(libs.androidx.constraintlayout)
        {
            exclude(group = "com.intellij", module = "annotations")
        }
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        // ROOM DB

        implementation(libs.androidx.room.runtime)
        {
            exclude(group = "com.intellij", module = "annotations")
        }
        ksp(libs.androidx.room.compiler.v252)


        // Coroutines
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.androidx.room.ktx)

        // Navigation

        implementation(libs.androidx.navigation.fragment.ktx)

        implementation(libs.androidx.navigation.ui.ktx)


        // ViewModel
        implementation(libs.androidx.lifecycle.viewmodel.ktx)

        // LiveData
        implementation(libs.androidx.lifecycle.livedata.ktx)

        // Annotation processor
        implementation(libs.androidx.lifecycle.compiler)
    }
}