# Java 8 Features with Use Cases

Welcome to the Java 8 Features repository! This repository contains various Java 8 features demonstrated through practical use cases. The examples cover a wide range of scenarios, helping you understand and apply these features in real-world applications.

## Table of Contents

- [Introduction](#introduction)
- [Features and Use Cases](#features-and-use-cases)
    - [Streams API](#streams-api)
    - [Optional Class](#optional-class)
    - [Lambda Expressions](#lambda-expressions)
    - [Functional Interfaces](#functional-interfaces)
    - [Date and Time API](#date-and-time-api)
    - [Collections Enhancements](#collections-enhancements)
- [Usage](#usage)

## Introduction

Java 8 introduced several powerful features that make code more readable, concise, and efficient.
This repository showcases these features through detailed use cases. Each example is designed to 
demonstrate the practical application of Java 8 features in various scenarios,
such as banking systems, inventory management, hotel reservations, and more.

## Features and Use Cases

### Streams API

The Streams API provides a functional approach to processing sequences of elements. This section includes examples of:

- **Filtering and Mapping**: Transforming and filtering data using `map`, `filter`, and other stream operations.
- **Sorting**: Sorting elements using `sorted`.
- **Reduction**: Aggregating data using `reduce`.
- **Matching**: Checking conditions on elements using `anyMatch`, `allMatch`, and `noneMatch`.

### Optional Class

The `Optional` class provides a way to handle null values gracefully. Examples in this section demonstrate:

- **Creating Optionals**: Using `Optional.of`, `Optional.ofNullable`, and `Optional.empty`.
- **Retrieving Values**: Using `get`, `orElse`, `orElseGet`, and `orElseThrow`.
- **Conditional Actions**: Using `ifPresent`.
- **Transformations**: Using `map` and `flatMap`.

### Lambda Expressions

Lambda expressions provide a concise way to represent anonymous functions. This section includes examples of:

- **Functional Programming**: Using lambda expressions to pass behavior as an argument to methods.
- **Event Handling**: Simplifying event handling code with lambda expressions.

### Functional Interfaces

Functional interfaces are interfaces with a single abstract method, and they are the basis for lambda expressions. Examples include:

- **Custom Functional Interfaces**: Creating and using custom functional interfaces.
- **Built-in Functional Interfaces**: Using `Predicate`, `Function`, `Consumer`, and `Supplier`.

### Date and Time API

The new Date and Time API provides a comprehensive set of classes for date and time manipulation. Examples in this section demonstrate:

- **LocalDate and LocalTime**: Working with dates and times.
- **Temporal Adjusters**: Adjusting dates to specific values.
- **Duration and Period**: Measuring time spans.

### Collections Enhancements

Java 8 introduced several enhancements to the Collections framework. This section includes examples of:

- **forEach**: Iterating over collections using `forEach`.
- **Map Enhancements**: Using `merge`, `computeIfAbsent`, and other new methods in the `Map` interface.
- **Concurrent Collections**: Enhancements to concurrent collections.

## Usage

To run the examples in this repository, you need to have Java 8 installed on your system. 
You can compile and run the Java files using your preferred IDE or the command line.

