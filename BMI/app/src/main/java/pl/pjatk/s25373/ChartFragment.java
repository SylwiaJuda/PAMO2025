package pl.pjatk.s25373;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LineChart chart = new LineChart(getContext());

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 25));
        entries.add(new Entry(2, 24.5f));
        entries.add(new Entry(3, 24.2f));
        entries.add(new Entry(4, 23.8f));
        entries.add(new Entry(5, 23.6f));

        LineDataSet dataSet = new LineDataSet(entries, "BMI over time");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        chart.invalidate();
        return chart;
    }
}
