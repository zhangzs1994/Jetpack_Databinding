package com.zzs.jetpack_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.zzs.jetpack_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = User("张三", 20)
        //不要忘记写这个，不然点击事件无效
        binding.myHandles = MyHandlers()
//        val users = ArrayList<User>().apply {
//            for (i in 0..10) {
//                add(User("张三$i", 20))
//            }
//        }
//        binding.rvUser.layoutManager = LinearLayoutManager(this)
//        val adapter = UserAdapter(this, users);
//        binding.rvUser.adapter = adapter
//        //item点击事件
//        adapter.setOnItemClickListener(object : UserAdapter.OnItemClickListener {
//            override fun onItemClick(view: View, user: User) {
//                Toast.makeText(this@MainActivity, user.name, Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    inner class MyHandlers{
        fun onClickUser(view: View,user: User){
            Toast.makeText(this@MainActivity, user.name, Toast.LENGTH_SHORT).show()
        }
    }
}
