package com.pisiitech.retrofitkullanimix

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pisiitech.retrofitkullanimix.ui.theme.RetrofitKullanimixTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitKullanimixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    LaunchedEffect(key1 = true) {
        //tumKisiler()
        //arama()
        //sil()
        //ekle()
        guncelle()
    }
}

fun tumKisiler() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()

    kisilerDaoInterface.tumKisiler().enqueue(object : Callback<KisilerCevap>{
        override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
            val liste = response.body()?.kisiler

            for(k in liste!!) {
                Log.e("Kisi Bilgi","*******" )
                Log.e("Kisi id",k.kisi_id.toString())
                Log.e("Kisi ad",k.kisi_ad)
                Log.e("Kisi tel",k.kisi_tel)
            }
        }
        override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
            Log.e("Kisi Hata", t.message,t.cause)
        }
    })
}
fun arama() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()

    kisilerDaoInterface.kisiAra("la").enqueue(object : Callback<KisilerCevap>{
        override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
            val liste = response.body()?.kisiler

            for(k in liste!!) {
                Log.e("Kisi Bilgi","*******" )
                Log.e("Kisi id",k.kisi_id.toString())
                Log.e("Kisi ad",k.kisi_ad)
                Log.e("Kisi tel",k.kisi_tel)
            }
        }
        override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
            Log.e("Kisi Hata", t.message,t.cause)
        }
    })
}

fun sil() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()

    kisilerDaoInterface.kisiSil(9).enqueue(object : Callback<CRUDCevap>{
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            val mesaj = response.body()?.message
            val basari = response.body()?.success
            Log.e("Kisi Sil", "Basari : $basari - Mesaj _ $mesaj")
        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
    })

}

fun ekle() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()

    kisilerDaoInterface.kisiEkle("Merve","5329939393").enqueue(object : Callback<CRUDCevap>{
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            val mesaj = response.body()?.message
            val basari = response.body()?.success
            Log.e("Kisi Ekle", "Basari : $basari - Mesaj _ $mesaj")
        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
    })

}
fun guncelle() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()

    kisilerDaoInterface.kisiGuncelle(10,"Selim","5437897789").enqueue(object : Callback<CRUDCevap>{
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            val mesaj = response.body()?.message
            val basari = response.body()?.success
            Log.e("Kisi Guncelle", "Basari : $basari - Mesaj _ $mesaj")
        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
    })

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitKullanimixTheme {
        Sayfa()
    }
}