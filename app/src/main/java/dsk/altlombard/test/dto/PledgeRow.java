package dsk.altlombard.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PledgeRow implements Serializable {

    private String number;
    private String date;

    //оплата
    private String payment;
    //остаток
    private String remains;



    public PledgeRow() {
    }

    public PledgeRow(String number, String date, String payment, String remains) {
        this.number = number;
        this.date = date;
        this.payment = payment;
        this.remains = remains;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRemains() {
        return remains;
    }

    public void setRemains(String remains) {
        this.remains = remains;
    }

    @Override
    public String toString() {
        return "PledgeRow{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", payment='" + payment + '\'' +
                ", remains='" + remains + '\'' +
                '}';
    }
}
