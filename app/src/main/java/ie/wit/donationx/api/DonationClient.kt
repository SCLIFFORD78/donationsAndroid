package ie.wit.donationx.api

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DonationClient {

        val serviceURL = "https://donationweb-hdip-mu-server.herokuapp.com"

        fun getApi() : DonationService {

            val gson = GsonBuilder().create()

//            gson.registerTypeAdapter(Any::class, object : TypeAdapter<T>() {
//
//                override fun write(`in`: Any, `out`: JSONWriter) {
//                    // your transform code here, for example:
//                    if (`in`.observableFieldItem is ModelHasObservableFields) {
//                        `out`.observableFieldItem = `in`.observableFieldItem.get()
//                    }
//                }
//
//            })

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val apiInterface = Retrofit.Builder()
                .baseUrl(serviceURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
            return apiInterface.create(DonationService::class.java)
        }
    }
