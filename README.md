# hello-java-android
[![Build Status](https://github.com/compscidr/hello-java-android/workflows/Gradle%20Build/badge.svg)](https://github.com/compscidr/hello-java-android/actions)&nbsp;
[![codecov](https://codecov.io/gh/compscidr/hello-java-android/branch/master/graph/badge.svg)](https://codecov.io/gh/compscidr/hello-java-android)&nbsp;

When starting a new project, I always find getting the tools up and running quickly is a pain, so I
wanted something for java / android which already had everything setup and working.

This is a WiP inspired by a similar repo for Kotlin / Android: https://github.com/compscidr/hello-kotlin-android

In order to get instrumented test coverage, I'm using an android emulator container which is linked
to a self-hosted runner container: https://jasonernst.com/posts/2021/08/08/Android-Emulator-with-Github-Actions-on-Linux.

The other option is to use macos github hosted runners (emulator needs gpu accel to run in a reasonable time)
but I'm cheap and the macos instances are expensive and use all my actions credits too quickly.

This aims to be a starter repo with all of the following tooling setup:
* [Github actions](https://github.com/marketplace/actions/gradle-android)
* [Junit5](https://junit.org/junit5/docs/current/user-guide/) (unit + integration tests)
* [Jacoco](https://www.eclemma.org/jacoco/)
* [Codecov](https://codecov.io/)