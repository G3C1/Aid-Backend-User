package com.g3c1.temiuser.domain.store.utils.impl

import com.g3c1.temiuser.domain.store.presentation.data.dto.StoreInfoDto
import com.g3c1.temiuser.domain.store.presentation.data.response.StoreInfoResponse
import com.g3c1.temiuser.domain.store.utils.StoreConverter
import org.springframework.stereotype.Component

@Component
class StoreConverterImpl: StoreConverter {
    override fun toResponse(storeInfoDto: StoreInfoDto): StoreInfoResponse =
        StoreInfoResponse(storeInfoDto.name,storeInfoDto.img,storeInfoDto.description)

}