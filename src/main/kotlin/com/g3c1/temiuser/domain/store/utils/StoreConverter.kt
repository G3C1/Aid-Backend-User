package com.g3c1.temiuser.domain.store.utils

import com.g3c1.temiuser.domain.store.presentation.data.dto.StoreInfoDto
import com.g3c1.temiuser.domain.store.presentation.data.response.StoreInfoResponse
import org.springframework.stereotype.Component

interface StoreConverter {
    fun toResponse(storeInfoDto: StoreInfoDto): StoreInfoResponse
}