package com.example.conversionam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMeters;
    private TextView textViewError;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextMeters = findViewById(R.id.editTextMeters);
        textViewError = findViewById(R.id.textViewError);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set click listener for the convert button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input value from the EditText
                String input = editTextMeters.getText().toString().trim();

                // Clear previous error message
                clearError();

                // Check if the input is empty
                if (input.isEmpty()) {
                    showError("Please enter a value.");
                    return;
                }

                try {
                    // Parse the input to double
                    double meters = Double.parseDouble(input);

                    // Check if the input is negative
                    if (meters < 0) {
                        showError("Value cannot be negative.");
                        return;
                    }

                    // Perform conversion from meters to millimeters
                    double millimeters = meters * 1000;

                    // Display the result
                    textViewResult.setText(String.format("%.2f meters = %.2f millimeters", meters, millimeters));
                } catch (NumberFormatException e) {
                    // Handle parsing error (non-numeric input)
                    showError("Invalid input. Please enter a valid number.");
                } finally {
                    // Clear the input field after conversion
                    editTextMeters.getText().clear();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            // Start the AboutActivity when the About menu item is clicked
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
            return true;
        } else if (id == R.id.action_settings) {
            // Show dialog box with contact information
            showContactDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Method to show dialog box with contact information
    private void showContactDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contact");
        builder.setMessage("Email: am32669n@pace.edu\nFeel free to contact if you have any suggestions");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    // Method to show error message
    private void showError(String errorMessage) {
        textViewError.setText(errorMessage);
        textViewError.setVisibility(View.VISIBLE);
    }

    // Method to clear the error message
    private void clearError() {
        textViewError.setVisibility(View.GONE);
    }
}


