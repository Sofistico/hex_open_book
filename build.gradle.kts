plugins {
    id("hex_open_book.java")
}


architectury {
    // this looks up the value from gradle/libs.versions.toml
    minecraft = libs.versions.minecraft.get()
}

tasks {
    register("runAllDatagen") {
        dependsOn(":forge:runCommonDatagen")
    }
}
