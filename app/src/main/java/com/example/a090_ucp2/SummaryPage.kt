package com.example.a090_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.a090_ucp2.data.FormUIState

@Composable
fun SummaryPage(
    formUIState: FormUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), formUIState.nama),
        Pair(stringResource(R.string.nim), formUIState.nim),
        Pair(stringResource(R.string.konsentrasi), formUIState.konsentrasi),
        Pair(stringResource(R.string.judulSkripsi), formUIState.judul),
        Pair(stringResource(R.string.dosbing1), formUIState.dosbingg1),
        Pair(stringResource(R.string.dosbing2), formUIState.dosbingg2)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}