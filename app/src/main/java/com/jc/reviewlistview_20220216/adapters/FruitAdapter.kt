package com.jc.reviewlistview_20220216.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jc.reviewlistview_20220216.R
import com.jc.reviewlistview_20220216.datas.FruitData
import java.text.SimpleDateFormat
import java.util.*

class FruitAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<FruitData>
): ArrayAdapter<FruitData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var temp = convertView

        if (temp == null) {
            temp = LayoutInflater.from(mContext).inflate(R.layout.fruit_list_item, null)
        }

        val row = temp!!

        val fruitName = row.findViewById<TextView>(R.id.fruitNameTextView)
        val fruitPrice = row.findViewById<TextView>(R.id.fruitPriceTextView)
        val fruitExpirationDate = row.findViewById<TextView>(R.id.expirationDateTextView)

        val now: Long = System.currentTimeMillis();
        val date = Date(now)
        val formatTime = SimpleDateFormat("yyyy-MM-dd")
        val expirationDate = formatTime.format(date)

        val resultExpirationDate = "$expirationDate"

        val fruitData = mList[position]

        fruitName.text = fruitData.name
        fruitPrice.text = "${fruitData.price} 원"
        fruitExpirationDate.text = resultExpirationDate


        return row
    }

}