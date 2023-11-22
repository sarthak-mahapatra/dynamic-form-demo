package com.maverick.dynamicformdemo

import retrofit2.http.GET

interface FormApiService {
    @GET("v1/projects/123/forms")
    suspend fun getForm(): ApiResponse
}

