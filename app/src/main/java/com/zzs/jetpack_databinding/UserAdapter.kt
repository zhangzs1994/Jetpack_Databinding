package com.zzs.jetpack_databinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author:      ZhangZhiSheng
 * @date:        2020/7/17 0017 下午 4:40
 * @description:
 */
class UserAdapter(private val context: Context, private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var mOnClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_list_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.dataBinding
        binding.setVariable(BR.userList, users[position])
        holder.itemView.setOnClickListener {
            //创建回调接口处理item点击事件
            mOnClickListener.onItemClick(it, users[position])
            //也可以不使用回调接口（注释上面的代码），直接在Adapter中处理点击逻辑
            //todo
        }
    }

    inner class ViewHolder(var dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root)

    interface OnItemClickListener {
        fun onItemClick(view: View, user: User)
    }

    fun setOnItemClickListener(onClickListener: OnItemClickListener) {
        this.mOnClickListener = onClickListener
    }

}

