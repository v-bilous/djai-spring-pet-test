plugins {
	id("org.springframework.boot")
	id("com.google.cloud.tools.jib")

	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")
}

dependencies {
	implementation(project(":common"))

	implementation(kotlin("stdlib-jdk8"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("io.jsonwebtoken:jjwt:0.9.1")
	testImplementation("org.springframework.boot:spring-boot-test")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.testcontainers:junit-jupiter:1.14.3")
	testImplementation("org.testcontainers:mysql:1.14.3")
	testImplementation("com.h2database:h2:1.4.200")
	testImplementation(kotlin("test"))
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
}

jib {
	container {
		creationTime = "USE_CURRENT_TIMESTAMP"
	}
}
