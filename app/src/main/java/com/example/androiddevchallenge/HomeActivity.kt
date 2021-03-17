package com.example.androiddevchallenge

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen(isSystemInDarkTheme())

            }
        }
    }

    @Composable
    fun MainScreen(systemInDarkTheme: Boolean) {
        if (systemInDarkTheme) {
            MainScreenForDark()
        } else {
            MainScreenForLight()
        }
    }

    @Composable
    fun MainScreenForDark() {
        val navController = rememberNavController()
        val bottomNavigationItem = BottomNavigationScreen.setBottomNavigationItem()
        Scaffold(
            backgroundColor = Color(R.color.green_900),
            bottomBar = { BloomAppBottomNavigationForDark(navController, bottomNavigationItem) }) {

            MainScreenNavigationConfigurationForDark(navController)
        }
    }

    @Preview
    @Composable
    fun MainScreenForLight() {
        val navController = rememberNavController()
        val bottomNavigationItem = BottomNavigationScreen.setBottomNavigationItem()
        Scaffold(
            backgroundColor = Color(R.color.offwhite),
            bottomBar = { BloomAppBottomNavigationForLight(navController, bottomNavigationItem) }) {

            MainScreenNavigationConfigurationForLight(navController)
        }
    }

    @Composable
    fun BloomAppBottomNavigationForDark(
        navController: NavHostController,
        bottomNavigationItem: List<BottomNavigationScreen>
    ) {
        BottomNavigation(
            modifier = Modifier
                .padding(0.dp)
                .height(56.dp)
                .fillMaxWidth(), backgroundColor = colorResource(
                id = R.color.green_900
            )

        ) {
            bottomNavigationItem.forEachIndexed { index, screen ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.res),
                            contentDescription = null,
                            modifier = Modifier.padding(0.dp)
                        )
                        //  Icon(imageVector = Icons.Filled.Fireplace,contentDescription = "fireplace")
                    },
                    label = {
                        Text(
                            text = screen.title,
                            modifier = Modifier,
                            color = colorResource(id = R.color.white),
                            style = TextStyle(fontSize = 13.sp, fontFamily = FontFamily.Monospace),
                            textAlign = TextAlign.Start
                        )
                    }, selected = selectedIndex == index, onClick = { selectedIndex = index })
            }
        }
    }

    @Composable
    fun BloomAppBottomNavigationForLight(
        navController: NavHostController,
        bottomNavigationItem: List<BottomNavigationScreen>
    ) {
        BottomNavigation(
            modifier = Modifier
                .padding(0.dp)
                .height(56.dp)
                .fillMaxWidth(),
            backgroundColor = colorResource(
                id = R.color.offwhite
            )
        ) {
            bottomNavigationItem.forEachIndexed { index, screen ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.res),
                            contentDescription = null,
                            modifier = Modifier.padding(0.dp)
                        )
                        //  Icon(imageVector = Icons.Filled.Fireplace,contentDescription = "fireplace")
                    },
                    label = {
                        Text(
                            text = screen.title,
                            modifier = Modifier,
                            color = Color(R.color.gray),
                            style = TextStyle(fontSize = 13.sp, fontFamily = FontFamily.SansSerif),
                            textAlign = TextAlign.Start
                        )
                    }, selected = selectedIndex == index, onClick = { selectedIndex = index })
            }
        }
    }

    private var selectedIndex = 1

    @Composable
    fun MainScreenNavigationConfigurationForDark(navController: NavController) {
        val themeDataModelListItem = ThemeDataModel.setThemeData()
        Surface(color = colorResource(id = R.color.black)) {

            Column(modifier = Modifier.fillMaxSize()) {
                SearchBarForDark()
                BrowseItemsForDark()
                DesignCardViewData(themeDataModelItemList = themeDataModelListItem)
                TitelUiForDark()
                HomeGardenListViewData(
                    modifier = Modifier,
                    themeDataModelItemList = themeDataModelListItem
                )
            }
        }
    }

    @Composable
    fun MainScreenNavigationConfigurationForLight(navController: NavController) {
        val themeDataModelListItem = ThemeDataModel.setThemeData()
        Surface(color = colorResource(id = R.color.white)) {

            Column(modifier = Modifier.fillMaxSize()) {
                SearchBarForLight()
                BrowseItemsForLight()
                DesignCardViewData(themeDataModelItemList = themeDataModelListItem)
                TitelUiForLight()
                HomeGardenListViewData(
                    modifier = Modifier,
                    themeDataModelItemList = themeDataModelListItem
                )
            }
        }
    }

    @Composable
    fun SearchBarForDark() {
        val searchRes = remember { mutableStateOf(TextFieldValue()) }
        Surface {
            Box(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .height(56.dp)
                    .fillMaxSize()
                    .background(color = colorResource(R.color.black))
            ) {


                TextField(value = searchRes.value,
                    onValueChange = {
                        searchRes.value = it
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text
                    ),
                    textStyle = TextStyle(colorResource(id = R.color.white), fontSize = 14.sp),

                    placeholder = {
                        Text(
                            text = "Search",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.absolutePadding(32.dp, 0.dp, 0.dp, 0.dp)
                        )
                    })
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_white_search_24),
                    modifier = Modifier.absolutePadding(16.dp, 16.dp, 16.dp, 8.dp),
                    alignment = Alignment.CenterStart,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )


            }
        }
    }

    @Composable
    fun SearchBarForLight() {
        val searchRes = remember { mutableStateOf(TextFieldValue()) }
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .height(56.dp)
                .fillMaxWidth(),
            color = colorResource(id = R.color.offwhite)
        ) {
            Box(
                modifier = Modifier
                    .padding(all = 0.dp)
                    .fillMaxHeight()
                    .fillMaxSize()

            )

            {

                TextField(value = searchRes.value,
                    onValueChange = {
                        searchRes.value = it
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text
                    ),
                    textStyle = TextStyle(colorResource(id = R.color.gray), fontSize = 14.sp),
                    placeholder = {
                        Text(
                            text = "Search",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.absolutePadding(32.dp, 0.dp, 0.dp, 0.dp)
                        )
                    })
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    modifier = Modifier.absolutePadding(16.dp, 16.dp, 16.dp, 8.dp),
                    alignment = Alignment.CenterStart,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )


            }
        }
    }

    @Composable
    fun BrowseItemsForDark() {

        Text(
            text = "Browse themes",
            modifier = Modifier.absolutePadding(16.dp, 0.dp, 0.dp, 8.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(color = colorResource(id = R.color.white), fontSize = 18.sp)
        )
    }

    @Composable
    fun BrowseItemsForLight() {
        Text(
            text = "Browse themes",
            modifier = Modifier.absolutePadding(16.dp, 0.dp, 0.dp, 8.dp),
            textAlign = TextAlign.Start,
            style = TextStyle(color = Color(R.color.gray), fontSize = 18.sp)
        )
    }

    @Composable
    fun DesignCardViewData(
        modifier: Modifier = Modifier,
        themeDataModelItemList: List<ThemeDataModel>
    ) {
        LazyRow(modifier = Modifier,
            state = rememberLazyListState(),
            reverseLayout = false,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            content = {
                items(items = themeDataModelItemList, itemContent = { data ->
                    val themeDataModel = data
                    if (isSystemInDarkTheme()) {
                        DesignCardElementForDark(themeDataModel = themeDataModel)

                    } else {
                        DesignCardElementForLight(themeDataModel)
                    }

                })
            })
    }
    @Composable
    fun ImageLoad(){
        var c=MyContext.getInstance()
        var p= Picasso.get().load("").centerCrop().get()
        var d=p as Drawable
        d.minimumHeight
        d.minimumWidth
    }

    @Composable
    fun DesignCardElementForDark(themeDataModel: ThemeDataModel) {
        Card(
            shape = RoundedCornerShape(CornerSize(8.dp)), modifier = Modifier
                .absolutePadding(16.dp, 8.dp, 2.dp, 16.dp)
                .height(136.dp)
                .width(136.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = themeDataModel.imageTheme),
                    modifier = Modifier
                        .absolutePadding(0.dp, 0.dp, 0.dp, 8.dp)
                        .height(96.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Inside,
                    contentDescription = null,
                    alignment = Alignment.TopCenter
                )
                Text(
                    text = themeDataModel.titleTheme, modifier = Modifier
                        .absolutePadding(16.dp, 4.dp, 8.dp, 8.dp)
                        .fillMaxSize(), textAlign = TextAlign.Center, style = TextStyle(
                        color = colorResource(
                            id = R.color.white
                        ), fontSize = 14.sp
                    )
                )

            }
        }
    }

    @Composable
    fun DesignCardElementForLight(themeDataModel: ThemeDataModel) {

        Card(
            shape = RoundedCornerShape(CornerSize(8.dp)), modifier = Modifier
                .absolutePadding(16.dp, 8.dp, 2.dp, 16.dp)
                .height(136.dp)
                .width(136.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = themeDataModel.imageTheme),
                    modifier = Modifier
                        .absolutePadding(0.dp, 0.dp, 0.dp, 8.dp)
                        .height(96.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Inside,
                    contentDescription = null,
                    alignment = Alignment.TopCenter
                )
                Text(
                    text = themeDataModel.titleTheme, modifier = Modifier
                        .absolutePadding(16.dp, 4.dp, 8.dp, 8.dp)
                        .fillMaxSize(), textAlign = TextAlign.Center, style = TextStyle(
                        color = colorResource(
                            id = R.color.gray
                        ), fontSize = 14.sp
                    )
                )

            }
        }
    }

    @Composable
    fun HomeGardenListViewData(modifier: Modifier, themeDataModelItemList: List<ThemeDataModel>) {
        LazyColumn(modifier = Modifier,
            state = LazyListState(),
            reverseLayout = false,
            verticalArrangement = Arrangement.Top,
            content = {
                items(items = themeDataModelItemList) { data ->
                    HomeGardenUi(data)
                }
            })

    }

    @Composable
    fun HomeGardenUi(dataModellist: ThemeDataModel) {
        if (isSystemInDarkTheme()) {
            ImageListForDark(dataModellist = dataModellist)
        } else {
            ImageListForLight(dataModellist = dataModellist)
        }
    }

    @Composable
    fun TitelUiForDark() {
        Row(
            modifier = Modifier
                .padding(16.dp, 0.dp, 0.dp, 8.dp)
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Design your home garden",
                modifier = Modifier.absolutePadding(16.dp, 24.dp, 16.dp, 8.dp),
                style = TextStyle(fontSize = 18.sp),
                color = colorResource(
                    id = R.color.white
                ),
                textAlign = TextAlign.Start
            )
            Image(
                modifier = Modifier
                    .absolutePadding(64.dp, 24.dp, 16.dp, 0.dp)
                    .fillMaxHeight()
                    .width(32.dp),
                painter = painterResource(id = R.drawable.ic_baseline_filter_white_list_24),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopEnd
            )
        }
    }

    @Preview
    @Composable
    fun TitelUiForLight() {
        Row(
            modifier = Modifier
                .padding(16.dp, 0.dp, 0.dp, 8.dp)
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Design your home garden",
                modifier = Modifier.absolutePadding(16.dp, 24.dp, 16.dp, 8.dp),
                style = TextStyle(fontSize = 18.sp),
                color = colorResource(
                    id = R.color.gray
                ),
                textAlign = TextAlign.Start
            )
            Image(
                modifier = Modifier
                    .absolutePadding(64.dp, 24.dp, 16.dp, 0.dp)
                    .fillMaxHeight()
                    .width(32.dp),
                painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopEnd
            )
        }
    }

    @Composable
    fun ImageListForDark(dataModellist: ThemeDataModel) {
        Row(
            modifier = Modifier
                .absolutePadding(16.dp, 0.dp, 0.dp, 4.dp)
                .height(64.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = dataModellist.imageTheme),
                modifier = Modifier
                    .absolutePadding(0.dp, 0.dp, 0.dp, 2.dp)
                    .height(64.dp)
                    .width(64.dp)
                    .background(color = Color(R.color.green_300)),
                alignment = Alignment.TopStart,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Design your home garden",
                    modifier = Modifier.absolutePadding(0.dp, 0.dp, 0.dp, 0.dp),
                    style = TextStyle(
                        color = colorResource(
                            id = R.color.white
                        ), fontSize = 13.sp
                    ),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Design your home garden",
                    modifier = Modifier.absolutePadding(0.dp, 0.dp, 0.dp, 0.dp),
                    style = TextStyle(
                        color = colorResource(
                            id = R.color.white
                        ), fontSize = 10.sp
                    ),
                    textAlign = TextAlign.Start
                )

            }
            Checkbox(
                modifier = Modifier.absolutePadding(56.dp, 24.dp, 16.dp, 24.dp),
                checked = dataModellist.status,
                onCheckedChange = {
                    if (it)
                        check(true)
                })

        }
        Divider(
            color = colorResource(R.color.white),
            thickness = 0.5.dp,
            modifier = Modifier.absolutePadding(88.dp, 0.dp, 24.dp, 0.dp)
        )
    }
}

@Composable
fun ImageListForLight(dataModellist: ThemeDataModel) {
    Row(
        modifier = Modifier
            .absolutePadding(16.dp, 0.dp, 0.dp, 4.dp)
            .height(64.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = dataModellist.imageTheme),
            modifier = Modifier
                .absolutePadding(0.dp, 0.dp, 0.dp, 2.dp)
                .height(64.dp)
                .width(64.dp)
                .background(color = Color(R.color.green_300)),
            alignment = Alignment.TopStart,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Design your home garden",
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 0.dp, 0.dp),
                style = TextStyle(
                    color = colorResource(
                        id = R.color.gray
                    ), fontSize = 13.sp
                ),
                textAlign = TextAlign.Start
            )
            Text(
                text = "Design your home garden",
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 0.dp, 0.dp),
                style = TextStyle(
                    color = colorResource(
                        id = R.color.gray
                    ), fontSize = 10.sp
                ),
                textAlign = TextAlign.Start
            )
        }
        Checkbox(
            modifier = Modifier.absolutePadding(56.dp, 24.dp, 16.dp, 24.dp),
            checked = dataModellist.status,
            onCheckedChange = {
                if (it)
                    check(true)
            })


    }
}
