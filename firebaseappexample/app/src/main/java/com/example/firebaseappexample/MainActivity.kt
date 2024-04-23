package com.example.firebaseappexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseappexample.ui.theme.FirebaseappexampleTheme
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

public final data class Employee(
    val firstName: String = "",
    val lastName: String = ""
)


class MainActivity : ComponentActivity() {


    private lateinit var databaseReference: DatabaseReference
    private val TAG = "FirebaseExample"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Database
        val firebaseDatabase = Firebase.database
        databaseReference = firebaseDatabase.getReference("employees")

        setContent {
            FirebaseappexampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val database = Firebase.database
        val myRef = database.getReference("employee")
        val emp = Employee("Akbar", "Mohammed")
        myRef.push().setValue(emp)

        val myRef1 = database.getReference().child("employee")
        myRef1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (ds in snapshot.children) {
                    val emp = ds.getValue<Employee>()
                    if (emp != null) {
                        Log.d(
                            "MAINACTIVITY",
                            "First Name: ${emp.firstName}, Last Name: ${emp.lastName}"
                        )
                    } else {
                        Log.d("MAINACTIVITY", "Employee is null")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("MAINACTIVITY", "Failed to read value.", error.toException())
            }
        })
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseappexampleTheme {
        Greeting("Android")
    }
}
