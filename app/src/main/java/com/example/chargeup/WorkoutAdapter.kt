package com.example.chargeup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class WorkoutAdapter(
    private val items: List<WorkoutItem>,
    private val onImageButtonClick: (WorkoutItem) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    class WorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageButton: ImageButton = view.findViewById(R.id.imageButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.workout_layout, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val item = items[position]
        holder.imageButton.setImageResource(item.imageResId) // Уникальная картинка
        holder.imageButton.setOnClickListener {
            onImageButtonClick(item) // Нажатие на элемент
        }
    }

    override fun getItemCount(): Int = items.size
}


