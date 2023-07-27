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

public class FullPledgeRowAdapter extends BaseAdapter {

    private Context context;
    private List<PledgeRow> pledges;

    private LayoutInflater inflter;

    private int count = 0;

    public FullPledgeRowAdapter(Context context, List<PledgeRow> pledges) {
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
        view = inflter.inflate(R.layout.fragment_pledge_working_listview, null);

        TextView numberDatePledge = view.findViewById(R.id.number_date_pledge);
        TextView numberDatePledge1 = view.findViewById(R.id.number_date_pledge1);
        TextView numberDatePledge2 = view.findViewById(R.id.number_date_pledge2);
        TextView numberDatePledge3 = view.findViewById(R.id.number_date_pledge3);
        TextView numberDatePledge4 = view.findViewById(R.id.number_date_pledge4);
        numberDatePledge.setText(pledges.get(position).getNumber()+" от " + pledges.get(position).getDate());
        numberDatePledge1.setText(pledges.get(position).getPayment());
        numberDatePledge2.setText(pledges.get(position).getRemains());
        numberDatePledge3.setText(pledges.get(position).getPerent());
        numberDatePledge4.setText(pledges.get(position).getRate());

        return view;
    }
}
