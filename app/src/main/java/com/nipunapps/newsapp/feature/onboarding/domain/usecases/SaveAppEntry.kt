package com.nipunapps.newsapp.feature.onboarding.domain.usecases

import com.nipunapps.newsapp.feature.onboarding.domain.repository.LocalUserManagerRepository

class SaveAppEntry(
    private val localUserManagerRepository : LocalUserManagerRepository
) {
    suspend operator fun invoke(){
        localUserManagerRepository.saveAppEntry()
    }
}