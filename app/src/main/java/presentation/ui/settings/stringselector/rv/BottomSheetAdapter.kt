package presentation.ui.settings.stringselector.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myassets.databinding.ItemBottomSheetListBinding
import domain.entity.Currencies

class BottomSheetAdapter : RecyclerView.Adapter<BottomSheetViewHolder>() {
    private var items = Currencies.entries.toList()
    var onClick: (Currencies) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        return BottomSheetViewHolder(
            ItemBottomSheetListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}
