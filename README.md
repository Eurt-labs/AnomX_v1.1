# 🚨 AnomX - Personal Safety App

AnomX is a simple, fast, and reliable personal safety application built for Android. It strips away complicated menus to give you instant access to life-saving communication channels when you need them most.

![AnomX Logo](app/src/main/res/drawable/ic_anomx_logo.png)

## 🛡️ Core Features

* **Quick SOS Alerts:** Send emergency alerts with your exact Google Maps location to your trusted contacts via SMS or WhatsApp with a single tap.
* **Shake to Alert:** If you can't reach your screen, just shake your phone twice to securely step sending an SOS message directly from your pocket.
* **Live Location Tracking:** The app's main screen shows a live map tracking your current location so you always know exactly where you are.
* **Emergency Contact Directory:** Includes a built-in list of national emergency services (Women's Helplines, Ambulances, Disaster Management) so you can call for help instantly.

## ⚡ Extra Features

AnomX includes extra safety features that can be turned on via the `Advanced Features` menu in the app.

1. **Low Battery SOS Ping:** 
   * *Status:* **Active**
   * Automatically sends a final SOS message with your location if your phone battery drops very low (around 10%), letting your emergency contacts know your phone is about to turn off.
2. **Live GPS Auto-Updates:**
   * *Status:* **In Development**
   * Instead of sending your location just once, the app will keep updating and sending your new location to your trusted contacts every 3 minutes so you can be easily tracked.

## 📱 How to Use

1. **Add Emergency Contacts:** Open the app and go down to the contacts sections. Type a trusted phone number and press `+`.
2. **Select Mode:** Choose between `SMS Mode` (which sends texts to everyone on your list) or `WhatsApp` (which sends a message to your primary contact via WhatsApp).
3. **Turn on Shake to Alert:** Tap the `ON` button inside the **Shake to Alert** card. A small icon will appear at the top of your phone letting you know it's actively guarding you in the background.
4. **Trigger an SOS:** In an emergency, tap the large pink `EMERGENCY SOS` button, or shake your phone twice rapidly.
5. **Turn on Extra Features:** Tap the 3 dots in the top right corner and open `Advanced Features` to enable the low battery ping or continuous tracking!

## 🔧 Technical Requirements

* **Android SDK:** API 26+ (Android 8.0 Oreo and above)
* **Location Systems:** Requires `ACCESS_FINE_LOCATION` and `ACCESS_COARSE_LOCATION`
* **SMS Injection:** Requires `SEND_SMS`
* **Internet:** Required to render the dynamic Map Iframe constraint.

## 🤝 Support & Bug Reports
Encountering crashes? Reach out directly via the in-app Bug Report module (Located in `Options > About`) which will secure an encrypted WhatsApp bridge directly to the development pipeline.

---
*Built with ❤️ for public safety and security.*
