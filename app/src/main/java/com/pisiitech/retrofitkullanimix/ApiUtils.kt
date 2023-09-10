package com.pisiitech.retrofitkullanimix

class ApiUtils {
    companion object {
        val BASE_URL = "https://techload.net/"

        fun getKisilerDaoInterface():KisilerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }
}