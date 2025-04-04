import java.net.URI

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

rootProject.name = "Picontest"
include(":app")
include(":designsystem")
include(":features")
include(":domain")
include(":data")
include(":core")
