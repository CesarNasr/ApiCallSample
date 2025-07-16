# Safe REST API Call in Android with Kotlin Coroutines

This is a sample Android application that demonstrates how to safely make REST API calls using Kotlin, Coroutines, and a sealed result wrapper pattern.

The app showcases a clean and reusable architecture for error-handled API calls.

## 🛠️ Tech Stack

- **Kotlin**
- **Coroutines**
- **Retrofit**
- **MVVM Architecture**
- **Sealed Classes for Result Wrapping**
- **StateFlow**
- **Jetpack Components**

## ✅ Features

- Simple UI to fetch and display data from a remote API.
- Safe REST API call handling using a sealed class (`ApiResult`) and coroutine `suspend` functions.
- Clean separation of concerns (Data, Domain, UI).
- Extensible pattern for real-world apps (e.g., error types, loading states).

## 🧱 Architecture

This project follows a basic **MVVI (Model-Intent-ViewModel)** structure

