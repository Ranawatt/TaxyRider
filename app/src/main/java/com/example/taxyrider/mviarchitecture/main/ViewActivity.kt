package com.example.taxyrider.mviarchitecture.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxyrider.R
import com.example.taxyrider.mviarchitecture.data.api.ApiHelperImpl
import com.example.taxyrider.mviarchitecture.data.api.RetrofitBuilder
import com.example.taxyrider.mviarchitecture.data.model.User
import com.example.taxyrider.mviarchitecture.main.adapter.ViewsAdapter
import com.example.taxyrider.mviarchitecture.main.intent.MainIntent
import com.example.taxyrider.mviarchitecture.main.viewmodel.MainViewModel
import com.example.taxyrider.mviarchitecture.main.viewstate.MainState
import com.example.taxyrider.mviarchitecture.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_view.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var adapter =  ViewsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(DividerItemDecoration(recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation))
        }
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelperImpl(
            RetrofitBuilder.apiService
        ))).get(MainViewModel::class.java)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when(it){
                    is MainState.Idle -> {

                    }
                    is MainState.Loading -> {
                        buttonFetchUser.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }
                    is MainState.Users -> {
                        progressBar.visibility = View.GONE
                        renderList(it.users)
                    }
                    is MainState.Error -> {
                        progressBar.visibility = View.GONE
                        buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@ViewActivity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun renderList(users: List<User>) {
        recyclerView.visibility = View.VISIBLE
        users.let {
            listOfUsers -> listOfUsers.let { adapter.addData(it) }
        }
        adapter.notifyDataSetChanged()
    }

    private fun setupClicks() {

        buttonFetchUser.setOnClickListener{
            lifecycleScope.launch{

                viewModel.userIntent.send(MainIntent.FetchUser)
            }
        }
    }
}