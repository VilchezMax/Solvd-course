package homework2.models;
/*
import java.util.ArrayList;

public abstract class Procedure {
    int procedureID;
    String modality;
    boolean interNetwork;
    double amount;

    public Procedure(int procedureID, boolean interNetwork,double amount) {
        this.procedureID=procedureID;
        this.modality = "Digital";
        this.interNetwork = interNetwork;
        this.amount=amount;
    }

    public int getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public boolean isInterNetwork() {
        return interNetwork;
    }

    public void setInterNetwork(boolean interNetwork) {
        this.interNetwork = interNetwork;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //METHODS
    public static int generateAccountID(ArrayList<Account> accountList){
        boolean newID=false;
        int id = 0;
        while (!newID){
            id =(int) Math.random()*1000;
            for (Account a:accountList){
                if(a.getAccountID()==id){
                    newID=false;
                    break;
                }
                newID=true;
            }
        }
        return id;
    }

    public void rollback(int procedureID, ArrayList<Procedure> procedureList, ArrayList<Account> accountList) {
        for(Procedure p:procedureList){
            if (p.getProcedureID()==procedureID){
                double amount=p.getAmount();
                if (p instanceof Transfer){
                    int destinationAccount=((Transfer) p).getInitial();
                    int initialAccount= ((Transfer) p).getDestination();
                    //TODO BUSCAR ACCOUNT....REFORMMATEAR TODO O USAR FINDBYID
                }

                break;
            }

    }

    }

}
*/