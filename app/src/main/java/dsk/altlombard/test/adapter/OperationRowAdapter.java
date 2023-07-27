package dsk.altlombard.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.dto.OperationRow;
import dsk.altlombard.test.dto.PledgeRow;
import dsk.altlombard.test.dto.ProductRow;

import java.util.List;

public class OperationRowAdapter extends BaseAdapter {

    private Context context;
    private List<OperationRow> operations;

    private List<ProductRow> products;

    private LayoutInflater inflter;

    private int count = 0;

    public OperationRowAdapter(Context context, List<OperationRow> operations) {
        this.context = context;
        this.operations = operations;
        this.inflter = (LayoutInflater.from(context));
        this.count = operations.size();
    }

    public OperationRowAdapter(Context context, List<ProductRow> products, String xx) {
        this.context = context;
        this.products = products;
        this.inflter = (LayoutInflater.from(context));
        this.count = products.size();
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
        view = inflter.inflate(R.layout.fragment_pledge_working_one_listview, null);

        TextView numberDatePledge1 = (TextView) view.findViewById(R.id.number_date_pledge1);
        TextView numberDatePledge2 = (TextView) view.findViewById(R.id.number_date_pledge2);
        TextView numberDatePledge3 = (TextView) view.findViewById(R.id.number_date_pledge3);
        if(operations != null && operations.size() > 0) {
            numberDatePledge1.setText(operations.get(position).getDate());
            numberDatePledge2.setText(operations.get(position).getPercent());
            numberDatePledge3.setText(operations.get(position).getLoan());
        } else {
            numberDatePledge1.setText(products.get(position).getName());
            numberDatePledge2.setText(products.get(position).getLoan());
            numberDatePledge3.setText(products.get(position).getPaidOnLoan());
        }
        return view;
    }
}
