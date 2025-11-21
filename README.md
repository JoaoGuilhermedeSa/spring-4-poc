# Spring Boot 4.0 PoC

This project is a Proof of Concept (PoC) demonstrating the new features introduced in Spring Boot 4.0 (and Spring Framework 7.0.1). 

## Features

This project showcases several new and important features of Spring Boot 4.0.0 and its ecosystem:

*   **Spring Boot 4.0.0:** The project is built using the latest major version of Spring Boot, which was released in November 2025.
*   **Java 17:** The codebase is written in Java 17, which is the new baseline for Spring Boot 4.0.
*   **Declarative HTTP Client:** The main feature of this PoC is the new declarative HTTP client, which allows you to define a client as a Java interface.
*   **Resilience:** Retry and new features got incorporated to core into resilience package.
*   **Spring Framework 7.0.1:** This is the underlying framework that provides the core features of Spring.
*   **`@HttpExchange`:** This annotation is used to turn an interface into a declarative HTTP client. It's a more modern and flexible alternative to `@FeignClient`.
*   **`HttpServiceProxyFactory`:** This class is used to create a proxy instance of the declarative HTTP client interface.
*   **`WebClientAdapter`:** This class is the bridge between the declarative HTTP client and the reactive `WebClient`. It adapts the `WebClient` to be used by the `HttpServiceProxyFactory`.

## How to Run

To run this project, you will need:
*   Java Development Kit (JDK) 17 or higher
*   Apache Maven

Follow these steps:

1.  **Clone the repository (if you haven't already):**
    ```bash
    git clone <repository-url>
    cd spring-4-poc
    ```
2.  **Compile the project:**
    ```bash
    ./mvnw clean compile
    ```
3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application should start and be accessible, typically on `http://localhost:8080`.