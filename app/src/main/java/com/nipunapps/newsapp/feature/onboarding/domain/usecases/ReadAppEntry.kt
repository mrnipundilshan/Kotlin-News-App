package com.nipunapps.newsapp.feature.onboarding.domain.usecases

import com.nipunapps.newsapp.feature.onboarding.domain.repository.LocalUserManagerRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManagerRepository: LocalUserManagerRepository
) {
    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManagerRepository.readAppEntry()
    }
}