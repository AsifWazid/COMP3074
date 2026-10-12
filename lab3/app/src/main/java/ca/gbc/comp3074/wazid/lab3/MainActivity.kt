package ca.gbc.comp3074.wazid.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.wazid.lab3.ui.theme.Lab3Theme

data class Message(
    val name: String,
    val message: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab3Theme {
                MessageList()
            }
        }
    }
}

@Composable
fun MessageList() {

    val messages = listOf(
        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test...1...2...3"),
        Message("Joe", "I hate coding!!!"),
        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test...1...2...3"),
        Message("Joe", "I hate coding!!!"),
        Message("Joe", "Hi!"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test...1...2...3"),
        Message("Joe", "I hate coding!!!")
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFF7FF))
                .padding(paddingValues)
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(messages) { message ->
                MessageItem(message)
            }
        }
    }
}

@Composable
fun MessageItem(message: Message) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.Top
    ) {

        //Avatar
        Spacer(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Column {

            //Name
            Text(
                text = message.name,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            //Message bubble
            Text(
                text = message.message,
                fontSize = 12.sp,
                modifier = Modifier
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color.White)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
            )
        }
    }
}