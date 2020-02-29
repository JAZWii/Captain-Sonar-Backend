val home = System.getProperty("user.home")!!
var sfs2xPath: String = "$home/SmartFoxServer_2X/SFS2X"

group = "com.speda"
//version = "0.0.1"


plugins {
    `java-library-distribution`
    kotlin("jvm") version "1.3.61"
}


repositories {
    mavenCentral()
    flatDir { dirs("$sfs2xPath/lib") }
}

dependencies {
    compileOnly(":sfs2x")
    compileOnly(":sfs2x-core")

    implementation(kotlin("stdlib-jdk8"))
}

val copyLibraries = tasks.register<Copy>("copyLibraries") {
    from(file("$buildDir/install/${project.name}/lib/"))
    into(file("$sfs2xPath/extensions/__lib__/"))
    dependsOn("installDist")
}

val copyExtension = tasks.register<Copy>("copyExtension") {
    from(file("$buildDir/install")) {
        exclude("${project.name}/lib")
    }
    into(file("$sfs2xPath/extensions"))
    dependsOn("installDist")
}

val buildExtension = tasks.create("buildExtension") {
    group = "build"
    dependsOn("copyExtension", "copyLibraries")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}