plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "net.micode.notes"
    compileSdk = 34 // 修改：改为目前稳定的 34 (或 35)

    defaultConfig {
        applicationId = "net.micode.notes"
        minSdk = 25 // 修改：改为 24 (支持 Android 7.0+)，千万不要写 36
        targetSdk = 34 // 修改：与 compileSdk 保持一致
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
        sourceCompatibility = JavaVersion.VERSION_17 // 建议：升级为 17
        targetCompatibility = JavaVersion.VERSION_17 // 建议：升级为 17
    }

    // 保留 Apache HTTP 兼容库（小米便签老代码可能依赖）
    useLibrary("org.apache.http.legacy")
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)

    // 建议：如果项目中有 ViewPager, RecyclerView 等，可能需要补充以下依赖
    // implementation(libs.recyclerview)
    // implementation(libs.viewpager2)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}