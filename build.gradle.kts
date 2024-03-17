plugins {
    id("java")
    id("sh.miles.cosmosis") version "1.0.1-SNAPSHOT"
}

group = properties["maven_group"] as String
version = properties["mod_version"] as String
cosmosis.version = properties["cosmic_reach_version"] as String

cosmosis.repoBundle()
cosmosis.devBundle()

tasks.runClient {
    launcherFileGeneric = "launch"
}

tasks.downloadLoader {
    this.loaderLink = uri("https://github.com/ForwarD-NerN/CosmicReach-Mod-Loader/releases/download/latest/cosmicreach-fabric-modloader.zip").toURL()
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
