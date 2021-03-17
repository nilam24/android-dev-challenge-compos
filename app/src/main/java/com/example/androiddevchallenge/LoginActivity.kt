package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class LoginActivity : AppCompatActivity() {
    private val SURFACETAG="surface"
    private val TEXTLOGINEMAIL="log in with email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyAppLogin(isSystemInDarkTheme())
            }
        }
    }
    @Composable
    fun MyAppLogin(systemInDarkTheme: Boolean) {
        GetContext()
        if (systemInDarkTheme)
            MyAppLoginDark()
        else MyAppLoginLight()

    }
    private lateinit var context:Context
    @Composable
    fun GetContext(){
         context = MyContext.getInstance().getMyAppContext()

    }
   @Composable
    fun MyAppLoginDark(){
      MyConstraintViewDark()
    }

   @Composable
    fun MyAppLoginLight(){
         MyConstraintViewLight()
    }
//    @Composable
//    fun MyAppLoginLayoutView(){
//        val scaffoldState= rememberScaffoldState()
//       Scaffold(scaffoldState=scaffoldState) { it.calculateBottomPadding()
//           MyConstraintViewLight()
//       }
//    }
private var status:Boolean=false
    @Composable
    fun MyConstraintViewLight(){
        ConstraintLayout(constraintSet = ConstraintSet {

        }) {
            Column(
                modifier = Modifier
                    .testTag(SURFACETAG)
                    .fillMaxSize()
                    .background(
                        color = colorResource(
                            id = R.color.white
                        )
                    )
            ) {
                Text(
                    text = TEXTLOGINEMAIL,
                    modifier = Modifier.absolutePadding(100.dp,184.dp,16.dp,8.dp),
                    colorResource(id = R.color.gray),
                    style = typography.h1,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                )
                val email = remember{mutableStateOf(TextFieldValue())}
                TextField(value = email.value, onValueChange = {
                    email.value=it
                },
                modifier = Modifier
                    .absolutePadding(16.dp, 8.dp, 16.dp, 4.dp)
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.white)),

                placeholder={Text(text = "Email Address",modifier=Modifier.padding(all=8.dp),
                    //,alignment=TextAlign.Start,
                    style=typography.body1,
                    )},

                keyboardOptions=KeyboardOptions(capitalization = KeyboardCapitalization.None,autoCorrect = true,keyboardType = KeyboardType.Email),
                textStyle = TextStyle(colorResource(id = R.color.gray))
                )
                val pass = remember{ mutableStateOf(TextFieldValue())}

                TextField(value = pass.value, onValueChange = {
                    pass.value=it
                },modifier = Modifier
                    .absolutePadding(16.dp, 4.dp, 16.dp, 16.dp)
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.white)),

                    placeholder={ Text(text = "Password (8+characters)",modifier=Modifier.padding(all=8.dp))},
                    keyboardOptions=KeyboardOptions(capitalization = KeyboardCapitalization.None,autoCorrect = true,keyboardType=KeyboardType.Password),
                    textStyle = TextStyle(colorResource(id = R.color.gray)))

                Text(
                    text = stringResource(id = R.string.policyLine1),
                    modifier = Modifier
                        .absolutePadding(16.dp, 8.dp, 16.dp, 8.dp)
                        .fillMaxWidth(),
                    colorResource(id = R.color.gray),
                    style = typography.body2,textAlign = TextAlign.Center
                )

                Button(
                    modifier = Modifier
                        .absolutePadding(16.dp, 8.dp, 16.dp, 16.dp)
                        .height(56.dp)
                        .fillMaxWidth(),
                     colors=ButtonDefaults.buttonColors(colorResource(id = R.color.pink_900))
                    ,shape = RoundedCornerShape(
                        CornerSize(24.dp)
                    ),
                    onClick = {
                        if((email.value.text.isNotEmpty()) &&(pass.value.text.length>8)) {
                            val validEmail=emailValidator(email)
                            if(validEmail) {
                                showHome()
                            }
                            else{
                                status=true
                                showError(status)
                            }
                        }
                        else{
                            status=true
                            showError(status)
                        }
                    }
                ){
                    Text(text = TEXTLOGINEMAIL,color= colorResource(id = R.color.white),style = typography.button)
                }
                   
            }
        

        }
    }
    @Composable
    fun MyConstraintViewDark(){
        ConstraintLayout(constraintSet = ConstraintSet {

        }) {
            Column(
                modifier = Modifier
                    .testTag(SURFACETAG)
                    .fillMaxSize()
                    .background(
                        color = colorResource(
                            id = R.color.black
                        )
                    )
            ) {
                Text(
                    text = TEXTLOGINEMAIL,
                    modifier = Modifier.absolutePadding(100.dp,184.dp,16.dp,8.dp),
                    style = typography.h1,
                    color= colorResource(id = R.color.white),
                    textAlign = TextAlign.Center,
                    softWrap = true,
                )
                val email = remember{mutableStateOf(TextFieldValue())}
                TextField(value = email.value, onValueChange = {
                    email.value=it
                },
                    modifier = Modifier
                        .absolutePadding(16.dp, 8.dp, 16.dp, 4.dp)
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.black)),
                    placeholder={Text(text = "Email Address",modifier=Modifier.padding(all=8.dp)
                    )},

                    keyboardOptions=KeyboardOptions(capitalization = KeyboardCapitalization.None,autoCorrect = true,keyboardType = KeyboardType.Text),
                    textStyle = TextStyle(colorResource(id = R.color.white)),
                    shape= RoundedCornerShape(corner= CornerSize(4.dp))
                )
                val pass = remember{ mutableStateOf(TextFieldValue())}
                TextField(value = pass.value, onValueChange = {
                    pass.value=it
                },modifier = Modifier
                    .absolutePadding(16.dp, 4.dp, 16.dp, 16.dp)
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.black)),
                    placeholder={ Text(text = "Password(8+characters)",modifier=Modifier.padding(all=8.dp))},
                    keyboardOptions=KeyboardOptions(capitalization = KeyboardCapitalization.None,autoCorrect = true,keyboardType=KeyboardType.Text),
                    textStyle = TextStyle(colorResource(id = R.color.white)),
                    shape= RoundedCornerShape(corner= CornerSize(4.dp))
                )
                Text(
                    text = stringResource(id = R.string.policyLine1),
                    modifier = Modifier.absolutePadding(16.dp, 8.dp, 16.dp, 8.dp),
                    style = typography.body2,textAlign = TextAlign.Center,
                    softWrap = true,
                    color= colorResource(id = R.color.white)
                )
                Button(
                    modifier = Modifier
                        .absolutePadding(16.dp, 8.dp, 16.dp, 16.dp)
                        .height(56.dp)
                        .fillMaxWidth(),
                    colors=ButtonDefaults.buttonColors(
                        colorResource(id = R.color.green_300)),
                    shape = RoundedCornerShape(
                        CornerSize(24.dp)
                    ),
                    onClick = {
                        if((email.value.text.isNotEmpty()) &&(pass.value.text.length>8)) {
                            val validEmail=emailValidator(email)
                            if(validEmail) {
                                showHome()
                            }
                            else{
                                showError(true)
                            }
                        }
                        else{
                            showError(true)
                        }
                    }
                ){
                    Text(text = "Log in",color= colorResource(id = R.color.white),style = typography.button)
                }

            }


        }
    }

    private fun showError(b: Boolean):Boolean {
        Toast.makeText(context,context.resources.getString(R.string.error),Toast.LENGTH_LONG).show()
         return b
    }


    private fun showHome(){
        val intent = Intent(context,HomeActivity::class.java)
        context.startActivity(intent)
    }

//   @Composable
//    private fun ShowErrorMessage(){
//        Snackbar(modifier=Modifier.padding(8.dp),shape= RoundedCornerShape(corner = CornerSize(4.dp))) {
//            Text(text="Email and Password....")
//        }
//       // Toast.makeText(context,"Email and password field should not empty and password should be 8+characters long",Toast.LENGTH_LONG).show()
//    }
    private fun emailValidator(email:MutableState<TextFieldValue>):Boolean{
        var validEmail=false

        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.value.text).matches()){
            validEmail=true
        }

     return validEmail
    }

}