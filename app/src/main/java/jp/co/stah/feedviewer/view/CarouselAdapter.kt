package jp.co.stah.feedviewer.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.co.stah.feedviewer.CarouselListData
import jp.co.stah.feedviewer.databinding.ItemCarouselCardBinding

class CarouselAdapter(val dataList: List<CarouselListData>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
     //   setOnItemClickListener()

        return CarouselViewHolder(
            ItemCarouselCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size

    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val data = dataList[position]
        holder.binding.data = data
        holder.binding.container.setOnClickListener {
            listener.onClick(it, position, data)
        }
    }


    interface OnItemClickListener {
        fun onClick(view: View, position: Int, data: CarouselListData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class CarouselViewHolder(val binding: ItemCarouselCardBinding) :
        RecyclerView.ViewHolder(binding.root)
}