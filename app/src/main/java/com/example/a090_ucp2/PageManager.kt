package com.example.a090_ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a090_ucp2.data.DataSource.dosbing

enum class PageManager {
    HomePage,
    FormPage,
    SummaryPage
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormAppBar(
    backNavigation: Boolean,
    upNavigation: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar (
        title = { Text(stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (backNavigation) {
                IconButton(onClick = upNavigation) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_btn)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormApp(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            FormAppBar(
                backNavigation = false,
                upNavigation = { /*TODO*/ }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PageManager.HomePage.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PageManager.HomePage.name) {
                HomePage(
                    onNextButtonClicked = {
                        navController.navigate(PageManager.FormPage.name)
                    }
                )
            }
            composable(route = PageManager.FormPage.name) {
                val context = LocalContext.current
                FormPage(
                    dosbingChoice = dosbing.map { id -> context.resources.getString(id) },
                    modifier = Modifier,
                    onSelectionChanged = {viewModel.setDosbing1(it); viewModel.setDosbing2(it)},
                    onSubmitButtonClicked = {viewModel.setForm(it); navController.navigate(PageManager.SummaryPage.name)}
                ) {

                }


            }
            composable(route = PageManager.SummaryPage.name) {
                SummaryPage(
                    formUIState = uiState,
                    onCancelButtonClicked = {}
                )
            }
        }


        fun cancelContactAndNavigateToHome(viewModel: FormViewModel, navController: NavHostController) {
            navController.popBackStack(PageManager.HomePage.name, inclusive = false)
        }
        fun cancelAndNavigateToForm(navController: NavHostController) {
            navController.popBackStack(PageManager.FormPage.name, inclusive = false)
        }
    }
}