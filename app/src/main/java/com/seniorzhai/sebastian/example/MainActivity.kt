package com.seniorzhai.sebastian.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seniorzhai.sebastian.Sebastian
import kotlinx.android.synthetic.main.activity_main.bn

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    bn.setOnClickListener {
      Sebastian.hello()
    }
  }
}
