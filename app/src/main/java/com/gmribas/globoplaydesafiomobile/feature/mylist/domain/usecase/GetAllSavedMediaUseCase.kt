package com.gmribas.globoplaydesafiomobile.feature.mylist.domain.usecase

import com.gmribas.globoplaydesafiomobile.core.domain.CommonUseCase
import com.gmribas.globoplaydesafiomobile.feature.mylist.domain.model.Media
import com.gmribas.globoplaydesafiomobile.feature.mylist.domain.repository.MediaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllSavedMediaUseCase(private val repository: MediaRepository): CommonUseCase<GetAllSavedMediaUseCase.Request, GetAllSavedMediaUseCase.Response>() {

    class Request: CommonUseCase.Request
    data class Response(val medias: List<Media>): CommonUseCase.Response

    override suspend fun process(request: Request): Flow<Response> {
        return repository.getAllMediaSaved().map { Response(it) }
    }
}