import sh.miles.cosmosis.core.DriverType

plugins {
    id("java")
    id("sh.miles.cosmosis") version "2.0.0-SNAPSHOT"
}

group = properties["maven_group"] as String
version = properties["mod_version"] as String

repositories {
    maven("https://maven.miles.sh/snapshots/")
}

dependencies {
}

tasks.runCosmicTools {
    driver = DriverType.FIREFOX
}

tasks.copyCosmicReach {
    version = "0.1.8"
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
