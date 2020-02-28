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

val copyDist = tasks.register<Copy>("copyDist") {
    from(file("$buildDir/install"))
    into(file("$sfs2xPath/extensions"))
    dependsOn("installDist")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    build{
        dependsOn("copyDist")
    }
}