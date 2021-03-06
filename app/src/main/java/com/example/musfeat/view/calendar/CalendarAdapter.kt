package com.example.musfeat.view.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.musfeat.R
import com.example.musfeat.data.Event
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_events.*

class CalendarAdapter(private val onEventClick: (Event) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Event, CalendarAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<Event>() {

        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }) {

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_events, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.tvEventName.text = item.name
        holder.tvEventDate.text = item.date
        Glide.with(holder.containerView.context)
            .load(item?.eventImageView)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivEvent)

        holder.containerView.setOnClickListener {
            onEventClick(item)
        }
    }
}
