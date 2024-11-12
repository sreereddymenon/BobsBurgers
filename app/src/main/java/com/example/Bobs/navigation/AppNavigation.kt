package com.example.Bobs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.Bobs.CharacterDetailScreen
import com.example.Bobs.HomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "characterList") {
        composable("characterList") {
            HomeScreen(onCharacterClick = { characterId ->
                navController.navigate("characterDetail/$characterId")
            })
        }
        composable(
            "characterDetail/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: return@composable
            CharacterDetailScreen(navController = navController, characterId = characterId)
        }
    }

    }
