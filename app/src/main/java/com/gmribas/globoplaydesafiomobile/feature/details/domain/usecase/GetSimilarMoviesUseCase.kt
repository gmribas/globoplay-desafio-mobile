package com.gmribas.globoplaydesafiomobile.feature.details.domain.usecase

import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gmribas.globoplaydesafiomobile.core.domain.CommonUseCase
import com.gmribas.globoplaydesafiomobile.core.domain.model.Movie
import com.gmribas.globoplaydesafiomobile.feature.details.domain.repository.GetSimilarMoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSimilarMoviesUseCase(private val repository: GetSimilarMoviesRepository): CommonUseCase<GetSimilarMoviesUseCase.Request, GetSimilarMoviesUseCase.Response>() {

    data class Request(val scope: CoroutineScope, val movieId: Int): CommonUseCase.Request

    data class Response(val movies: PagingData<Movie>): CommonUseCase.Response

    override suspend fun process(request: Request): Flow<Response> {
        return repository
            .getSimilarMovies(request.movieId)
            .cachedIn(request.scope)
            .map { Response(it) }
    }
}