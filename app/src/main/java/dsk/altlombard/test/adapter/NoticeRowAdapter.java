package dsk.altlombard.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.dto.MessageRow;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.List;

public class NoticeRowAdapter extends BaseAdapter {

    private Context context;
    private List<MessageRow> messages;

    private LayoutInflater inflter;

    private int count = 0;

    public NoticeRowAdapter(Context context, List<MessageRow> messages) {
        this.context = context;
        this.messages = messages;
        this.inflter = (LayoutInflater.from(context));
        this.count = messages.size();
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
        view = inflter.inflate(R.layout.fragment_notice_working_listview, null);

        TextView numberDatePledge = (TextView) view.findViewById(R.id.number_full_date_pledge);
        TextView numberDatePledge1 = (TextView) view.findViewById(R.id.number_full_date_pledge1);
        TextView numberDatePledge2 = (TextView) view.findViewById(R.id.number_full_date_pledge2);
        numberDatePledge.setText(messages.get(position).getNumber());
        numberDatePledge1.setText(messages.get(position).getDate());
        numberDatePledge2.setText(messages.get(position).getMessage());

        return view;
    }
}
