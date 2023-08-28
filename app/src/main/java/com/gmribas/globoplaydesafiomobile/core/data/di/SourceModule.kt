package com.gmribas.globoplaydesafiomobile.core.data.di

import com.gmribas.globoplaydesafiomobile.feature.details.data.source.GetMovieDetailsSource
import com.gmribas.globoplaydesafiomobile.feature.details.data.source.remote.GetMovieDetailsSourceRemoteImpl
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.DiscoverMoviesSource
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.DiscoverSoapOperasSource
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.GetTopRatedTvShowsSource
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.remote.DiscoverMoviesSourceRemoteImpl
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.remote.DiscoverSoapOperaSourceRemoteImpl
import com.gmribas.globoplaydesafiomobile.feature.home.data.source.remote.GetTopRatedTvShowsSourceRemoteImpl
import org.koin.dsl.module

val sourceModule = module {

    single<DiscoverMoviesSource> { DiscoverMoviesSourceRemoteImpl(get()) }

    single<DiscoverSoapOperasSource> { DiscoverSoapOperaSourceRemoteImpl(get()) }

    single<GetTopRatedTvShowsSource> { GetTopRatedTvShowsSourceRemoteImpl(get()) }

    single<GetMovieDetailsSource> { GetMovieDetailsSourceRemoteImpl(get()) }
}