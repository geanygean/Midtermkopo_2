package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm2.ui.theme.Midterm2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // State for managing selected image
    var selectedImage by remember { mutableStateOf(R.drawable.slime) }

    // State for managing selected text
    var selectedText by remember { mutableStateOf("") }

    // State for managing original image
    var originalImage by remember { mutableStateOf(selectedImage) }

    // State for managing original text
    var originalText by remember { mutableStateOf(selectedText) }

    // State for managing selected option
    var selectedOption by remember { mutableStateOf(0) }

    // State for managing visibility of buttons
    var showButtons by remember { mutableStateOf(true) }

    // State for managing user input text
    var userInputText by remember { mutableStateOf("") }

    // Function to switch to the "hehee" image and text
    fun switchToHehee() {
        selectedImage = R.drawable.rimuru
        selectedText = "Hi, my name is Ayaka Nice to meet you $userInputText"
    }

    // Function to switch to the "wp8352490" image and text
    fun switchToWp8352490() {
        selectedImage = R.drawable.benimaru
        selectedText = "Is there anything you need traveler $userInputText"
    }

    // Function to switch to the "xioa" image and text
    fun switchToXioa() {
        selectedImage = R.drawable.shunari
        selectedText = "Hello It's been a while since a last saw you $userInputText"
    }

    // Function to switch to the "xioa2" image and text
    fun switchToXioa2() {
        selectedImage = R.drawable.shion
        selectedText = "Do you need my help again  $userInputText"
    }

    // Function to switch to "klee" image and text
    fun switchToKlee() {
        selectedImage = R.drawable.diablo
        selectedText = "Klee says: $userInputText"
    }

    // Function to switch to "klee2" image and text
    fun switchToKlee2() {
        selectedImage = R.drawable.millim
        selectedText = "Klee2 says: $userInputText"
    }

    // Function to switch to the original image and text
    fun switchToOriginal() {
        selectedImage = originalImage
        selectedText = originalText
    }

    Midterm2Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display selected image with royal blue background and adjusted size
                Image(
                    painter = painterResource(id = selectedImage),
                    contentDescription = "Your Image",
                    modifier = Modifier
                        .height(600.dp) // Adjusted height
                        .width(500.dp)  // Adjusted width
                        .background(color = Color.Cyan)
                )

                // Display selected text with adjusted text size
                Text(
                    text = selectedText,
                    fontSize = 20.sp // Adjusted text size
                )

                // Row for selection buttons
                if (showButtons) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Option button 1 - Switch to hehee image and text
                        SelectionButton(
                            text = "Character 1",
                            isSelected = selectedOption == 1,
                            onClick = {
                                selectedOption = 1
                                switchToHehee()
                                showButtons = false // Hide other buttons
                            }
                        )

                        // Option button 2 - Switch to xioa image and text
                        SelectionButton(
                            text = "Character 2",
                            isSelected = selectedOption == 2,
                            onClick = {
                                selectedOption = 2
                                switchToXioa()
                                showButtons = false // Hide other buttons
                            }
                        )

                        // Option button 3 - Switch to klee image and text
                        SelectionButton(
                            text = "Character 3",
                            isSelected = selectedOption == 3,
                            onClick = {
                                selectedOption = 3
                                switchToKlee()
                                showButtons = false // Hide other buttons
                            }
                        )
                    }

                    // Text field for user input
                    TextField(
                        value = userInputText,
                        onValueChange = { userInputText = it },
                        label = { Text("Enter text") },
                        modifier = Modifier.padding(top = 16.dp) // Add padding to separate from buttons
                    )
                } else {
                    // Additional functionality for Option 2 when showButtons is false
                    if (!showButtons && selectedOption == 2) {
                        // Button to switch to xioa2 image and text
                        Button(onClick = {
                            switchToXioa2()
                        }) {
                            Text(text = "Next Xioa")
                        }

                        // Button to switch to original image and text
                        Button(onClick = {
                            switchToOriginal()
                            showButtons = true // Show option buttons again
                        }) {
                            Text(text = "Main Option")
                        }
                    } else if (!showButtons && selectedOption == 3) {
                        // Additional functionality for Option 3 when showButtons is false
                        // Button to switch to klee2 image and text
                        Button(onClick = {
                            switchToKlee2()
                        }) {
                            Text(text = "Next Klee")
                        }

                        // Button to switch to original image and text
                        Button(onClick = {
                            switchToOriginal()
                            showButtons = true // Show option buttons again
                        }) {
                            Text(text = "Main Option")
                        }
                    } else {
                        // Button to switch to wp8352490 image and text
                        Button(onClick = {
                            switchToWp8352490()
                        }) {
                            Text(text = "next")
                        }

                        // Button to switch to original image and text
                        Button(onClick = {
                            switchToOriginal()
                            showButtons = true // Show option buttons again
                        }) {
                            Text(text = "Main Option")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SelectionButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors() // Use default button colors
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Midterm2Theme {
        MyApp()
    }
}
