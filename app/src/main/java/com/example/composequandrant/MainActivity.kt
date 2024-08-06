package com.example.composequandrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequandrant.ui.theme.ComposeQuandrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuandrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuandrant()
                }
            }
        }
    }
}

@Composable
fun ColoredBox(
    backgroundColor: Color,
    heading: String,
    paragraph: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = heading,
            modifier=Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(text = paragraph)
    }
}

@Composable
fun ComposeQuandrant() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ColoredBox(
                Color(0xFFEADDFF),
                heading = stringResource(R.string.text_composable),
                paragraph = stringResource(R.string.para1),
                modifier = Modifier.weight(1f)
            )
            ColoredBox(
                Color(0xFFD0BCFF),
                heading = stringResource(R.string.image_composable),
                paragraph = stringResource(R.string.para2),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ColoredBox(
                Color(0xFFB69DF8),
                heading = stringResource(R.string.row_composable),
                paragraph = stringResource(R.string.para3),
                modifier = Modifier.weight(1f)
            )
            ColoredBox(
                Color(0xFFF6EDFF),
                heading = stringResource(R.string.column_composable),
                paragraph = stringResource(R.string.para4),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuandrantTheme {
        ComposeQuandrant()
    }
}