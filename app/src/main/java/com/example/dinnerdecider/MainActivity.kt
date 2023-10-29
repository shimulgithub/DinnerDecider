package com.example.dinnerdecider

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dinnerdecider.ui.theme.DinnerDeciderTheme
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : ComponentActivity() {
    var foodlist = arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton.setOnClickListener { value ->
            addNewFood(newFoodText.text.toString())
            newFoodText.text.clear()
            val toast = Toast.makeText(applicationContext,"New Food Added!", Toast.LENGTH_SHORT)
            toast.show()
        }

        decideButton.setOnClickListener { value ->
            nameText.text = getRandomFood()
        }

        nameText.text = getRandomFood()
    }

    fun getRandomFood():String{
        return foodlist.random()
    }

    fun addNewFood(value:String?){
        if (value == null) { return }
        var _value = value?:""
        foodlist.add(_value)
    }
}