# Architecture Decision Records

This document records significant architectural decisions made during the development of SetLens.

## ADR-001: Choose Koin for Dependency Injection

### Context

SetLens is currently an Android application, but the project anticipates a possible future Kotlin
Multiplatform (KMP) transition that could include iOS. Choosing an Android-only dependency-injection
framework could require replacing it during that transition.

### Decision

Use Koin for dependency injection. Koin supports the current Android application and provides a path
compatible with the anticipated KMP direction.

### Alternatives Considered

- **Hilt:** Considered for Android dependency injection, but it does not provide the intended KMP
  path and could require a later migration.

### Consequences

- **Benefits:** Avoids choosing an Android-only DI framework while keeping dependency injection
  available to the current app.
- **Trade-offs:** Uses Koin-specific setup and APIs in the Android application; the anticipated KMP
  transition is not yet implemented.
