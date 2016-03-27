package com.dev.touyou.clapbeat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var button: ImageButton? = null
    var clapinstance: Clap? = null
    var spinner: Spinner? = null
    var repeat: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.imgBtn) as ImageButton
        spinner = findViewById(R.id.spinner) as Spinner

        clapinstance = Clap()
        clapinstance?.Clap(this.applicationContext)

        // spinnerの初期化
        val strArray: Array<String> = arrayOf("パンッ！", "パンパンッ！", "パンパンパンッ！", "4回", "5回")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, strArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.setAdapter(arrayAdapter)

        // spinnerが使われた時に
        spinner?.onItemSelectedListener = this
    }

    fun click(v: View) {
        clapinstance?.repeatPlay(repeat)
    }

    override fun onItemSelected(parent: AdapterView<*>?, v: View?, pos: Int, id: Long) {
        repeat = pos + 1
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        throw UnsupportedOperationException()
    }
}
