package com.g3c1.temiuser.domain.store.utils.impl

import com.g3c1.temiuser.domain.store.domain.entity.Store
import com.g3c1.temiuser.domain.store.domain.repository.StoreRepository
import com.g3c1.temiuser.domain.store.exception.StoreNotFoundException
import com.g3c1.temiuser.domain.store.utils.StoreUtils
import org.springframework.stereotype.Component

@Component
class StoreUtilsImpl(
    private val storeRepository: StoreRepository
): StoreUtils {
    override fun findStoreBySerialNumber(serialNumber: Long): Store = storeRepository.findById(serialNumber).orElseThrow { StoreNotFoundException() }
}