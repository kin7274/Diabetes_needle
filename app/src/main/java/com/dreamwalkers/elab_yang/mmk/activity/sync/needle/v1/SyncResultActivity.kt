package com.dreamwalkers.elab_yang.mmk.activity.sync.needle.v1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dreamwalkers.elab_yang.mmk.R
import kotlinx.android.synthetic.main.activity_sync_result.*
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Logger

class SyncResultActivity : AppCompatActivity() {

    lateinit var simpleDateFormat: SimpleDateFormat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_result)
        simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
        val values = intent.getStringExtra("SyncValue")
        result_text.text = values
        toast(values)
        val resultObject = JSONObject(values)
        val resultArray: JSONArray = resultObject.getJSONArray("received")
        result_text.append("\n\n")
        result_text.append(resultArray.toString())
        result_text.append("\n\n")
        for (i in 0 until resultArray.length()) {
            Logger.getLogger(this@SyncResultActivity.localClassName).warning("" + i)
            val id = resultArray.getJSONObject(i).getString("id")
            val year = resultArray.getJSONObject(i).getString("value").substring(0, 4)
            val month = resultArray.getJSONObject(i).getString("value").substring(4, 6)
            val days = resultArray.getJSONObject(i).getString("value").substring(6, 8)
            val hour = resultArray.getJSONObject(i).getString("value").substring(8, 10)
            val minutes = resultArray.getJSONObject(i).getString("value").substring(10, 12)

            result_text.append("$id :: $year-$month-$days $hour:$minutes\n")
            val valueDate = simpleDateFormat.parse("$year-$month-$days $hour:$minutes:00")
            result_text.append(valueDate.time.toString() + "\n")
        }
    }
}
