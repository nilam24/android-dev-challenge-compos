package com.example.androiddevchallenge

import android.graphics.drawable.Drawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.twotone.Home
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavigationScreen(var title: String, var icon:ImageVector, var res: Int) {

    companion object{
        fun setBottomNavigationItem() : ArrayList<BottomNavigationScreen>{

            val list = ArrayList<BottomNavigationScreen>()
            val bottomNavigationScreen =
                BottomNavigationScreen("Home",Icons.TwoTone.Home , R.drawable.ic_action_home)
            val bottomNavigationScreen2 = BottomNavigationScreen(
                "Favorite",
                Icons.Filled.Favorite,
                R.drawable.ic_favorite_border_black
            )
            val bottomNavigationScreen3 =
                BottomNavigationScreen("Profile", Icons.Filled.AccountCircle, R.drawable.ic_action_profile)
            val bottomNavigationScreen4 =
                BottomNavigationScreen("Cart", Icons.Outlined.ShoppingCart, R.drawable.ic_action_cart)

            list.add(bottomNavigationScreen)
            list.add(bottomNavigationScreen2)
            list.add(bottomNavigationScreen3)
            list.add(bottomNavigationScreen4)
            return list
        }
    }
}

