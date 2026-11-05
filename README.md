# Tafelbeest

Offline-first Dutch multiplication practice for primary-school children. Built as a lightweight web app and Android WebView APK.

## Build the Android APK
Open **Actions → Build Tafelbeest APK → Run workflow**. Download the `tafelbeest-debug-apk` artifact from the completed run and install `app-debug.apk` on the Android device.

The app stores progress locally on the device. No account or internet connection is required to play.

## Learning approach
Each multiplication fact is tracked separately. Incorrect answers reduce mastery and increase future practice frequency. Correct but slow answers also count as not-yet-automatic, while fast correct answers build mastery. The app tracks average response time and uses weighted selection to bring weaker facts back more often.
