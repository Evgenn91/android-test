package dsk.altlombard.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PledgeRow implements Serializable {

    private String number;
    private String date;

    //оплата по договору
    private String payment;
    //остаток по займу
    private String remains;
    private String perent;
    //ставка в день
    private String rate;



    public PledgeRow(String number, String date, String payment, String remains, String perent, String rate) {
        this.number = number;
        this.date = date;
        this.payment = payment;
        this.remains = remains;
        this.perent = perent;
        this.rate = rate;
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

    public String getPerent() {
        return perent;
    }

    public void setPerent(String perent) {
        this.perent = perent;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
