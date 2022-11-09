package com.g3c1.temiuser.domain.store.service

import com.g3c1.temiuser.domain.store.presentation.data.dto.StoreInfoDto

interface StoreService {
    fun findStoreBySerialNumber(serialNumber: Long): StoreInfoDto
}