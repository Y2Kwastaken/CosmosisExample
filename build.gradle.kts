plugins {
    id("java")
    id("sh.miles.cosmosis") version "1.0.0-SNAPSHOT"
}

group = properties["maven_group"] as String
version = properties["mod_version"] as String
cosmosis.version = properties["cosmic_reach_version"] as String

repositories {
    cosmosis.repoBundle()
    maven("https://maven.miles.sh/snapshots/")
}

dependencies {
    cosmosis.devBundle()
}

tasks.processResources {
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(
            mapOf(
                "modid" to properties["modid"],
                "mod_name" to properties["mod_name"],
                "mod_version" to properties["mod_version"],
                "mod_license" to properties["mod_license"],
                "loader_version" to properties["loader_version"],
                "cosmic_reach_version" to properties["cosmic_reach_version"],
            )
        )
    }
}
