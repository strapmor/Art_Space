package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.data.arts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var i by remember { mutableStateOf(0) }
    Box(Modifier.fillMaxSize().systemBarsPadding()){
        Column(Modifier
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Card(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    //.padding(15.dp)
            ){
                Image(
                    painter = painterResource(arts[i].imageResourseId),
                    contentDescription = stringResource(arts[i].name),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(width = 360.dp, height = 300.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .padding(10.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Card(
                Modifier
                .padding(15.dp)
            ){
                Column(
                    modifier = Modifier,
//            verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){


                    Column (
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally)
                    ){
                        Text(
                            text = stringResource(arts[i].name),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(5.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(arts[i].Author),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(5.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                if(i == 0){
                    i = arts.size-1
                }
                else
                    i--
            },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .width(150.dp)
                .offset(x = 5.dp, y = -25.dp)
        ){
            Row{
                Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = "back")
                Text(text = "Previous",
                    modifier = Modifier
                        .align(Alignment.CenterVertically))
            }

        }
        Button(
            onClick = {
                if(i == arts.size-1){
                    i = 0
                }
                else
                    i++
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .width(150.dp)
                .offset(x = -5.dp, y = -25.dp)
        ){
            Row{
                Text(text = "Next",
                    modifier = Modifier
                        .align(Alignment.CenterVertically))
                Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme(darkTheme = false) {
        ArtSpaceApp()
    }
}

@Preview//(showBackground = true)
@Composable
fun ArtSpacePreviewDark() {
    ArtSpaceTheme(darkTheme = true) {
        ArtSpaceApp()
    }
}