// MainActivity.kt
// Save multiple phone numbers + send SMS to all

package com.example.anomx

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class MainActivity : AppCompatActivity() {

    private lateinit var phoneInput: EditText
    private lateinit var addButton: Button
    private lateinit var sendButton: Button
    private lateinit var listView: ListView

    private val phoneList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneInput = findViewById(R.id.phoneNumber)
        addButton = findViewById(R.id.addButton)
        sendButton = findViewById(R.id.triggerButton)
        listView = findViewById(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, phoneList)
        listView.adapter = adapter

        loadNumbers()
        requestPermissions()

        addButton.setOnClickListener {
            val phone = phoneInput.text.toString()

            if (phone.isNotEmpty()) {
                phoneList.add(phone)
                adapter.notifyDataSetChanged()
                saveNumbers()
                phoneInput.text.clear()
            }
        }

        sendButton.setOnClickListener {
            if (phoneList.isEmpty()) {
                Toast.makeText(this, "No numbers added", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sendAlertToAll()
        }
    }

    private fun requestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.SEND_SMS
        )
        ActivityCompat.requestPermissions(this, permissions, 1)
    }

    private fun saveNumbers() {
        val prefs = getSharedPreferences("contacts", Context.MODE_PRIVATE)
        prefs.edit().putStringSet("numbers", phoneList.toSet()).apply()
    }

    private fun loadNumbers() {
        val prefs = getSharedPreferences("contacts", Context.MODE_PRIVATE)
        val saved = prefs.getStringSet("numbers", emptySet())
        phoneList.clear()
        phoneList.addAll(saved!!)
    }

    private fun sendAlertToAll() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) return

        fusedLocationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            null
        ).addOnSuccessListener { location ->

            val message = if (location != null) {
                val lat = location.latitude
                val lon = location.longitude
                "Emergency! My location: https://maps.google.com/?q=$lat,$lon"
            } else {
                "Emergency! Location not available"
            }

            for (phone in phoneList) {
                try {
                    SmsManager.getDefault().sendTextMessage(phone, null, message, null, null)
                } catch (e: Exception) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("sms:$phone")
                    intent.putExtra("sms_body", message)
                    startActivity(intent)
                }
            }

            Toast.makeText(this, "Alert sent to all", Toast.LENGTH_SHORT).show()
        }
    }
}
