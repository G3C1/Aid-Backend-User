package com.g3c1.temiuser.domain.store.domain.repository

import com.g3c1.temiuser.domain.store.domain.entity.Store
import org.springframework.data.repository.CrudRepository

interface StoreRepository: CrudRepository<Store,Long> {}