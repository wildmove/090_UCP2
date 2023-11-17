package com.example.a090_ucp2

import androidx.lifecycle.ViewModel
import com.example.a090_ucp2.data.FormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI : StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setForm(formUIState: FormUIState) {
        _stateUI.value = _stateUI.value.copy(
            nama = formUIState.nama,
            nim = formUIState.nim,
            konsentrasi = formUIState.konsentrasi,
            judul = formUIState.judul
        )
    }

    fun setDosbing1 (selectedDosbing : String) {
        _stateUI.update { currentState ->
            currentState.copy(
                dosbingg1 = selectedDosbing
            )
        }
    }
    fun setDosbing2 (selectedDosbing : String) {
        _stateUI.update { currentState ->
            currentState.copy(
                dosbingg2 = selectedDosbing
            )
        }
    }
}