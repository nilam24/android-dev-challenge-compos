package com.example.androiddevchallenge.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.androiddevchallenge.R


class FontFamilyData {
   val appFontFamily= FontFamily(fonts= listOf(Font(resId= R.font.nunitosansbold,weight= FontWeight.W700,
       ),
       Font(resId=R.font.nunitosanssemibold,weight = FontWeight.W600),
       (Font(resId=R.font.nunitosanslight,weight = FontWeight.W300))))
}