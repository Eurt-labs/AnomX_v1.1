package com.example.anomx

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.card.MaterialCardView

class AdvancedDashboardActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_dashboard)

        val toolbar = findViewById<Toolbar>(R.id.toolbarAdvanced)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        prefs = getSharedPreferences("adv_settings", MODE_PRIVATE)

        val cardBattery = findViewById<MaterialCardView>(R.id.cardBattery)
        val cardBreadcrumbs = findViewById<MaterialCardView>(R.id.cardBreadcrumbs)
        val cardVolKeys = findViewById<MaterialCardView>(R.id.cardVolKeys)

        setupCardToggle(cardBattery, "opt_battery")
        setupCardToggle(cardBreadcrumbs, "opt_breadcrumbs")
        setupCardToggle(cardVolKeys, "opt_volkeys")
    }

    private fun setupCardToggle(card: MaterialCardView, prefKey: String) {
        val isActive = prefs.getBoolean(prefKey, false)
        updateCardVisuals(card, isActive)

        card.setOnClickListener {
            val currentState = prefs.getBoolean(prefKey, false)
            val newState = !currentState
            prefs.edit().putBoolean(prefKey, newState).apply()
            updateCardVisuals(card, newState)
        }
    }

    private fun updateCardVisuals(card: MaterialCardView, isActive: Boolean) {
        if (isActive) {
            card.setCardBackgroundColor(Color.parseColor("#381E72"))
            card.strokeColor = Color.parseColor("#D0BCFF")
            card.alpha = 1.0f
        } else {
            card.setCardBackgroundColor(Color.parseColor("#141218"))
            card.strokeColor = Color.parseColor("#4A4458")
            card.alpha = 0.5f
        }
    }
}
