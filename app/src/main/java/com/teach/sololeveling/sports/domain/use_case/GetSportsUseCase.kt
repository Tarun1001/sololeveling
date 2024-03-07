package com.teach.sololeveling.sports.domain.use_case

import android.util.Log
import com.teach.sololeveling.core.utils.Resource
import com.teach.sololeveling.sports.data.remote.dto.toSportModel
import com.teach.sololeveling.sports.domain.model.Sport
import com.teach.sololeveling.sports.domain.repo.SportsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSportsUseCase @Inject constructor(private val repo:SportsRepo) {
    operator fun invoke():Flow<Resource<List<Sport>>> =flow{
        try {
            Log.d("ff","loading")
            emit(Resource.Loading<List<Sport>>())
            val coin = repo.getAllSports().map { it.toSportModel() }
            emit(Resource.Success<List<Sport>>(coin))
            Log.d("ff","done")
        } catch(e: HttpException) {
            emit(Resource.Error<List<Sport>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Sport>>("Couldn't reach server. Check your internet connection."))
        }
    }
}