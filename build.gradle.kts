/*
 * Copyright 2019 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
    }
    dependencies {
        //https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
        classpath("com.android.tools.build:gradle:4.0.0-alpha03")

        //https://dl.bintray.com/kotlin/kotlin-eap/org/jetbrains/kotlin/kotlin-gradle-plugin/
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.60-eap-76")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
        maven{
            url = uri("http://www.jabylon.org/maven/")
        }
    }

    //skip Test tasks
    gradle.taskGraph.whenReady {
        tasks.forEach { task ->
            if (task.name.contains("lint")
                || task.name.contains("Aidl")
                || task.name.contains("mockableAndroidJar")
                || task.name.contains("test")
                || task.name.contains("Wear")
                || task.name.contains("UnitTest")
                || task.name.contains("AndroidTest")
            ) {
                task.enabled = false
            }
        }
    }

}
