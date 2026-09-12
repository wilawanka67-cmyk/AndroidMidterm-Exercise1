package com.androidmidterm.exercise1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()
        setContent {
            MaterialTheme {
                StudentProfileScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun StudentProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val compact = maxHeight < 600.dp
            val screenPadding = if (compact) 8.dp else 32.dp
            val photoWidth = if (compact) 240.dp else 280.dp
            val photoHeight = if (compact) 160.dp else 210.dp
            val titleStyle = if (compact) {
                MaterialTheme.typography.titleLarge
            } else {
                MaterialTheme.typography.headlineSmall
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = screenPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ข้อสอบมิดเทอม Android สมัยใหม่",
                    style = titleStyle,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "ข้อที่ 1 Activity Lifecycle",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(
                        top = if (compact) 2.dp else 8.dp,
                        bottom = if (compact) 8.dp else 24.dp
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.student_photo),
                    contentDescription = "รูปนักศึกษา วิลาวัณย์ การุณ",
                    modifier = Modifier
                        .size(photoWidth, photoHeight)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "วิลาวัณย์ การุณ",
                    style = titleStyle,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = if (compact) 8.dp else 24.dp)
                )
                Text(
                    text = "รหัสนักศึกษา 67102122101",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = if (compact) 2.dp else 6.dp)
                )
            }
        }
    }
}
