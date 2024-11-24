package com.example.artspace.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.artspace.R
import androidx.compose.ui.res.painterResource

data class Art (
    //val id: Int,
    @DrawableRes val imageResourseId: Int,
    @StringRes val name: Int,
    @StringRes val Author: Int
)

val arts = arrayOf(
    Art(R.drawable.bears, R.string.bears, R.string.bears_author),
    Art(R.drawable.vecherya, R.string.vecherya, R.string.vecherya_author),
    Art(R.drawable.vrubel_demon, R.string.demon, R.string.demon_author),
    Art(R.drawable.mona_lisa, R.string.mona_lisa, R.string.mona_lisa_author),
    Art(R.drawable.black_square, R.string.black_square, R.string.black_square_author),
    Art(R.drawable.persistence_of_memory, R.string.persistence, R.string.persistence_author),
    Art(R.drawable.the_great_wave_of_kanagawa, R.string.kanagawa, R.string.kanagawa_author)
)