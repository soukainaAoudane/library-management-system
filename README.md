
# 📚 Library Management System

A complete Java-based library management system implementing Object-Oriented Programming principles for university library operations.

![Java](https://img.shields.io/badge/Java-17+-orange)
![OOP](https://img.shields.io/badge/Object--Oriented-Programming-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Complete-success)

## 🎯 Features

- **📖 Book Catalog Management** - Complete CRUD operations for books
- **👥 User Management** - Student and Professor accounts with differentiated rules
- **🔄 Borrowing System** - Automated borrow/return operations with real-time availability tracking
- **🔍 Advanced Search** - Multi-criteria search (title, author, publication year)
- **📊 Statistics & Analytics** - Genre-based statistics and borrowing analytics
- **⚡ Polymorphism** - Dynamic behavior based on user types

## 🚀 Quick Start

### Prerequisites
- Java JDK 8 or higher

### Compilation & Execution
```bash
# Compile all Java files
javac -d . src/com/Soukaina/Bibliotheque/*.java

# Run the demonstration
java com.Soukaina.Bibliotheque.TestBibliotheque
```

## 📊 Borrowing Rules

| User Type | Max Books | Special Rules |
|-----------|-----------|---------------|
| Student | 3 | Standard limit for all students |
| Tenured Professor | 10 | Higher limit for senior faculty |
| Non-Tenured Professor | 5 | Standard limit for junior faculty |

## 💻 Code Example

```java
// Create library system
Bibliotheque library = new Bibliotheque();

// Add a book to catalog
library.getCatalogue().ajouterLivre(
    new Livre("1984", "George Orwell", "978-0451524935", "Science-Fiction", true, 1949)
);

// Register a student
library.inscrireUtilisateur(
    new Etudiant("Dupont", "Jean", "ETU001", "Licence")
);

// Borrow a book
library.effectuerEmprunts("ETU001", "1984");
```

## 🛠️ Technical Implementation

### Object-Oriented Design Principles
- **Encapsulation** - Private attributes with public getters/setters
- **Inheritance** - Utilisateur abstract class extended by Etudiant and Professeur
- **Polymorphism** - Dynamic method dispatch based on user type
- **Abstraction** - Abstract methods for user-specific rules

### Key Classes
- **Livre** - Represents a book with title, author, ISBN, genre, availability status
- **Catalogue** - Manages book collection with search functionality
- **Utilisateur** - Abstract base class for all users
- **Bibliotheque** - Main system coordinator

## 🎮 Usage Demo

The system includes a comprehensive test class TestBibliotheque that demonstrates:
- Book catalog population
- User registration
- Borrowing operations
- Search functionality
- Statistics generation
- Limit enforcement

## 📈 Project Highlights

- ✅ **Complete OOP Implementation** - Inheritance, polymorphism, encapsulation
- ✅ **Real-world System Modeling** - University library use case
- ✅ **Error Handling** - Comprehensive validation and error messages
- ✅ **Modular Design** - Separated concerns and clean architecture
- ✅ **Professional Documentation** - Clear code structure and comments



## 👨‍💻 Author

**Soukaina**  
📧 aoudanesoukaina@gmail.com


---

⭐ If you find this project helpful, please give it a star!

