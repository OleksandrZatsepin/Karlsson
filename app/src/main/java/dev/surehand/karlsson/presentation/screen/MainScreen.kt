package dev.surehand.karlsson.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.surehand.karlsson.R
import dev.surehand.karlsson.presentation.navigation.BottomMenuContent
import dev.surehand.karlsson.presentation.ui.theme.*
import kotlin.random.Random

@Composable
fun MainScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        DailyThought()

        BottomMenu(
            items = listOf(
                BottomMenuContent(stringResource(R.string.menu_1), R.drawable.ic_quote),
                BottomMenuContent(stringResource(R.string.menu_2), R.drawable.ic_moon),
                BottomMenuContent(stringResource(R.string.menu_3), R.drawable.ic_music),
                BottomMenuContent(stringResource(R.string.menu_4), R.drawable.ic_profile),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
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
                .alpha(0.4f)
                .align(Alignment.Center),
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .alpha(0.9f)
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

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}