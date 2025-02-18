plugins {
    java
}

group = "com.bsejawal"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.6")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
