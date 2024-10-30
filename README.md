# Circuit Breaker Pattern in Microservices 

**Circuit Breaker Pattern Implementation with Spring Boot 3.3.2 and Resilience4j**

### Table of Contents
- [Description](#Description)
- [Configuration](#configuration)
- [Installation](#Installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Developer](#developer)

### Description
*As a passionate software developer, I crafted an exciting project using Spring Boot to be a Showcase of Circuit Breaker pattern. We have two microservices that are monitoring using resilence4j and we want to see how circuit breaker pattern can monitor and manage service requests to handle failures and prevent cascading failure.*

##### What is the Circuit Breaker Pattern in Microservices?
The Circuit Breaker pattern is like the superhero of fault tolerance in distributed systems. Imagine it as the vigilant guardian that stands between your services, preventing catastrophic failures and maintaining system stability. Here’s how it works:
  **1. Monitoring and Control:** The Circuit Breaker dynamically watches interactions between services. When it detects issues—like a service misbehaving or failing—it steps in.

 **2. Thresholds and Intervention:** If a service starts acting up (maybe it’s slow, throwing errors, or just having a bad day), the Circuit Breaker sets thresholds. If those thresholds are crossed, it temporarily interrupts requests to that service. Think of it as a timeout for unruly behavior.

  **3.	Preventing Cascading Failures:** By stopping requests to the failing service, the Circuit Breaker prevents cascading failures. You know, the kind where one service’s hiccup causes a domino effect across the entire system.

  **4.	Graceful Degradation:** Instead of letting everything collapse like a house of cards, the Circuit Breaker ensures graceful degradation. It might redirect requests to other services or provide fallback responses to clients.

  **5.	Automatic Recovery:** Once the failing service gets its act together (maybe it had a good cup of virtual coffee), the Circuit Breaker automatically transitions back to normal operation.

##### Advantages of the Circuit Breaker Pattern:
- **Fault Isolation:** Each microservice can fail independently without dragging down the whole system. It’s like letting that one colleague who’s always late for meetings miss their train without affecting the entire project.
- **Resilience:** By reverting to previously completed tasks, the system maintains its overall performance. It’s like having a backup plan when your primary plan goes haywire.
- **Prevents Overload:** When a service is already struggling, the Circuit Breaker prevents piling on more requests. No need to kick someone when they’re down, right?
- **Graceful Degradation:** It’s like turning down the music at a party when the neighbors complain. The system keeps functioning, albeit at a lower intensity.
- **Fallback Mechanisms:** Backup systems stay operational even when primary services are having a meltdown. It’s like having a spare umbrella when the weather forecast fails you.
- **Intelligent Error Handling:** The Circuit Breaker introduces smart error handling, making your microservice-based application more reliable and stable.

When it comes to implementing circuit breakers in Java, you have several excellent libraries to choose from. Let’s explore a few of them:
  1.	***Hystrix***:
	**Description**: Hystrix is like the seasoned veteran in the world of circuit breakers. Developed by Netflix, it has been battle-tested in large-scale microservices architectures.
	**Features**: Hystrix provides circuit breaker functionality along with features like fallback mechanisms, request caching, and metrics collection.
	**Integration**: If you’re working with Spring Boot, you can easily integrate Hystrix using the spring-cloud-starter-netflix-hystrix starter.
	**Tight Coupling**: Keep in mind that Hystrix is tightly coupled with Spring Cloud Netflix. While it’s powerful, switching to another circuit breaker implementation would require changes in your application.
2.	***Resilience4j***:
	**Description**: Resilience4j is a lightweight and modular library designed for functional programming. It’s gaining popularity due to its simplicity and flexibility.
	**Modules**: Resilience4j offers several core modules: 
	resilience4j-circuitbreaker: Circuit breaking
	resilience4j-ratelimiter: Rate limiting
	resilience4j-bulkhead: Bulkheading
	resilience4j-retry: Automatic retrying (both synchronous and asynchronous)
	resilience4j-timelimiter: Timeout handling
	resilience4j-cache: Result caching
	**Usage**: To use Resilience4j, add the spring-cloud-starter-circuitbreaker-resilience4j starter to your project. It’s a pluggable solution that allows you to switch implementations based on your needs.
3.	***Akka (Not Java-specific, but worth mentioning)***:
 **Description**: Akka is a toolkit and runtime for building highly concurrent, distributed, and fault-tolerant systems. While it’s not exclusively a circuit breaker library, it provides tools for managing failures and resilience.
 **Usage**: If you’re working with Akka-based systems, explore its supervision strategies and circuit breaker patterns.

The Circuit Breaker pattern is like having a trusty safety net for your distributed systems and microservices. It’s that friend who steps in when things get dicey, preventing catastrophic failures and maintaining overall system health. 

***Real-World Example***:
   A Real-World Example to understand Circuit Breaker pattern functionality:
	Picture an e-commerce website relying on multiple external payment gateways to process transactions. Now, if one of those gateways misbehaves (maybe it’s slow or downright unresponsive), the Circuit Breaker pattern comes to the rescue. It detects the failure and prevents the system from hammering the problematic gateway repeatedly. Instead, it can swiftly switch to alternative gateways or display a friendly error message to users. The rest of the website remains functional, and everyone’s happy. No resource exhaustion, no chaos—just smooth sailing.
	
## Configuration
resilience4j Configuration:
- **sliding-window-type**: The number of requests is recorded and aggregated in the last “sliding-window-size” seconds.
- **failure-rate-threshold**: The percentage of failed calls that trigger the CircuitBreaker state to open.
- **minimum-number-of-calls**: Records at least “minimum-number-of-calls” requests in the last “sliding-window-size” seconds before calculating the failure rate.
- **automatic-transition-from-open-to-half-open-enabled**: After ”wait-duration-in-open-state” seconds, Circuit Breaker will automatically transition from open to half-open state.
- **wait-duration-in-open-state**: If triggered, wait at least “wait-duration-in-open-state” seconds before allowing more calls.
- **permitted-number-of-calls-in-half-open-state**: After “wait-duration-in-open-state” time has passed, allow another “permitted-number-of-calls-in-half-open-state” requests and wait for them to calculate the failure rate again.
- **sliding-window-size**: Record the result of the last “sliding-window-size” seconds.
- **register-health-indicator**: Useful for monitoring the CircuitBreaker's state

## Installation
**Prerequisites**
- Install Git
- Install JDK 17 or higher 
- Install Maven 3.7.9 or higher
- Add **JAVA_HOME** and **Java path** to environment variables
- Add **MAVEN_HOME** and **Maven path** to environment variables
 
**Run Microservices**
- Clone **circuit-breaker-pattern-java** repository using `git clone https://github.com/Amirmasoud-Rahimi/circuit-breaker-pattern-java`
 
**Post-Service**
- Navigate to `post-service` Project Directory
- Build the project using `mvn clean install`
- Run the project using `mvn spring-boot:run`
- The `post-service` is accessible via <http://localhost:7070>
- H2 in-memory database console is accessible vai "http://localhost:7070/h2-console"
- Use *username* as **post** and *password* as **1234** to log in to h2-console
 
 **User-Service**
- Navigate to `user-service` Project Directory
- Build the project using `mvn clean install`
- Run the project using `mvn spring-boot:run`
- The `user-service` is accessible via <http://localhost:9090>
- H2 in-memory database console is accessible vai <http://localhost:9090/h2-console>
- Access <http://localhost:1010/actuator/health> to view Circuit Breaker details
- Use *username* as **user** and *password* as **1234** to log in to h2-console

## Usage
This is a sample project to show circiute breaker pattern concepts. We have two microservices (`post-service` , `user-service`) that are monitoring using resilence4j and we want to see how circuit breaker pattern can monitor and manage service requests to handle failures and prevent cascading failure. `post-service` recieves *userId* and returns the Post Entity that is related to User. and `user-service` recieves a *user id* and returns User entity with Post entity details.
After Start `user-service` and `post-service` access <http://localhost:1010/actuator/health> to view Circuit Breaker details:

```json
"circuitBreakers": {
      "status": "UP",
      "details": {
        "user-service": {
          "status": "UP",
          "details": {
            "failureRate": "37.5%",
            "failureRateThreshold": "50.0%",
            "slowCallRate": "0.0%",
            "slowCallRateThreshold": "5.0%",
            "bufferedCalls": 8,
            "slowCalls": 0,
            "slowFailedCalls": 0,
            "failedCalls": 3,
            "notPermittedCalls": 0,
            "state": "CLOSED"
          }
        }
      }
    }
  ```
  
Let's break down the properties related to circuit breakers in Spring Boot Actuator. These properties provide insights into how your microservices handle failures and protect themselves.

1. **`failureRate` and `failureRateThreshold`**:
   - The `failureRate` indicates the percentage of failed calls (requests) to a specific service.
   - The `failureRateThreshold` sets a limit beyond which the circuit breaker will trip.
   - For example, if the failure rate exceeds the threshold (e.g., 50%), the circuit breaker opens.

2. **`slowCallRate` and `slowCallRateThreshold`**:
   - The `slowCallRate` represents the percentage of slow calls (requests that take longer than expected).
   - The `slowCallRateThreshold` defines the maximum acceptable slow call rate.
   - If the slow call rate surpasses this threshold (e.g., 5%), the circuit breaker may take action.

3. **`bufferedCalls`**:
   - This property tracks the number of recent calls buffered by the circuit breaker.
   - Buffered calls are those that haven't yet been fully processed (either successful or failed).

4. **`slowCalls` and `slowFailedCalls`**:
   - `slowCalls` counts the number of calls that were slower than expected.
   - `slowFailedCalls` further refines this count by considering only the slow calls that eventually failed.

5. **`failedCalls`**:
   - Indicates the total number of calls that resulted in failure (e.g., exceptions, timeouts).
   - When this count exceeds a certain threshold, the circuit breaker opens.

6. **`notPermittedCalls`**:
   - Represents the number of calls rejected by the circuit breaker because it's in an open state.
   - During an open state, the circuit breaker prevents requests from reaching the failing service.

7. **`state`**:
   - Describes the current state of the circuit breaker.
   - Possible states include:
     - `CLOSED`: Normal operation, requests flow through.
     - `OPEN`: Circuit breaker is tripped, requests are blocked.
     - `HALF_OPEN`: Circuit breaker allows a few requests to check if the service has recovered.

Remember that these properties help you monitor and manage the resilience of your microservices. Adjust them based on your application's behavior and requirements.
### Circuit Breaker Challenging
Both services are running already.
1-Call `user-service` API 2 times <http://localhost:9090/user?userId=1>, then refresh the actuator link <http://localhost:1010/actuator/health>, we will see the change.now *bufferedCalls* is 3 .

2-Turn down post-service, call user-service API 4 times , then refresh the actuator link , we will notice now Circuit Breaker was triggered. the reason is that “failureRate” is now greater than “failure-rate-threshold”.

3-Wait for 5 seconds, refresh the actuator link , and we’ll see Circuit Breaker now is in HALF_OPEN state. Do you remember “wait-duration-in-open-state”? - The time that the Circuit Breaker should wait before transitioning from open to half-open)

4-During HALF_OPEN state, it allows “permitted-number-of-calls-in-half-open-state” requests (We configured its value as 3), then calculates the failure rate again, If the failure rate is still greater than “failure-rate-threshold”, Circuit Breaker will be triggered again. Continue calling user-service API 3 times , then refresh the actuator link.

5-Now run post-service, then continue calling user-service API 3 times , refresh the actuator link . we’ll see Circuit Breaker was closed.

## Endpoints
Controller | API route | Description | Request Example | Expected Response
--- | --- | --- | ---| --- |
Post-Service  | [GET] /post | Find Post By UserId |  <http://localhost:7070/post/1> | Post entity
Post-Service  |[GET] /post/serviceStatus | Change Service Status to Test Resilience4j |   <http://localhost:7070/post/serviceStatus/false> | String
User-Service  |[GET] /user | Get User By UserId  |<http://localhost:9090/user/1>|User entity
User-Service  |[GET] | Show Circuit Breaker Details |<http://localhost:9090/actuator/health>| JSON
## Developer
[**Amirmasoud Rahimi**](https://github.com/Amirmasoud-Rahimi)
