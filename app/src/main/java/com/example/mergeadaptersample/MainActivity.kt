package com.example.mergeadaptersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadaptersample.databinding.ActivityMainBinding
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val textSectionAdapter = TextSectionAdapter()
        val switchSectionAdapter = SwitchSectionAdapter()
        val buttonSectionAdapter = ButtonSectionAdapter() {
            android.util.Log.d("buttonSectionAdapter", "onClicked")
            switchSectionAdapter.submitList(switchSectionAdapter.currentList.map { it.copy( isChecked = !it.isChecked) })
        }

        // If you do want to share viewholders among adapters, setIsolateViewTypes to fasle
//        val mergeAdapter = MergeAdapter(
//            MergeAdapter.Config.Builder().setIsolateViewTypes(false).build(),
//            textSectionAdapter,
//            buttonSectionAdapter,
//            switchSectionAdapter
//        )

        val mergeAdapter = MergeAdapter(
            textSectionAdapter,
            buttonSectionAdapter,
            switchSectionAdapter
        )

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mergeAdapter
        }

        setContentView(binding.root)

        val textItems = arrayListOf<TextItem>()
        val switchItems = arrayListOf<SwitchItem>()
        (1..15).forEach {
            textItems.add(TextItem(id = it, text = it.toString()))
            switchItems.add(SwitchItem(id = it, isChecked = it%2==0))
        }

        textSectionAdapter.submitList(textItems)
        switchSectionAdapter.submitList(switchItems)

    }
}
