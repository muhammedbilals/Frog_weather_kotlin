package com.inspired.frog.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation():Location?
}