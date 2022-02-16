package com.jc.reviewlistview_20220216

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.jc.reviewlistview_20220216.adapters.FruitAdapter
import com.jc.reviewlistview_20220216.datas.FruitData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fruitAdapter: FruitAdapter
    val fruitList = ArrayList<FruitData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruitList.add(FruitData("딸기", 10000, ""))
        fruitList.add(FruitData("바나나", 2000, ""))
        fruitList.add(FruitData("사과", 15000, ""))
        fruitList.add(FruitData("수박", 20000, ""))
        fruitList.add(FruitData("포도", 30000, ""))

        fruitAdapter = FruitAdapter(this, R.layout.fruit_list_item, fruitList)

        listView.adapter = fruitAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val clickedItem = fruitList[position]

            Toast.makeText(this, "${clickedItem.name} 의 가격은 ${clickedItem.price} 입니다.", Toast.LENGTH_SHORT).show()
            
        }

        listView.setOnItemLongClickListener { parent, view, position, id ->

            val longClickedItem = fruitList[position]

            val alert = AlertDialog.Builder(this)
                .setTitle("해당 과일을 삭제하시겠습니까?")
                .setMessage("선택된 ${longClickedItem.name} 이 삭제 됩니다.")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                    fruitList.remove(longClickedItem)
                    fruitAdapter.notifyDataSetChanged()
                })
                .setNeutralButton("취소", null)

            alert.show()

            return@setOnItemLongClickListener true
        }

    }
}