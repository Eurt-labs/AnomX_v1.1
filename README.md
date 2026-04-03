# 🚨 AnomX - Emergency Response System

AnomX is an elite, tactical-tier modern Emergency Response Application built natively for Android. With its ultra-minimalist Material-You inspired dark interface, AnomX strips away all bloatware to give users instant, uncompromising access to life-saving communication channels.

![AnomX Logo](app/src/main/res/drawable/ic_anomx_logo.png)

## 🛡️ Core Features

* **Multi-Channel SOS Blasting:** AnomX instantly bypasses standard dialing by broadcasting pre-compiled SOS strings—including high-precision Google Maps drop-pins—directly to registered contacts via SMS or Secure WhatsApp injection.
* **Kinetic Trigger (Shake to Alert):** Stuck in a situation where you can't unlock your screen? The built-in Foreground Service continuously samples your device's accelerometer. Violently shake the device twice within 3 seconds to auto-trigger the SOS silently from your pocket.
* **Live Dynamic Tracking Dashboard:** The app dashboard seamlessly embeds an active Google Map linked directly to your fused location providers, actively cross-referencing your GPS node coordinates (`Latitude` / `Longitude`) so you are never lost.
* **National Directory Database:** Includes a fully functional `.Intent.ACTION_DIAL` database covering all Indian National Emergency grids (Women's Helplines, Highway Transport, Disaster Management, etc.).

## ⚡ Advanced Security Modules (The Hub)

AnomX includes an exclusive suite of tactical features that can be toggled via the `Advanced Features` menu in the Options tab.

1. **Siren Overdrive Interface:** 
   * *Status:* **Active**
   * Overrides Android's `MediaAudioManager` to forcefully bypass Silent/DND modes, maxing out your device volume and blaring an aggressive 10-second CDMA Emergency Ringback distress siren to disarm attackers and alert bystanders.
2. **Last-Gasp Battery Ping:** 
   * *Status:* **Active**
   * Integrates silently into the Android OS via a hidden `BroadcastReceiver`. If AnomX detects your battery has hit the absolute critical threshold (usually 5-15%), it automatically retrieves an emergency GPS lock and transmits a final SOS letting your contacts know your phone is about to die and where you exactly are.
3. **Continuous GPS Looping (Breadcrumbs):**
   * *Status:* **In Development / Planned Module**
   * Will utilize a repeating execution thread to continuously ping your location every 3 minutes.
4. **Hardware SOS Bypass (Volume Keys):**
   * *Status:* **In Development / Planned Module**
   * Will integrate Accessibility nodes to allow you to rapidly click the physical Volume-Down rocker to blast an SOS.

## 📱 How to Use

1. **Add Emergency Contacts:** Upon launching the app, go to the contacts card. Enter a trusted phone number and hit `+`.
2. **Select Mode:** Toggle between `SMS Mode` (which blasts everyone on your list) or `WhatsApp` (which restricts to your absolute primary contact via deep linking).
3. **Arm the Kinetic Service:** Tap the `ON` button inside the **Shake to Alert** card. A silent notification will be pinned to your Android status bar proving the hardware accelerometer is actively guarding you.
4. **Manual Trigger:** In an emergency, smash the giant pink `EMERGENCY SOS` button. It will independently request your GPS lock, format the payload, and launch the alert.
5. **Advanced Hub:** Tap the 3 dots in the top right corner and open `Advanced Features`. Toggle `Siren Overdrive UI` to add the massive red Bypass Siren to your home screen!

## 🔧 Technical Requirements

* **Android SDK:** API 26+ (Android 8.0 Oreo and above)
* **Location Systems:** Requires `ACCESS_FINE_LOCATION` and `ACCESS_COARSE_LOCATION`
* **SMS Injection:** Requires `SEND_SMS`
* **Internet:** Required to render the dynamic Map Iframe constraint.

## 🤝 Support & Bug Reports
Encountering crashes? Reach out directly via the in-app Bug Report module (Located in `Options > About`) which will secure an encrypted WhatsApp bridge directly to the development pipeline.

---
*Built with ❤️ for public safety and security.*
