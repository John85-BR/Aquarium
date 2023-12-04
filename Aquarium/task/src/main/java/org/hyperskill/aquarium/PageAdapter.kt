package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso


class PageAdapter(private var imageAnimals: List<String>,
                     private var nameAnimals: List<String>,
                     private var descriptionAnimals: List<String>, private var tabLayout: TabLayout, private var viewPager2: ViewPager2
) : RecyclerView.Adapter<PageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_item,parent,false))

    override fun getItemCount(): Int = imageAnimals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        TabLayoutMediator(tabLayout, viewPager2 ) { tab, pos ->

            nameAnimals[pos].also { tab.text = it }

        }.attach()

        Picasso.get()
            .load(imageAnimals[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(holder.image)

        holder.name.text = nameAnimals[position]
        holder.description.text = descriptionAnimals[position]
        holder.cardview.cardElevation = 10.0F

    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.image_view)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val description = view.findViewById<TextView>(R.id.tv_description)
        val cardview = view.findViewById<CardView>(R.id.card_view)

    }

}