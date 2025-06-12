# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a starter Android project written in Java that demonstrates a complete CI/CD setup with testing, code coverage, and linting. It uses a Navigation Component architecture with MainActivity as the entry point and FirstFragment/SecondFragment for navigation.

## Architecture

- **Main Activity**: Uses ViewBinding and Navigation Component with AppBarConfiguration
- **Navigation**: Uses Navigation Component with nav_graph.xml for fragment transitions
- **Testing**: Dual testing approach with JUnit 5 for both unit tests and instrumented tests
- **Build System**: Gradle with Android Gradle Plugin, supports Java 21

## Common Commands

### Build and Test
- `./gradlew build` - Build the project
- `./gradlew test` - Run unit tests only
- `./gradlew connectedAndroidTest` - Run instrumented tests (requires emulator/device)
- `./gradlew connectedCheck && ./gradlew jacocoTestReport` - Generate complete test coverage reports

### Code Quality
- `./gradlew check` - Run all checks including lint and tests
- `./gradlew checkstyle` - Run checkstyle code style checks
- `./gradlew lint` - Run Android lint checks

### Coverage Reports
Three coverage reports are generated:
- Debug unit tests: `app/build/reports/jacoco/jacocoTestReportDebug`
- Release unit tests: `app/build/reports/jacoco/jacocoTestReportRelease`  
- Instrumented tests: `app/build/reports/coverage/androidTest/debug`

## Key Configuration

- **Java Version**: Java 21 (sourceCompatibility and targetCompatibility)
- **Min SDK**: 21, Target SDK: 34, Compile SDK: 34
- **Testing Framework**: JUnit 5 with AndroidJUnit5Builder for instrumented tests
- **Coverage**: Jacoco 0.8.13 with testCoverageEnabled for debug builds
- **Dependencies**: Uses AndroidX, Material Design, Navigation Component, Mockito

## Testing Structure

- Unit tests use JUnit 5 with `@Test` annotations
- Instrumented tests use `ActivityScenarioExtension` for testing Activities
- Both test types support Mockito for mocking
- Test coverage is enabled for debug builds only

## Renovate Configuration

The project uses Renovate for dependency updates with automerge enabled for minor and patch updates.