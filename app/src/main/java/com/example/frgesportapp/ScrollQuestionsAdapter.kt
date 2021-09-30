package com.example.frgesportapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScrollQuestionsAdapter (val context: Context, val questions: List<FragaBas>)
    : RecyclerView.Adapter<ScrollQuestionsAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : ScrollQuestionsAdapter.ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScrollQuestionsAdapter.ViewHolder, position: Int) {
        val question = questions[position]
        holder.questionTextView.text = question.fraga
        holder.answerTextView.text = question.rattSvar

    }
inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var questionTextView = itemView.findViewById<TextView>(R.id.questionTextView)
    var answerTextView = itemView.findViewById<TextView>(R.id.answerTextView)

}
}