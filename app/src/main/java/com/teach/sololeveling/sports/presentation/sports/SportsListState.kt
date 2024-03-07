package com.teach.sololeveling.sports.presentation.sports

import com.teach.sololeveling.sports.domain.model.Sport

data class SportsListState(
    val sportsList: List<Sport> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)

