package homework2.models;

/*
public class Client extends Adult{
    //ATTRIBUTES
    private int clientID;
    private boolean eligibilityForCredit;
    private Account accountID;
    private Tier tier;
    private Branch mainBranch;

    //CONSTRUCTOR
    public Client(String name, int age, int idNumber, String occupation,int creditScore,
                  int clientID,boolean eligibilityForCredit, Account accountID,
                  Branch mainBranch) {
        super(name, age, idNumber, occupation, creditScore);
        this.clientID=clientID;
        this.eligibilityForCredit=eligibilityForCredit;
        this.accountID=accountID;
        if(this.getCreditScore()<100){
            this.tier=Tier.bronze;
        } else if (this.getCreditScore()<200){
            this.tier=Tier.silver;
        } else if (this.getCreditScore()<300){
            this.tier=Tier.golden;
        } else {
            this.tier=Tier.solvd;
        }
        //TODO QUESTION: IT IS INITIALIZING ITS STATE BUT IS IMPLEMENTING THIS KIND OF LOGIC IN CONSTRUCTOR WRONG?
        this.mainBranch=mainBranch;
    }

    //SETTERS & GETTERS
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public boolean isEligibilityForCredit() {
        return eligibilityForCredit;
    }

    public void setEligibilityForCredit(boolean eligibilityForCredit) {
        this.eligibilityForCredit = eligibilityForCredit;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Branch getMainBranch() {
        return mainBranch;
    }

    public void setMainBranch(Branch mainBranch) {
        this.mainBranch = mainBranch;
    }

    //METHODS
    //Checks creditScore and upgrades if able.
    public void upgradeTier(){
        if (this.getCreditScore()>this.tier.getMaxScore() && tier!=Tier.solvd){
            for(Tier t:Tier.values()){
                if(this.getCreditScore()<t.getMaxScore()){
                    this.tier=t;
                    System.out.println("Upgraded to "+t+"\n"
                                       +"Interest discount: -"
                                       +t.getDisc()+"%"+"\n");
                    break;
                }
            }
        } else {
            System.out.println("Can't upgrade tier");
        }
    }
    public void transfer(int procedureID,Account initialAccount, Account finalAccount){
        Transfer trans = new Transfer(Bank.generateAccountID(),true,1000.00,83839,282839); //TODO: GENERATE PROCEDURE ID
    }
    public void deposit(int procedureID,Account initialAccount, Account finalAccount){

    }
}

*/
