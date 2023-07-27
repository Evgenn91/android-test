package dsk.altlombard.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductRow implements Serializable {
    //наименование изделия
    private String name;
    //залог по данному изделию
    private String loan;
    //оплачено по залогу
    private String paidOnLoan;

    public ProductRow(String name, String loan, String paidOnLoan) {
        this.name = name;
        this.loan = loan;
        this.paidOnLoan = paidOnLoan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getPaidOnLoan() {
        return paidOnLoan;
    }

    public void setPaidOnLoan(String paidOnLoan) {
        this.paidOnLoan = paidOnLoan;
    }
}
