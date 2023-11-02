package net.ziad.model;

public class CurrentAcount extends BanqueAccount {

    private double overDraft;

    public CurrentAcount() {
        super();
        this.overDraft = overDraft;
    }

    public CurrentAcount( String balance, double currency,  double overDraft) {
        super( balance, currency);
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "CurrentAcount{" +
                "overDraft=" + overDraft +"  "+super.toString()+
                '}';
    }

    @Override
    public String getType() {
        return "Current-Account";
    }


    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
