package dsk.altlombard.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.List;

public class PledgeRowAdapter extends BaseAdapter {

    private Context context;
    private List<PledgeRow> pledges;

    private LayoutInflater inflter;

    private int count = 0;


    public PledgeRowAdapter(Context context, List<PledgeRow> pledges) {
        this.context = context;
        this.pledges = pledges;
        this.inflter = (LayoutInflater.from(context));
        this.count = pledges.size();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.fragment_main_working_listview, null);

        TextView numberDatePledge = (TextView) view.findViewById(R.id.number_date_pledge);
        numberDatePledge.setText(pledges.get(position).getNumber()+" от " + pledges.get(position).getNumber());

        return view;
    }
}
