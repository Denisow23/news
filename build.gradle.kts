plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.flywaydb.flyway") version "8.5.0"
}

group = "ru.denisov"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")
	compileOnly("org.flywaydb:flyway-core")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql:42.7.5")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.mapstruct:mapstruct:1.5.3.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("net.javacrumbs.json-unit:json-unit:2.38.0")  // use it?
}

tasks.withType<Test> {
	useJUnitPlatform()
}

buildscript {
	dependencies {
		classpath("org.postgresql:postgresql:42.7.5")
	}
}

flyway {
	user= "postgres"
	password= "postgres"
	defaultSchema = "news_app"
	url= "jdbc:postgresql://localhost:5432/news_app"
	baselineOnMigrate = true
	installedBy = "DaDenisov"
}



