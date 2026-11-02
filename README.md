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

- **`FarmRepositroy.java:`** This is the data management layer (or data store) for our application.

---
