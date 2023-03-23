package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        MainViewModel.setImageIds(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method

        supportFragmentManager

            .beginTransaction()
            .add(R.id.fragmentContainerView3, ImageDisplayFragment())
            .commit()
    }
   override fun itemSelected(itemId:Int){
        Toast.makeText(this,"You selected $itemId",Toast.LENGTH_SHORT).show()
    }
}