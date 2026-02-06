# Splitwise-Like Expense Settlement System (Java)

A Java-based expense settlement system inspired by Splitwise that minimizes the number of transactions required to settle shared expenses among multiple users. The system uses a **Greedy Minimum Cash Flow algorithm** optimized with **Priority Queues (Heaps)** to achieve efficient and scalable settlements.

---

##  Features

- Calculates net balance for each user from raw expense transactions
- Minimizes total number of money transfers
- Optimized using **PriorityQueue (Heap)** for faster performance
- Clean, modular, and interview-ready Java implementation
- No external dependencies required

---

## Algorithm & Approach

### Approach Used
- **Greedy Algorithm**

### Algorithm
- **Minimum Cash Flow Algorithm**

### Optimization
- Uses two heaps:
  - Max Heap for creditors (users who should receive money)
  - Min Heap for debtors (users who should pay money)

At each step, the algorithm settles the maximum possible amount between the highest creditor and highest debtor, ensuring the minimum number of transactions.

---

## Time & Space Complexity

| Metric | Complexity |
|------|-----------|
| Time Complexity | O(N log N) |
| Space Complexity | O(N) |

---

##  Tech Stack

- Java
- Core Java Collections (`HashMap`, `PriorityQueue`)
- Greedy Algorithms

---

##  How to Run

### 1. Compile
```bash
javac Splitwise.java
