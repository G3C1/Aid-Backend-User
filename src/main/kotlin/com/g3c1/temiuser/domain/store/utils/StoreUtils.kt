package com.g3c1.temiuser.domain.store.utils

import com.g3c1.temiuser.domain.store.domain.entity.Store

interface StoreUtils {
    fun findStoreBySerialNumber(serialNumber: Long): Store
}