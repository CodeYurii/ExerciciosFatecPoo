public class Cargo {
    protected String nomeCargo;
    private double salarioCargo;

    public Cargo(String nomeCargo, double salarioCargo) {
        setNomeCargo(nomeCargo);
        setSalarioCargo(salarioCargo);
    }

    /**
     * Setter do nome do Cargo, verifica se o nome não é nulo ou se não foi preenchido.
     * @param nomeCargo Nome do cargo do funcionário.
     */
    public void setNomeCargo(String nomeCargo) {
        if (nomeCargo == null || nomeCargo.isBlank()) {throw new IllegalStateException("O nome do cargo deve ser preenchido");}
        this.nomeCargo = nomeCargo;
    }
    public double getSalarioCargo() {
        return salarioCargo;
    }

    /**
     * Setter do salário do cargo, verifica se o valor é maior que 0.
     * @param salarioCargo salário do cargo do funcionário.
     */
    public void setSalarioCargo(double salarioCargo) {
        if(salarioCargo <= 0){throw new IllegalStateException("O salário tem de ser maior que 0");}
        this.salarioCargo = salarioCargo;
    }
}
