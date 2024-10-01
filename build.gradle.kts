plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.serialization") version "2.0.20"

	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "io.github.michael_bailey"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation ("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.54.0")
	implementation("org.springframework.boot:spring-boot-starter-graphql")

	// kotlin reflect
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// xml serialisation?
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// json serialisation
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")

	// service management
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	// database management
	implementation("org.xerial:sqlite-jdbc:3.46.1.1")
	implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.54.0")

	// testing stuff
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
