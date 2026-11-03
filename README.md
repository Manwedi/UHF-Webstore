### URBAN HATCH ONLINE STORE

    Welcome to the official repository for the Urban Hatch Farms Online Store, a modern, fast, and secure e-commerce platform designed to bring premium, farm-fresh chicken straight to our customers' doors.
    
## 🏗️ PROJECT STRUCTURE & ARCHITECTURE

The application is built using **pure Java fundamentals** without heavy external frameworks. It follows a clean 4-tier modular architecture:

```text
D:\SOFTWARE\Websites\Urban Hatch Farms\
└── src\
    ├── domain\         <-- Core OOP Models (Entities, Records, Enums)
    ├── repository\     <-- Data Management & Java Collections
    ├── service\        <-- Business Logic & Validation Rules
    ├── web\            <-- Java HTTP Handlers & Web Interface
    └── Main.java       <-- Application Entry Point
```

---

## FEATURES

    Customer Experience

    • Freshness Tracker: Real-time logging from processing to delivery.
    • Smart Cart: Dynamic weight calculation and price breakdowns.
    • Subscription Boxes: Scheduled weekly or monthly protein deliveries.


## 📌 DEVELOPMENT PROGRESS

This project is purposely intended to implore the capabilities of Java to build a full GUI web application powered entirely by core OOP Fundamentals.
I know most people when they hear "Java for the web" they usually think of Spring Boot with HTML/JS templates and/or React, however in this project I would try to show that Java as a language itself has deep roots in server-driven architectures and native GUI component models that can render directly to the web or handle everything through pure Java objects. I intend to showcase it's capability and earn and strech my OOP skills, data structures and achitecture knowledge.   

### Phase 1: Domain Layer (OOP Foundations) - ✅ COMPLETED

Unlike a batch of chickens (which is mostly fixed data), an order has properties that can change over time—like its status (PENDING, COMPLETED, CANCELLED). Because of this mutable state, we'll use a traditional OOP Encapsulation pattern for the Order class, and an enum for the status.

- **`ChickenBatch.java`**: Immutable record representing broiler inventory (breed, stock, weight, pricing, market readiness). Includes custom total valuation methods.
- **`OrderStatus.java`**: Standardized lifecycle enum (`PENDING`, `COMPLETED`, `CANCELLED`).
- **`Order.java`**: Encapsulated order entity tracking customer details, batch references, timestamps, and order status.

### Phase 2: Repository Layer (Data Management) - ⏳ IN PROGRESS
In this section i will be developing an in-memory data store using Java ConcurrentHashMap and ArrayList so our app can safely hold and query data without needing an external database (as this ia a mock online store).

Instead of jumping straight in SQL databases I will build and in memory Repository using the Java Collections Framework which isn't only fast, it also separates data storage from business logic.

- **`ConcurrentHashMap:`** this is a thread safe map implementation for storinng chicken batches by ID(easier tracking).
- **`Collections.synchronizedList():`** this just wraps the ArrayList to prevent competing conditions when the User appends the orders.

- **`FarmRepository.java:`** This is the data management layer (or data store) for our application.
---

### Phase 3: Services (Logic and Validation)

Holds our business rules and logic (e.g., checking if there's enough stock left, calculating total pricing based on weight, verifying if a batch is ready for market, and executing an order transaction).

- **`Validation & Safety:`** If a customer tries to buy 500 birds when only 150 are left, the service throws an IllegalArgumentException and stops the transaction.
- **`Automatic Inventory Update:`** When an order goes through, it automatically subtracts the purchased birds from that specific batch so you never oversell.

- **`FarmService.java:`** This file mainly is for the business logic and validations.

### Phase 4: Server (Server side and GUI build)

In this section I will be using Java's in-built Http-Server (from the **`com.sun.net.httpserver package`**) this is the best way since am not required to use heavy frameworks for instance Spring Boot.

- **`WebServer.app:`** on the **`package app`** I will be building the native server for the web app and add the html code inside the java utilising the method override to parse the HTML GUI logic. This class will start a local server on port 7474, handle incoming HTTP requests, serve my inventory data as JSON/text, and process orders directly from a web browser.
- <img width="1917" height="1077" alt="image" src="https://github.com/user-attachments/assets/02a16999-a4af-4890-ac43-c53f21b98cac" />

I imported the com.sun.net.http dependencies to help run the native server. At this point I am stuck on debugging as my batchHandler is throwing errors I will document how I fixed this.

![alt text](image-1.png)

After thorough debugging a GUI mock up of the WebApp is working fine.

![alt text](image.png)
