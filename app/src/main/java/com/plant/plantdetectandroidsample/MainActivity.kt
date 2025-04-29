package com.plant.plantdetectandroidsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.plant.plantdetectandroidsample.ui.theme.PlantDetectAndroidSampleTheme
import com.plant.plantdetectsdk.PlantEventListener

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantDetectAndroidSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(Modifier.padding(innerPadding))
                }
            }
        }

        PlantEventListener.getInstance().observerNotification {
            print("Notification: $it")
            // Open Notification Activity
            val intent = Intent(this, NotificationActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        PlantEventListener.getInstance().unregisterObserver()
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = androidx.compose.ui.platform.LocalContext.current // Get context here

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello Android!", modifier = Modifier.padding(vertical = 16.dp))

        Button(onClick = {
            // Navigate to SecondActivity
            val intent = Intent(context, PlantActivity::class.java)
            intent.putExtra("userToken", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjU2YzdlZTAxYmFiYWNjM2ZlZDgwMDk0OTZhY2QxNWY0NWQyZGE3NTEifQ.eyJhdF9oYXNoIjoibXJBZFc4VUJOTl9aWDlDUGtuR3hyQSIsImF1ZCI6Im1lZXJhLWFwcHMiLCJlbWFpbCI6ImFkbWluQGV4YW1wbGUuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImV4cCI6MTc0NDk1NjY0NCwiaWF0IjoxNzQ0ODcwMjQ0LCJpc3MiOiJodHRwczovL3Nzby5zdGFnaW5nLm1hZndyLmdvdi5vbSIsIm1vYmlsZSI6IiIsIm1vYmlsZV92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJyb290Iiwibm9uY2UiOiIiLCJzaWQiOiJhRnB3aXVpM2syNFl0UXFrUVU5UkZRIiwic291cmNlIjoibG9jYWwiLCJzdWIiOiJDaVF3T0dFNE5qZzBZaTFrWWpnNExUUmlOek10T1RCaE9TMHpZMlF4TmpZeFpqVTBOallTQld4dlkyRnMifQ.XJEtNQtepADnCS1Gezt67Ngq3rPlsOrDzZ8n6TaXtOHR1N5xWn4yqwNjSNrrsvF-RQblkF73PqsI7Hdz7r6yYbz1up_arv0x3I032zeDrfAuZ6DY_Z-P3II0o5dJ8c9c6W_NguC9O3Cn9pT-wQqc5n1gr68yrNYksz0U84nsbhWH-EpC59QUgkDxq98uVlnqfT0Tir4ujOyZQS1F5jKEpt2c8bCkeHq5xwG-h14JgQSOhoJaVTQX7qMyTnB5CpWk6MWAY7njOXppz1_oFK8Woqf6AkUckJMOuLVFOobJJy8EidIt6RekbXAbhhq1XkTgt_HBAXKPZX_C3-G0QL28OA")
            intent.putExtra("baseUrl", "https://apis.staging.mafwr.gov.om/")
            intent.putExtra("notifCount", 2)
            intent.putExtra("module", "plant")
            intent.putExtra("language", "en")
            context.startActivity(intent)
        }) {
            Text(text = "Plant")
        }

        Button(onClick = {
            // Navigate to SecondActivity
            val intent = Intent(context, PlantActivity::class.java)
            intent.putExtra("userToken", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjU2YzdlZTAxYmFiYWNjM2ZlZDgwMDk0OTZhY2QxNWY0NWQyZGE3NTEifQ.eyJhdF9oYXNoIjoibXJBZFc4VUJOTl9aWDlDUGtuR3hyQSIsImF1ZCI6Im1lZXJhLWFwcHMiLCJlbWFpbCI6ImFkbWluQGV4YW1wbGUuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImV4cCI6MTc0NDk1NjY0NCwiaWF0IjoxNzQ0ODcwMjQ0LCJpc3MiOiJodHRwczovL3Nzby5zdGFnaW5nLm1hZndyLmdvdi5vbSIsIm1vYmlsZSI6IiIsIm1vYmlsZV92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJyb290Iiwibm9uY2UiOiIiLCJzaWQiOiJhRnB3aXVpM2syNFl0UXFrUVU5UkZRIiwic291cmNlIjoibG9jYWwiLCJzdWIiOiJDaVF3T0dFNE5qZzBZaTFrWWpnNExUUmlOek10T1RCaE9TMHpZMlF4TmpZeFpqVTBOallTQld4dlkyRnMifQ.XJEtNQtepADnCS1Gezt67Ngq3rPlsOrDzZ8n6TaXtOHR1N5xWn4yqwNjSNrrsvF-RQblkF73PqsI7Hdz7r6yYbz1up_arv0x3I032zeDrfAuZ6DY_Z-P3II0o5dJ8c9c6W_NguC9O3Cn9pT-wQqc5n1gr68yrNYksz0U84nsbhWH-EpC59QUgkDxq98uVlnqfT0Tir4ujOyZQS1F5jKEpt2c8bCkeHq5xwG-h14JgQSOhoJaVTQX7qMyTnB5CpWk6MWAY7njOXppz1_oFK8Woqf6AkUckJMOuLVFOobJJy8EidIt6RekbXAbhhq1XkTgt_HBAXKPZX_C3-G0QL28OA")
            intent.putExtra("baseUrl", "https://apis.staging.mafwr.gov.om/")
            intent.putExtra("notifCount", 2)
            intent.putExtra("module", "farm")
            intent.putExtra("language", "en")
            context.startActivity(intent)
        }) {
            Text(text = "Animal")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    PlantDetectAndroidSampleTheme {
        MainScreen()
    }
}