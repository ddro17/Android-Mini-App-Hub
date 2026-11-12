# Android Mini App Hub

A Kotlin Android coursework project that brings three small apps together in one menu: a calculator, a demo login form, and a cat GIF and sound selector.

Developed by [@ddro17](https://github.com/ddro17) for a Mobile Development course. The original Android app name is **Multi**.

## Features

| Screen | What it does |
| --- | --- |
| Main menu | Opens each demo in a separate Android activity using explicit intents. |
| Calculator | Accepts numeric input and performs addition, subtraction, multiplication, and division, with a clear button. |
| Login demo | Checks sample credentials and displays success or failure feedback using a Toast. Uses View Binding to access the form. |
| Cat selector | Displays three animated cat GIFs and plays a different sound for each selection using MediaPlayer. |

The app starts at the **main menu**. Login is a separate demonstration screen; it does not protect the other screens or connect to an authentication service.

### Demo login

- Username: `user`
- Password: `1234`

These are hardcoded sample values for the coursework demonstration. There is no account registration, database, or persistent login session.

## Technology

- Kotlin and Android SDK
- XML layouts, AndroidX AppCompat, Material Components, and CardView
- Explicit intents for activity navigation
- View Binding for the login form
- Android MediaPlayer and `android-gif-drawable` for audio and GIF playback
- Gradle Kotlin DSL with a version catalog

## Open and run

1. Clone this repository and open its root folder in Android Studio.
2. Use JDK 17 for Gradle and install Android SDK Platform 35 through the SDK Manager.
3. Let Android Studio sync the Gradle project.
4. Run the `app` configuration on an emulator or device with Android 13 / API 33 or later.

The saved project uses Android Gradle Plugin **8.6.1**, Gradle **8.7**, Kotlin **1.9.0**, and compile/target SDK **35**. See Android's [Java build requirements](https://developer.android.com/build/jdks) for Gradle JDK configuration.

Once the JDK and Android SDK are configured, you can also use the included Gradle wrapper:

```powershell
# Windows
.\gradlew.bat assembleDebug testDebugUnitTest
```

```bash
# macOS / Linux
./gradlew assembleDebug testDebugUnitTest
```

Android Studio creates `local.properties` for the SDK location on your computer. This file and generated build output are excluded from Git.

## Project structure

```text
app/src/main/
  AndroidManifest.xml
  java/com/example/multi/
    MainActivity.kt       # Menu and navigation
    calculator.kt         # Calculator input and operations
    loginapp.kt           # Sample login validation
    catselector.kt        # GIF screen and sound playback
  res/
    layout/               # XML layouts for the four screens
    drawable/             # Images and animated GIFs
    raw/                  # Audio clips
gradle/                   # Wrapper and dependency version catalog
```

## Verification and limitations

The published copy retains the coursework source and resources, with generated caches, build output, and machine-specific files removed. Packaging checks verified XML parsing, local resource references, activity declarations, and the included Gradle wrapper.

A fresh Android build and emulator run have **not** been verified for this upload because the preparation environment does not have a configured JDK or Android SDK. The included unit and instrumented tests are the original Android Studio examples; they do not establish feature coverage.

Suggested manual checks after building:

- Open all three demo screens from the menu and return with Android's Back action.
- Try `8 + 2`, `8 - 2`, `8 × 2`, and `8 ÷ 2`, and reset with `C`.
- Try both correct and incorrect demo login credentials.
- Play each cat sound, switch between selections, and leave the screen.

This is an introductory project. The calculator uses sequential two-operand arithmetic, displays `NaN` for division by zero, and has no decimal-entry button. Its current input is not explicitly saved across activity recreation. The cat screen is a user-controlled sound selector rather than a randomized game.

## Skills demonstrated

Building a multi-activity Android app, designing XML interfaces, wiring button events, passing control with intents, validating form input, and integrating animated images and audio playback.
