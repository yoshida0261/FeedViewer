package jp.co.stah.feedviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.core.Flowable
import jp.co.stah.feedviewer.databinding.ActivityMainBinding
import jp.co.stah.feedviewer.view.CarouselAdapter

class MainActivity : AppCompatActivity() {



    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        //setContentView(R.layout.activity_main)
        //Flowable.just("Hello world").subscribe(System.out::println);
    }

    private fun setup(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            val adapter = CarouselAdapter(createDataList())
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        recyclerView.addItemDecoration(
            CarouselItemDecoration(16)
        )
        }

    }

    private fun createDataList(): List<CarouselListData> {
        val dataList = mutableListOf<CarouselListData>()
        for(i in 0 until 20){
            dataList.add(
                CarouselListData(
                    image = resources.getDrawable(R.drawable.ic_launcher_foreground, null),
                    title= "Carousel item $i",
                    color = getRandamColor()
                )
            )
        }
        return dataList

    }

    private fun getRandamColor(): Int {
        val colorList = resources.getIntArray(R.array.color_list)
        return colorList[(0 until colorList.size).random()]
    }
}
