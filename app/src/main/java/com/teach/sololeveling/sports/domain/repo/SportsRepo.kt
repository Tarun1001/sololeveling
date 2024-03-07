package com.teach.sololeveling.sports.domain.repo

import com.teach.sololeveling.sports.data.remote.dto.SportDto
import com.teach.sololeveling.sports.domain.model.Sport

interface SportsRepo {
    suspend fun getAllSports(): List<SportDto>
}