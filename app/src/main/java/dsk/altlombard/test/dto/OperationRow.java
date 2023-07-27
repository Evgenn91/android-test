package dsk.altlombard.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//операция по билету(оплата процентов и суммы от займа)
@Getter
@Setter
public class OperationRow implements Serializable {
    private String date;
    //оплаченные проценты по билету
    private String percent;
    //оплаченный займ по билету
    private String loan;


    public OperationRow(String date, String percent, String loan) {
        this.date = date;
        this.percent = percent;
        this.loan = loan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
}
