package com.aegis.learn

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * 主活动类，负责应用的初始界面显示
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 启用边缘到边缘的界面显示模式，优化全屏体验
        enableEdgeToEdge()
        // 设置活动的布局资源
        setContentView(R.layout.activity_main)
        // 设置视图的窗口嵌入监听器，以处理系统栏的显示
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // 获取系统栏的嵌入信息
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // 根据系统栏的大小调整视图的内边距，确保内容不会被系统栏遮挡
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            // 返回未处理的窗口嵌入，以便其他处理逻辑可以继续使用
            insets
        }
    }
}