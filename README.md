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

## 📌 DEVELOPMENT PROGRESS

    In this section i will be developing an in-memory data store using Java ConcurrentHashMap and ArrayList so our app can safely hold and query data without needing an external database (as this ia a mock online store).

### Phase 1: Domain Layer (OOP Foundations) - ✅ COMPLETED
- **`ChickenBatch.java`**: Immutable record representing broiler inventory (breed, stock, weight, pricing, market readiness). Includes custom total valuation methods.
- **`OrderStatus.java`**: Standardized lifecycle enum (`PENDING`, `COMPLETED`, `CANCELLED`).
- **`Order.java`**: Encapsulated order entity tracking customer details, batch references, timestamps, and order status.

### Phase 2: Repository Layer (Data Management) - ⏳ IN PROGRESS

---

## FEATURES

    Customer Experience

    • Freshness Tracker: Real-time logging from processing to delivery.
    • Smart Cart: Dynamic weight calculation and price breakdowns.
    • Subscription Boxes: Scheduled weekly or monthly protein deliveries.