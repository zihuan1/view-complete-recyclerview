package com.zihuan.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.zihuan.view.crvlibrary.initGrid
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var builder = rv_view.buildVerticalLayout(ReAdapter(this)).setWrapContent()
        var list = ArrayList<String>()
        (0..100).forEach {
            list.add("$it")
        }
        rv_view.getBaseBuilder().setData(list).scrollToBottom()
        bt_click.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }
    }

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, _ -> MaterialHeader(context) }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }
}
