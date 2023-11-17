package com.example.a090_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a090_ucp2.data.FormUIState

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun FormPage(
    dosbingChoice : List<String>,
    modifier: Modifier,
    onSelectionChanged : (String) -> Unit,
    onSubmitButtonClicked: (FormUIState) -> Unit,
    onCancelButtonClicked: () -> Unit,
) {
    var txtName by rememberSaveable {
        mutableStateOf("")
    }
    var txtNIM by rememberSaveable {
        mutableStateOf("")
    }
    var txtKonsentrasi by rememberSaveable {
        mutableStateOf("")
    }
    var txtJudul by rememberSaveable {
        mutableStateOf("")
    }
    var txtDosbing1 by remember {
        mutableStateOf("")
    }
    var txtDosbing2 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = txtName,
            onValueChange = { txtName = it },
            label = {
                Text(text = stringResource(id = R.string.nama))
            }
        )
        OutlinedTextField(
            value = txtNIM,
            onValueChange = { txtNIM = it },
            label = {
                Text(text = stringResource(id = R.string.nim))
            }
        )
        OutlinedTextField(
            value = txtKonsentrasi,
            onValueChange = { txtKonsentrasi = it },
            label = {
                Text(text = stringResource(id = R.string.konsentrasi))
            }
        )
        OutlinedTextField(
            value = txtJudul,
            onValueChange = { txtJudul = it },
            label = {
                Text(text = stringResource(id = R.string.judulSkripsi))
            }
        )
    }
    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            dosbingChoice.forEach { item ->
                Row (modifier = Modifier.selectable(
                    selected = txtDosbing1 == item,
                    onClick = {
                        txtDosbing1 = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = txtDosbing1 == item,
                        onClick = {
                            txtDosbing2 = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
                Row (modifier = Modifier.selectable(
                    selected = txtDosbing2 == item,
                    onClick = {
                        txtDosbing2 = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = txtDosbing2 == item,
                        onClick = {
                            txtDosbing2 = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
        }
    }
}