package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.Data.API
import com.example.learnkotlin.Data.Repo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<Repo>> {
    var mRepo: Array<Repo> = arrayOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        viewAdapter = CustomAdapter(mRepo)
        rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        btn.setOnClickListener {
            loadData(edt.text.toString())
        }

    }
    fun loadData(name:String){
        API.apiService.listRepos(name).enqueue(this)
    }
    override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
        if(response==null|| response.body()==null){
            return
        }
        rv.adapter = CustomAdapter(response.body()!!.toTypedArray())
        rv.adapter!!.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
        Toast.makeText(this,"Error"+t.toString(),Toast.LENGTH_SHORT).show();
    }

}
