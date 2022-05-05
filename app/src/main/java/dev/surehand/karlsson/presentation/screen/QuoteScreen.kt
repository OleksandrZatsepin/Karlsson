package dev.surehand.karlsson.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import dev.surehand.karlsson.R

import dev.surehand.karlsson.presentation.ui.theme.Beige1
import kotlin.random.Random

@Composable
fun QuoteScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        DailyThought()
    }
}

@Composable
fun getRandomMessage(): String {
    val quotes = stringArrayResource(id = R.array.quotes)
    return quotes[Random.nextInt(quotes.size)]
}

@Composable
fun DailyThought(
    message: String = getRandomMessage(),
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(R.drawable.bg_1),
                contentScale = ContentScale.Crop)
            .padding(horizontal = 20.dp, vertical = 200.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Beige1
                )
                .alpha(0.5f)
                .align(Alignment.Center),
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .alpha(1.0f)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message.split("|")[0],
                    style = MaterialTheme.typography.h1
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                Text(
                    text = message.split("|")[1],
                    style = MaterialTheme.typography.h2
                )
            }
        }
    }
}