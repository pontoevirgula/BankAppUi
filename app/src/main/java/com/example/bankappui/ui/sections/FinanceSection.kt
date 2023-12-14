package com.example.bankappui.ui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappui.data.FinanceCard
import com.example.bankappui.ui.theme.BlueStart
import com.example.bankappui.ui.theme.GreenStart
import com.example.bankappui.ui.theme.OrangeStart
import com.example.bankappui.ui.theme.PurpleStart

private val financeCardList = listOf(
    FinanceCard(
      image = Icons.Rounded.Star,
      name = "My \nBusiness",
      background = OrangeStart
    ),
    FinanceCard(
      image = Icons.Rounded.Wallet,
      name = "My \n Wallet",
      background = BlueStart
    ),
    FinanceCard(
      image = Icons.Rounded.StarHalf,
      name = "Finance \nAnalysis",
      background = PurpleStart
    ),
    FinanceCard(
        image = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    ),
)

@Preview
@Composable
fun FinanceSection(){
    Text(
        text = "Finanças",
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
    LazyRow{
        items(financeCardList.size){index->
            FinanceCardItem(index)
        }
    }
}

@Composable
fun FinanceCardItem(index: Int) {
    val financeCard = financeCardList[index]
    var lastPaddingItem = 0.dp
    if (index == financeCardList.size - 1){
        lastPaddingItem = 16.dp
    }

    Box(
        modifier =  Modifier
            .padding(start = 16.dp, end = lastPaddingItem)
    ){
        Column(
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(financeCard.background)
                .padding(6.dp)
            ){
                Icon(
                    imageVector = financeCard.image,
                    contentDescription = financeCard.name,
                    tint = Color.White
                )
            }
            Text(
                text = financeCard.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        }
    }
}
