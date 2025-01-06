plugins {
    application
    id("com.gradleup.shadow") version "8.3.1"
}

application.mainClass = "com.chipset.Bot" //
group = "org.example"
version = "1.0"

val jdaVersion = "5.2.2" //

repositories {
    mavenCentral()
    maven(url = "https://m2.chew.pro/releases")
    maven(url = "https://maven.lavalink.dev/releases")
}

dependencies {
    implementation("net.dv8tion:JDA:$jdaVersion")
    implementation("pw.chew:jda-chewtils:2.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.reflections:reflections:0.10.2")
    implementation("dev.arbjerg:lavaplayer:2.2.2")
    implementation("dev.lavalink.youtube:v2:1.11.3")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true

    // Set this to the version of java you want to use,
    // the minimum required for JDA is 1.8
    sourceCompatibility = "16"
}