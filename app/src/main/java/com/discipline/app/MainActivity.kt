package com.discipline.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.discipline.app.ui.theme.DisciplineTheme
import com.discipline.app.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            var themePreference by remember { mutableStateOf("system") }
            
            val isDark = when (themePreference) {
                "light" -> false
                "dark" -> true
                else -> isSystemInDarkTheme()
            }

            DisciplineTheme(darkTheme = isDark) {
                val navController = rememberNavController()
                
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            listOf("today", "calendar", "stats", "settings").forEach { route ->
                                NavigationBarItem(
                                    selected = currentRoute == route,
                                    onClick = { navController.navigate(route) },
                                    label = { Text(route.replaceFirstChar { it.uppercase() }) },
                                    icon = { }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "today",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("today") { TodayScreen() }
                        composable("calendar") { CalendarScreen() }
                        composable("stats") { StatsScreen() }
                        composable("settings") { 
                            SettingsScreen(
                                currentTheme = themePreference,
                                onThemeChanged = { themePreference = it }
                            ) 
                        }
                    }
                }
            }
        }
    }
}