package homework2.models;


import java.util.ArrayList;
import java.util.Objects;

public class Branch extends Bank{
    //ATTRIBUTES
    private static ArrayList<Client> clientList;
    private String address;

    //CONSTRUCTOR
    public Branch(String address) {
        super();
        this.address = address;
        this.clientList=new ArrayList<>();
    }
    //SETTERS & GETTERS
    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void addClient(Client client) {
        this.clientList.add(client);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return address.equals(branch.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
