package dev.surehand.karlsson.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import dev.surehand.karlsson.R
import dev.surehand.karlsson.common.Constants.BASE_URL
import dev.surehand.karlsson.common.Constants.IMAGE_SIZE
import kotlin.random.Random

@ExperimentalMaterial3Api
@Composable
fun ImageCard(
//    title: String,
//    description: String,
    modifier: Modifier = Modifier
) {
    val message: String = getRandomMessage()
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = "${BASE_URL}${Random.nextInt()}${IMAGE_SIZE}"
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = message.split("|")[0],
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message.split("|")[1],
                style = MaterialTheme.typography.titleMedium
            )
//            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun getRandomMessage(): String {
    val quotes = stringArrayResource(id = R.array.quotes)
    return quotes[Random.nextInt(quotes.size)]
}