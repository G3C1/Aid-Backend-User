package com.g3c1.temiuser.domain.store.service.impl

import com.g3c1.temiuser.domain.store.presentation.data.dto.StoreInfoDto
import com.g3c1.temiuser.domain.store.service.StoreService
import com.g3c1.temiuser.domain.store.utils.StoreUtils
import org.springframework.stereotype.Service

@Service
class StoreServiceImpl(
    private val storeUtils: StoreUtils
): StoreService {
    override fun findStoreBySerialNumber(serialNumber: Long): StoreInfoDto =
        storeUtils.findStoreBySerialNumber(serialNumber)
            .let { StoreInfoDto(it.name,it.img,it.description) }

}