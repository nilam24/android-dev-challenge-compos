package com.example.androiddevchallenge

data class ThemeDataModel(var imageTheme:Int,var titleTheme:String,var status:Boolean) {
    companion object{
        fun setThemeData():ArrayList<ThemeDataModel>{
            val list=ArrayList<ThemeDataModel>()
            val themeDataModel = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Desert chic",true)
            val themeDataModel2 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Tiny terrariums",false)
            val themeDataModel3 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Jungle vibes",false)
            val themeDataModel4 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Easy care",false)
            val themeDataModel5 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Statments",false)
            val themeDataModel6 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Monstera",false)
            val themeDataModel7 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Aglaonema",false)
            val themeDataModel8 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Peace lily",false)
            val themeDataModel9 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Fiddle leaf",false)
            val themeDataModel10 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Snake plant",false)
            val themeDataModel11 = ThemeDataModel(R.drawable.ic_dark_welcome_illos,"Pothos",false)

            list.add(themeDataModel)
            list.add(themeDataModel2)
            list.add(themeDataModel3)
            list.add(themeDataModel4)
            list.add(themeDataModel5)
            list.add(themeDataModel6)
            list.add(themeDataModel7)
            list.add(themeDataModel8)
            list.add(themeDataModel9)
            list.add(themeDataModel10)
            list.add(themeDataModel11)

            return list
        }
    }
}