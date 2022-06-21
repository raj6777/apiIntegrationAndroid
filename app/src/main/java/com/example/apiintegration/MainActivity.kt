package com.example.apiintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiintegration.adapter.RecyclerAdapter
import com.example.apiintegration.models.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var quotesList = ArrayList<DataModel>()
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerview)

        getQuote()
    }
    private fun getQuote(){
        val client = ApiClient().getRetrofitClient().create(ApiInterface::class.java)
        client.getQuotes().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                // Used for inserting data in arraylist of type DataModel
                quotesList = response.body() as ArrayList<DataModel>
                val adapter = RecyclerAdapter(quotesList)

                // For showing data list vertically

                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = adapter

            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                // Write a code for failure
            }

        })
    }
}