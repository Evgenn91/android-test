package dsk.altlombard.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.dto.Address;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.List;

public class AnotherAddressRowAdapter extends BaseAdapter {

    private Context context;
    private List<Address> addresses;

    private LayoutInflater inflter;

    private int count = 0;

    public AnotherAddressRowAdapter(Context context, List<Address> addresses) {
        this.context = context;
        this.addresses = addresses;
        this.inflter = (LayoutInflater.from(context));
        this.count = addresses.size();
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
        view = inflter.inflate(R.layout.fragment_another_working_address_listview, null);

        TextView numberDatePledge = (TextView) view.findViewById(R.id.number_date_pledge);
        TextView numberDatePledge1 = (TextView) view.findViewById(R.id.number_date_pledge1);
        numberDatePledge.setText(addresses.get(position).getStreet());
        numberDatePledge1.setText(addresses.get(position).getTimeWorking());

        return view;
    }
}
