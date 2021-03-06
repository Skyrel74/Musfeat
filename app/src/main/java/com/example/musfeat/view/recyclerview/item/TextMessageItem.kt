package com.example.musfeat.view.recyclerview.item

import android.content.Context
import com.example.musfeat.R
import com.example.musfeat.data.TextMessage
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_text_message.*

class TextMessageItem(
    val message: TextMessage,
    val context: Context
) : MessageItem(message) {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvMessageText.text = message.text
        super.bind(viewHolder, position)
    }

    override fun getLayout(): Int = R.layout.item_text_message

    override fun isSameAs(other: com.xwray.groupie.Item<*>?): Boolean {
        if (other !is TextMessageItem)
            return false
        if (this.message != other.message)
            return false
        return true
    }

    override fun equals(other: Any?): Boolean {
        return isSameAs(other as? TextMessageItem)
    }

    override fun hashCode(): Int {
        var result = message.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }
}
