package com.teach.sololeveling.sports.data.repo

import android.util.Log
import com.teach.sololeveling.core.di.IoDispatcher
import com.teach.sololeveling.sports.data.remote.SportApi
import com.teach.sololeveling.sports.data.remote.dto.SportDto
import com.teach.sololeveling.sports.domain.model.Sport
import com.teach.sololeveling.sports.domain.repo.SportsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class SportsRepoImpl @Inject constructor(
    private val api: SportApi,


) :SportsRepo{
    override suspend fun getAllSports(): List<SportDto> {
        return api.getSports()
    }

}