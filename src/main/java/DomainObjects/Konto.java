package DomainObjects;

public class Konto {
    private String name;
    private String password;
    private int saldo;

    public Konto(String name, String password, int saldo) {
        this.name = name;
        this.password = password;
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int deposit(int i)
    {
        if (i > 0) {
            saldo = saldo + i;
        }
        return saldo;
    }

    public int withdraw(int i) {
        if (i > 0) {
            saldo = saldo - i;
        }
        return saldo;
    }

}
